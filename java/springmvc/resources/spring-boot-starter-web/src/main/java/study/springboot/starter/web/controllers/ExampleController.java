package study.springboot.starter.web.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/examples")
public class ExampleController {
	@RequestMapping("/")
	public String index(Map<String, Object> model){
		return "/examples/index";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String view(Map<String, Object> model,@PathVariable("id")Long id){
		return "/examples/view";
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	public String newForm(Map<String, Object> model){
		return "/examples/new";
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String create(Map<String, Object> model){
		long id = 0;
		return "redirect:/examples/"+id;
	}
	
	@RequestMapping(value="/{id}/edit",method=RequestMethod.GET)
	public String editForm(Map<String, Object> model,@PathVariable("id")String id){
		return "/examples/edit";
	}
	
	@RequestMapping(value="/{id}/",method=RequestMethod.POST)
	public String update(Map<String, Object> model){
		long id = 0l;
		return "redirect:/examples"+id;
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.POST)
	public String delete(Map<String, Object> model,@PathVariable("id")String id){
		return "redirect:/examples/";
	}

  @RequestMapping(value="/delete",method=RequestMethod.POST)
  public String deleteAll(Map<String,Object> model){
    return "redirect:/examples/";
  }
}
