package org.kleber;

import org.kleber.thymeleaf.dialect.Field;
import org.kleber.thymeleaf.dialect.Form;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;

@Configuration
public class ThymeleafConfig {
	
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new Form());
		engine.addDialect(new Field());
		return engine;
	}
	
}
