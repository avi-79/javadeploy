package com.springmvc.etg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.etg.model.Product;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		Product product =new Product();
		//product.setProductid("1000");
		//product.setProductname("HP Monitor");
		model.addAttribute("productModel", product);
		return "productform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insertProduct(@Valid @ModelAttribute ("productModel") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "productform";
		}
		else {
			//call some method
			return "home";
		}
	}
	
	@ModelAttribute("citylist")
	public List<String> fillCity(){
		List<String> list = new ArrayList<String>();
		list.add("Bangalore");
		list.add("Chennai");
		list.add("Hyderabad");
		list.add("Pune");
		list.add("Delhi");
		return list;
	}
	
	
}
