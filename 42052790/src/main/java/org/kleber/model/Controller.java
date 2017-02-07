package org.kleber.model;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Controller<E> {
	@Autowired
	protected Service<E> serv;
	
	protected Class<E> clazz;
	
	public Controller(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	//insert object
	
	@RequestMapping("/insert")
	@PreAuthorize("hasPermission(#user, 'insert_'+#this.this.name)")
	public String insert(org.springframework.ui.Model model) throws InstantiationException, IllegalAccessException {
		model.addAttribute("command", serv.newObject());
		return "form/insert_"+getName();
	}
	
	@RequestMapping(value = "/insert", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasPermission(#user, 'insert_'+#this.this.name)")
	public void insert(@Valid E object, BindingResult result) {
		serv.insert(object);
	}
	
	//update object
	
	@RequestMapping("/update/{id}")
	@PreAuthorize("hasPermission(#user, 'update_'+#this.this.name)")
	public String update(org.springframework.ui.Model model, @PathVariable("id") String id) {
		model.addAttribute("command", serv.getObject(id));
		return "form/update_"+getName();
	}
	
	@RequestMapping(value = "/update", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasPermission(#user, 'update_'+#this.this.name)")
	public void update(@Valid E object, BindingResult result) {
		serv.update(object);
	}
	
	//delete object
	
	@RequestMapping("/delete/{id}")
	@PreAuthorize("hasPermission(#user, 'delete_'+#this.this.name)")
	public String delete(org.springframework.ui.Model model, @PathVariable("id") String id) {
		model.addAttribute("command", serv.getObject(id));
		return "form/delete_"+getName();
	}
	
	@RequestMapping(value = "/delete", method=RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasPermission(#user, 'delete_'+#this.this.name)")
	public void delete(@Valid E object, BindingResult result) {
		serv.delete(object);
	}
	
	//index page
	
	@RequestMapping("/")
	public String index() {
		return "list/"+getName()+".html";
	}
	
	@RequestMapping("/list.json")
	@ResponseBody
	public String list(@RequestParam(value="orderby", required=false) String orderby, @RequestParam(value="groupby", required=false) String groupby) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(serv.select(orderby, groupby));
	}
	
	public String getName() {
		return clazz.getSimpleName().toLowerCase();
	}

}
