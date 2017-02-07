package org.kleber.settings;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class PropertyController<E extends Property> {
	
	@Autowired
	protected PropertyService<E> serv;
	
	protected Class<E> clazz;
	
	public PropertyController(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	@RequestMapping(value = "/get")
	@ResponseBody
	public String get(Model model) throws ClassNotFoundException, IOException {
		model.addAttribute("command", serv.get());
		return "settings";
	}
	
	@RequestMapping(value = "/set", method=RequestMethod.POST)
	public void set(Model model, @Valid E object, BindingResult result) throws IOException {
		serv.set(object);
	}

}
