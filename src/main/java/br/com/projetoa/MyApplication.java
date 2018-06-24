package br.com.projetoa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;




public class MyApplication extends Application {
	
	

	
	@Override
	public Set<Class<?>> getClasses() {
		 Set<Class<?>> classes = new HashSet<Class<?>>();
	        classes.add(JacksonFeature.class);
	        return classes;
	}
	
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
	
		properties
				.put("jersey.config.server.provider.packages", "br.com.projetoa");
		
		return properties;
	}

}
