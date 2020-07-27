package pe.com.utp.inventario.controller;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.com.utp.inventario.response.ListarAntivirusResponse;
import pe.com.utp.inventario.response.ListarProcesadoresResponse;
import pe.com.utp.inventario.service.DatosRelacionadosService;
import pe.com.utp.inventario.util.Constantes;

@RestController
@CrossOrigin(origins = "*")
@Api(value="datos relaxionados")
public class DatosRelacionadosController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private DatosRelacionadosService datosRelacionadosService;

	@ApiOperation(value = "lista")
	@GetMapping(value = "antivirus/listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarAntivirus() {

		ListarAntivirusResponse response = new ListarAntivirusResponse();

		try {

			response = datosRelacionadosService.listarAntivirus();

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@ApiOperation(value = "lista")
	@GetMapping(value = "procesadores/listar", headers = Constantes.HEADER_JSON)
	public ResponseEntity<?> listarProcesadores() {

		ListarProcesadoresResponse response = new ListarProcesadoresResponse();

		try {

			response = datosRelacionadosService.listarProcesadores();

		} catch (Exception e) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
