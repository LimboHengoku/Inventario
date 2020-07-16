package pe.com.utp.inventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InventarioRestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(InventarioRestApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InventarioRestApplication.class);
	}

}
