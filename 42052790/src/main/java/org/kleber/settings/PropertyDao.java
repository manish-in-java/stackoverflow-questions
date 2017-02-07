package org.kleber.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class PropertyDao<E extends Property> {
	
	protected String url;
	
	protected Class<E> clazz;
	
	protected String filename;
	
	public PropertyDao(Class<E> clazz) {
		this.url = System.getProperty("user.home")+File.separator+".loja"+File.separator+"settings";
		this.clazz = clazz;
		this.filename = url + File.separator + clazz.getSimpleName().toLowerCase() + ".properties";
	}
	
	@SuppressWarnings("unchecked")
	public E get() throws IOException, ClassNotFoundException {
		E object = null;
		FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        object = (E) in.readObject();
        in.close();
        fileIn.close();
		return object;
	}
	
	public void set(E object) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(object);
		out.close();
		fileOut.close();
	}
	
}
