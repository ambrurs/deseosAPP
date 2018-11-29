package co.com.springboot.goalsystem.app.models.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.springboot.goalsystem.app.models.dto.ItemsCocheLogicoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsCuadradoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsParadaDto;
import co.com.springboot.goalsystem.app.models.dto.ResponseInformeDosDto;
import co.com.springboot.goalsystem.app.models.dto.ResponseInformeUnoDto;
import co.com.springboot.goalsystem.app.models.entity.CuadrosSolucionesDet;
import co.com.springboot.goalsystem.app.models.service.ICuadroSolucionesDetService;
import co.com.springboot.goalsystem.app.models.service.IParadasService;
import co.com.springboot.goalsystem.app.models.util.CustomErrorMsg;

@RestController
@RequestMapping("/goalsystem/v1")
public class InformesController {

	@Autowired
	private ICuadroSolucionesDetService iCuadroSolucionesDet;
	
	@Autowired
	private IParadasService iParadasService;
	
	/*Metodo encargado de retornar un listado de cuadrados*/
	@GetMapping("/codigoCuadrados")
	public ResponseEntity<?> findCodigosCuadrado(){
		try {
			
			List<ItemsCuadradoDto> itemsCuadrado = iCuadroSolucionesDet.findByCuadroSolucionesAll();
			
			if(itemsCuadrado == null) {
				return new ResponseEntity(new CustomErrorMsg("No se encontraron códigos  cuadrados"), HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<ItemsCuadradoDto>>(itemsCuadrado,HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new CustomErrorMsg("Se presento un error obteniendo los códigos cuadrados"), HttpStatus.BAD_REQUEST);
		}
	}
	
	/*Metodo encargado de retornar un listado de coches*/
	@GetMapping("/cocheLogico")
	public ResponseEntity<?> findCocheLogico(){
		try {
			
			List<ItemsCocheLogicoDto> itemsCoche = iCuadroSolucionesDet.findByCocheLogicoAll();
			
			if(itemsCoche == null) {
				return new ResponseEntity(new CustomErrorMsg("No se encontraron coches lógicos"),HttpStatus.OK);
			}
			
			return new ResponseEntity<List<ItemsCocheLogicoDto>>(itemsCoche,HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new CustomErrorMsg("Se presento un error obteniendo los coches lógicos"), HttpStatus.BAD_REQUEST);
		}
	}
	
	/*Metodo encargado de retornar un listado de paradas*/
	@GetMapping("/paradas")
	public ResponseEntity<?> findParadas(){
		try {
			List<ItemsParadaDto> itemsParadas = iParadasService.findDescripcionParadasAll();
			
			if(itemsParadas == null) {
				return new ResponseEntity(new CustomErrorMsg("No se encontraron paradas"),HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<ItemsParadaDto>>(itemsParadas,HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new CustomErrorMsg("Se presento un error obteniendo las paradas"), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	/*Metodo encargado de retornar un listado de la información que conforma el informe uno*/
	@GetMapping("/informeUno/{id}")
	public ResponseEntity<?> findInformeUno(@PathVariable("id")Long id,@RequestParam(value = "idCoche",required = false) Long cocheLogico){
		
		try {
			
			List<ResponseInformeUnoDto> responseInforme = null;
			
			
			if(cocheLogico != null) {
				responseInforme = iCuadroSolucionesDet.findInformeUnoConCocheLogico(id, cocheLogico);
			}
			
			if(cocheLogico == null) {
				responseInforme = iCuadroSolucionesDet.informeUno(id);
			}
				
			if(responseInforme == null) {
				return new ResponseEntity(new CustomErrorMsg("No se encontró información asociada al id".concat(id.toString()).concat(" para generar el informe"))
						, HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<ResponseInformeUnoDto>>(responseInforme,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new CustomErrorMsg("Se presento un error generando el informe del id ".concat(id.toString())) , HttpStatus.BAD_REQUEST);
		}
				
	}
	/*Metodo encargado de retornar un listado de la información que conforma el informe dos*/
	@GetMapping("/informeDos/{id}/{paradas}")
	public ResponseEntity<?> findInformeDos(@PathVariable("id")Long id,@PathVariable("paradas") String[] paradas){
		try {
			
			List<ResponseInformeDosDto> responseInforme = iCuadroSolucionesDet.findInformeDos(id, paradas);
			
			if(responseInforme == null) {				
				return new ResponseEntity(new CustomErrorMsg("No se encontró  información asociada al id ".concat(id.toString())), HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<ResponseInformeDosDto>>(responseInforme, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity(new CustomErrorMsg("Se presento un error generando el informe del id ".concat(id.toString())),HttpStatus.BAD_REQUEST);
		}
	}
	
	
}
