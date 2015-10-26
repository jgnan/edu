package study.springboot.starter.restapi.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExampleController {
	@RequestMapping("/")
	public String list(Map<String, Object> model){
		return "";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String view(Map<String, Object> model,@PathVariable("id")Long id){
		return "";
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newForm(Map<String, Object> model){
		return "";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String create(Map<String, Object> model){
		return "";
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public String editForm(Map<String, Object> model,@PathVariable("id")Long id){
		return "";
	}
	
	@RequestMapping(value="/{id}/",method=RequestMethod.POST)
	public String update(Map<String, Object> model){
		return "";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.POST)
	public String delete(Map<String, Object> model){
		return "";
	}

  @RequestMapping(value="/delete",method=RequestMethod.POST)
  public String deleteAll(Map<String, Object> model){
    return "";
  }
}
