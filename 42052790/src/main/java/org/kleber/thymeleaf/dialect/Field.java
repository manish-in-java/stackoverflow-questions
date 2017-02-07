package org.kleber.thymeleaf.dialect;

import java.util.HashSet;
import java.util.Set;

import org.kleber.thymeleaf.processor.field.Datalist;
import org.kleber.thymeleaf.processor.field.Fieldset;
import org.kleber.thymeleaf.processor.field.Input;
import org.kleber.thymeleaf.processor.field.Label;
import org.kleber.thymeleaf.processor.field.Option;
import org.kleber.thymeleaf.processor.field.Select;
import org.kleber.thymeleaf.processor.field.Textarea;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;

public class Field extends AbstractDialect {

	public String getPrefix() {
		return "field";
	}
	
	public Set<IProcessor> getProcessors() {
		Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new Datalist());
		processors.add(new Fieldset());
		processors.add(new Input());
		processors.add(new Label());
		processors.add(new Option());
		processors.add(new Select());
		processors.add(new Textarea());
		return processors;
	}

}
