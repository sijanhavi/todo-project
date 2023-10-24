package com.todo.TODO;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class todoController {
	
	
	@Autowired
	itodo it;
	
	@RequestMapping("login")
	public String login()
	{
		return "login.jsp";
	}
	
	
	
	
	@RequestMapping("logindata")
	public String logindata(String username, String password)
	{
		if (username.equals("admin") && password.equals("admin"))
		{
			return "home.jsp";
		}
		else
		{
			return "login.jsp";
		}
	}
	
	
	@RequestMapping("todos")
	public ModelAndView todos(ModelMap mp)
	{
		mp.put("obj", it.findAll());
		ModelAndView mv = new ModelAndView();
		mv.addAllObjects(mp);
		
		mv.setViewName("todos.jsp");
		
		return mv;
	}
	
	@RequestMapping("delete")
	public String delete(int id)
	{
		it.deleteById(id);
		return "todos";
	}
	
	
	@RequestMapping("update")
	public String update(int id, ModelMap mp)
	{
		todo t1 = it.findById(id).get();
		mp.put("obj", t1);
		
		return "edittodo.jsp";
		
	}
	
	

	
	@RequestMapping(value = "/updatetodo", method = RequestMethod.GET)
	public String updatetodo(int id,String description, Date targetdate)
	{
		todo t1 = it.findById(id).get();
		
		t1.setId(id);
		t1.setUsername("admin");
		t1.setDescription(description);
		t1.setTargetdate(targetdate);
		 it.save(t1);
		return "redirect:/todos";	
		
	}
	
	@RequestMapping("addtodo")
	public String addtodo()
	{
		return "addtodo.jsp";
	}
	
//	@RequestMapping("submittodo")
//	public String submittodo(todo t)
//	{
//		
//		it.save(t);
//		return "home.jsp";
//		
//		
//	}
	
	
	@RequestMapping(value = "/submittodo", method = RequestMethod.GET)
	public String addtodo(String description, Date targetdate)
	{
		todo t1 = new todo();
		
		
		t1.setUsername("admin");
		t1.setDescription(description);
		t1.setTargetdate(targetdate);
		it.save(t1);
		return "redirect:/todos";	
		
	}
	
	
	
}
