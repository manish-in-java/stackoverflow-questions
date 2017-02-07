package org.kleber;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@RequestMapping("/admin")
	@PreAuthorize("hasPermission(#user, 'admin')")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/c/{id}")
	public String categoria(@PathVariable("id") String id) {
		return "categoria";
	}
	
	@RequestMapping("/p/{id}")
	public String produto(@PathVariable("id") String id) {
		return "produto";
	}
	
	@RequestMapping("/page/{titulo}")
	public String pagina(@PathVariable("titulo") String titulo) {
		return "pagina";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/wishlist")
	public String wishlist() {
		return "wishlist";
	}
	
	@RequestMapping("/order")
	public String order() {
		return "order";
	}
}
