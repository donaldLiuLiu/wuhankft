package com.kafutong.wuhankft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * main dispatcher controller
 * define models of  "/" 、 "/what"
 * @author freshJuice
 *
 */
@Controller
public class KftDispatcherController {
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(path="/kft", method=RequestMethod.GET)
	public String kft() {
		return "kft";
	}
	
	
	@RequestMapping(path="/info", method=RequestMethod.GET)
	public String info() {
		return "info";
	}
	
	@RequestMapping(path="/dl", method=RequestMethod.GET)
	public String dl() {
		return "dl";
	}
	
	@RequestMapping(path="/about", method=RequestMethod.GET)
	public String about() {
		return "about";
	}
	
	@RequestMapping(path="/join", method=RequestMethod.GET)
	public String join() {
		return "join";
	}
	
	@RequestMapping(path="/index_test")
	@ResponseBody
	public String index_test() {
		return "hello 中";
	}
}
