package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.pojo.Info;
import com.demo.pojo.test;
import com.demo.service.InfoService;

@Controller
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	@Autowired
	private test te;
	
	
	@RequestMapping("/find")
	@ResponseBody
	public Info findById(int id){
		return infoService.findById(id);
	}
	@RequestMapping("/findAll")
	@ResponseBody
	public List<Info> findAll(){
		System.out.println("excute all");
		return infoService.findAll();
	}
	@RequestMapping("/index")
	public String showPage(Model model){
		infoService.findAll();
		model.addAttribute("list", "sssss");
		return "index";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(){
		return te.language();
	}
	
}
