package org.kleber.settings.geral;

import org.kleber.settings.PropertyService;
import org.springframework.stereotype.Service;

@Service
public class GeralSettings extends PropertyService<Geral> {

	public GeralSettings() {
		super(Geral.class);
	}

}
