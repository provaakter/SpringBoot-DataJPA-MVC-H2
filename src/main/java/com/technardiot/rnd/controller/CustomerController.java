package com.technardiot.rnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.technardiot.rnd.dao.CustomerRepo;
import com.technardiot.rnd.model.Customer;

@Controller
public class CustomerController {	
	@Autowired
	CustomerRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		return "create.jsp";
	}
		
	@RequestMapping("/addCustomer")
	public String addCustomer(Customer customer)
	{
		repo.save(customer);
		return "create.jsp";
	}
	
	@GetMapping("/getCustomer")
	public ModelAndView getCustomer(@RequestParam int tid)
	{
		ModelAndView mv = new ModelAndView("details.jsp");
		Customer customer = repo.findById(tid).orElse(new Customer());
		
		mv.addObject(customer);
		return mv;
	}
}