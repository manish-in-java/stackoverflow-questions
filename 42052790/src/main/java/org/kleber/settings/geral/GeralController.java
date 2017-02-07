package org.kleber.settings.geral;

import org.kleber.settings.PropertyController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("geral")
public class GeralController extends PropertyController<Geral> {

	public GeralController() {
		super(Geral.class);
	}

}
