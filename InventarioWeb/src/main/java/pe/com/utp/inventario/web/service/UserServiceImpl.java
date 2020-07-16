package pe.com.utp.inventario.web.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.utp.inventario.response.ListaRolResponse;
import pe.com.utp.inventario.web.util.Properties;

@Service(value = "userService")
public class UserServiceImpl implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Properties properties;
	
	public ListaRolResponse listaRoles() {
		
		RestTemplate template = new RestTemplate();
		
		ListaRolResponse response = new ListaRolResponse();
		
		String url = properties.urlRestRoles;
		
		try {
			
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

			response = template.getForObject(builder.toUriString(), 
					ListaRolResponse.class);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}

}
