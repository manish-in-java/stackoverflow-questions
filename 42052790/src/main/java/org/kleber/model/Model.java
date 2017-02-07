package org.kleber.model;

public abstract class Model extends Object {
	public abstract Object getId();
	
	public boolean equals(Model object) {
		return getId().equals(object);
	}
	
	public abstract String toString();
}
