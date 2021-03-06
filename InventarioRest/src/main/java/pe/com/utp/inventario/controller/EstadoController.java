package pe.com.utp.inventario.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import pe.com.utp.inventario.response.ListaEstadoResponse;
import pe.com.utp.inventario.service.EstadosService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@RequestMapping(value = "/estado")
@CrossOrigin(origins = "*")
public class EstadoController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private EstadosService estadoService;
	
	@ApiOperation(value = "lista")
	@GetMapping(value = "listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarEstados(){
		
		ListaEstadoResponse response = new ListaEstadoResponse();
		
		try {
			SimpleDateFormat formato = new SimpleDateFormat("ddMMyyyyHHmm");
			Date fechaSistema = new Date();
			String idTrans = formato.format(fechaSistema);
			
			response = estadoService.listarEstados(idTrans);
			
		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(response, HttpStatus.OK); 
		
	}
}
