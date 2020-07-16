package pe.com.utp.inventario.web.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

	@Value("${inventario.rest.url.login}")
	public String urlRestLogin;
	
	@Value("${inventario.rest.url.usuario.roles}")
	public String urlRestRoles;
	
}
