package services;


import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("services")
public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources) {
		resources.add(UsuarioWS.class);
		resources.add(AcaoWS.class);
		resources.add(EnderecoWS.class);
		resources.add(HemocentroWS.class);
		resources.add(DoacaoWS.class);
	}

}
