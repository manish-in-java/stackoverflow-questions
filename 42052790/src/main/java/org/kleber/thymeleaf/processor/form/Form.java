package org.kleber.thymeleaf.processor.form;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

public class Form extends AbstractElementProcessor {

	public Form() {
		super("form");
	}

	@Override
	protected ProcessorResult processElement(Arguments arguments, Element element) {
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
