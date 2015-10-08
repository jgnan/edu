package study.springmvc.lesson1.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {
	@RequestMapping("/hello")
	public String hello(Map<String, Object> model){
		return "hello";
	}
}
