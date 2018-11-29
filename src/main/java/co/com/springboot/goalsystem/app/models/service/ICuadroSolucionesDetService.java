package co.com.springboot.goalsystem.app.models.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.springboot.goalsystem.app.models.dto.ItemsCocheLogicoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsCuadradoDto;
import co.com.springboot.goalsystem.app.models.dto.ResponseInformeDosDto;
import co.com.springboot.goalsystem.app.models.dto.ResponseInformeUnoDto;
import co.com.springboot.goalsystem.app.models.entity.CuadrosSolucionesDet;


public interface ICuadroSolucionesDetService {
	
	public List<ItemsCuadradoDto> findByCuadroSolucionesAll();
	
	public List<ItemsCocheLogicoDto> findByCocheLogicoAll();

	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityCodigoCuadro(Long codigoCuadro);
	
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityNumeroSolucion(Integer numeroSolucion);
	
	
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityCodigoCuadroAndCuadroSolucionesDetIdentityNumeroSolucion(Long codigoCuadro,Integer numeroSolucion);

	public List<ResponseInformeUnoDto>  informeUno(Long codigoCuadrado);
	
	public List<ResponseInformeUnoDto> findInformeUnoConCocheLogico(Long codigoCuadrado, Long cocheLogico);
	
	public List<ResponseInformeDosDto> findInformeDos(Long codigoCuadrado, String[] paradas);
}
