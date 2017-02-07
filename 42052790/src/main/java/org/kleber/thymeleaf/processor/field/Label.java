package org.kleber.thymeleaf.processor.field;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.processor.element.AbstractElementProcessor;

public class Label extends AbstractElementProcessor {

	public Label() {
		super("label");
	}

	@Override
	public ProcessorResult processElement(Arguments arguments, Element element) {
		return ProcessorResult.OK;
	}

	@Override
	public int getPrecedence() {
		return 0;
	}

}
