package org.kleber.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Form extends AbstractDialect {

	public String getPrefix() {
		return "form";
	}
	
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new org.kleber.thymeleaf.processor.form.Form());
		return processors;
	}

}
