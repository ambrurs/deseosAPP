package co.com.springboot.goalsystem.app.models.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.springboot.goalsystem.app.models.dao.ICuadroSolucionesSetDao;
import co.com.springboot.goalsystem.app.models.dto.KmsDto;
import co.com.springboot.goalsystem.app.models.dto.ResponseInformeDosDto;
import co.com.springboot.goalsystem.app.models.dto.InformeUnoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsCocheLogicoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsCuadradoDto;
import co.com.springboot.goalsystem.app.models.dto.ResponseInformeUnoDto;
import co.com.springboot.goalsystem.app.models.entity.CuadrosSolucionesDet;
import co.com.springboot.goalsystem.app.models.service.ICuadroSolucionesDetService;
import co.com.springboot.goalsystem.app.models.util.DuracionTotalUtil;

@Service
public class CuadradoSolucionesDetServiceImpl implements ICuadroSolucionesDetService {

	 
	@Autowired
	private ICuadroSolucionesSetDao iCuadroSolucionesSetDao;
	
	public static Integer TIPO_VACIO = 1;
	public static Integer TIPO_COMERCIAL = 0;
	
	@Override
	public List<ItemsCuadradoDto> findByCuadroSolucionesAll() {
		// TODO Auto-generated method stub
		try {
			return (List<ItemsCuadradoDto>) iCuadroSolucionesSetDao.findByCodigoCuadradoAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public List<ItemsCocheLogicoDto> findByCocheLogicoAll() {
		// TODO Auto-generated method stub
		try {
			return (List<ItemsCocheLogicoDto>) iCuadroSolucionesSetDao.findByCocheLogicoAll();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	@Override
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityCodigoCuadro(Long codigoCuadro) {
		try {
			return (List<CuadrosSolucionesDet>) iCuadroSolucionesSetDao.findByCuadroSolucionesDetCodigoCuadro(codigoCuadro);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityNumeroSolucion(Integer numeroSolucion) {
		// TODO Auto-generated method stub
		try {		
			return (List<CuadrosSolucionesDet>) iCuadroSolucionesSetDao.findByCuadroSolucionesDetIdentityNumeroSolucion(numeroSolucion);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityCodigoCuadroAndCuadroSolucionesDetIdentityNumeroSolucion(
			Long codigoCuadro, Integer numeroSolucion) {
		// TODO Auto-generated method stub
		try {			
			return (List<CuadrosSolucionesDet>)  iCuadroSolucionesSetDao.findByCuadroSolucionesDetIdentityCodigoCuadroAndCuadroSolucionesDetIdentityNumeroSolucion(codigoCuadro, numeroSolucion);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	/**
	 * Metodo encargado de obtener la información solicitada para el informe uno
	 * */
	@Override
	public List<ResponseInformeUnoDto> informeUno(Long codigoCuadrado) {
		// TODO Auto-generated method stub
		List<ResponseInformeUnoDto> response = null;
		try {
			response = procesarInformacionInforme(iCuadroSolucionesSetDao.findInformeUno(codigoCuadrado));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

		return response;
	}
	
	/*Método que se encarga de retornar un listado de la clase ResponseInformeUnoDto,
	 * en este método se emplea la lógica de negocio necesaria para satisfacer el listado que compone el reporte uno
	 *  */
	private List<ResponseInformeUnoDto> procesarInformacionInforme(List<InformeUnoDto> informeUnoDto){
		try {
			List<ResponseInformeUnoDto> response = null;
			if (!informeUnoDto.isEmpty()) {
				response = new ArrayList<ResponseInformeUnoDto>();

				Set<Long> listCocheLogico = new HashSet<>();


				for (InformeUnoDto informeDto : informeUnoDto) {
					listCocheLogico.add(informeDto.getCocheLogico());
				}

				for (Long cocheLogico : listCocheLogico) {
					List<InformeUnoDto> infomeData = new ArrayList<>();
					List<String> duracionCoche = new ArrayList<String>();
					for (InformeUnoDto informeDos : informeUnoDto) {
						if (cocheLogico == informeDos.getCocheLogico()) {
							duracionCoche.add(informeDos.getDuracion());
						}
						infomeData.add(informeDos);
					}
					ResponseInformeUnoDto responseInforme = new ResponseInformeUnoDto();
					responseInforme.setInformeUnoDto(infomeData);
					responseInforme.setDuracionTotal(calcularDuracionTotal(duracionCoche).getDuracionTotal());
					response.add(responseInforme);
				}

			}
			return response;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}
	
	/*
	 * Metodo encargado de procesar la duración total de un listado de duraciones 
	 * */
	private DuracionTotalUtil calcularDuracionTotal(List<String> duracion) {
		try {
			DuracionTotalUtil duracionTotalUtil = new DuracionTotalUtil();
			for (String duracionValor : duracion) {
				String[] tiempo = duracionValor.split(":");

				for (int i = 0; i <= tiempo.length; i++) {

					switch (i) {
					case 0:
						duracionTotalUtil.sumarHora(Long.parseLong(tiempo[i]));
						break;
					case 1:
						duracionTotalUtil.sumarMinutos(Long.parseLong(tiempo[i]));
						break;
					case 2:
						duracionTotalUtil.sumarSegundos(Long.parseLong(tiempo[i]));
						break;

					default:
						break;
					}

				}

			}
			return duracionTotalUtil;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
	}

	/*Se crea este metodo que no esta contemplado dentro del lineamiento del ejercicio pero al no procesarlo por el cocheLogico
	 * la petición tarda demaciado al ser de 4000 registros */
	@Override
	public List<ResponseInformeUnoDto> findInformeUnoConCocheLogico(Long codigoCuadrado, Long cocheLogico) {
		// TODO Auto-generated method stub
		List<ResponseInformeUnoDto> response = null;
		try {
			response = procesarInformacionInforme(iCuadroSolucionesSetDao.findInformeUnoConCocheLogico(codigoCuadrado, cocheLogico));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return response;
	}

	/**
	 * Metodo encargado de procesar la información del informe dos segun los criterios necesarios
	 * */
	@Override
	public List<ResponseInformeDosDto> findInformeDos(Long codigoCuadrado, String[] paradas) {
		// TODO Auto-generated method stub
		List<ResponseInformeDosDto> response = new ArrayList<ResponseInformeDosDto>();
		try {
			for (int i = 0; i < paradas.length; i++) {
				Long parada = Long.parseLong(paradas[i]);
				List<ItemsCocheLogicoDto> itemsCocheLogico = iCuadroSolucionesSetDao.findCocheLogicoByParadas(codigoCuadrado,parada,parada);
				
				
				for (ItemsCocheLogicoDto itemsCocheLogicoDto : itemsCocheLogico) {
					
					Long recorridoVacio = 0l;
					Long recorridoTipoComercial = 0l;
					List<KmsDto> kmsVacio = iCuadroSolucionesSetDao.findDuracionByTipoEvento(itemsCocheLogicoDto.getCocheLogico(),
							codigoCuadrado, parada, parada, TIPO_VACIO);
					List<KmsDto> kmsComercial = iCuadroSolucionesSetDao.findDuracionByTipoEvento(itemsCocheLogicoDto.getCocheLogico(),
							codigoCuadrado, parada, parada, TIPO_COMERCIAL);
					
					for (KmsDto kmsDtoV : kmsVacio) {
						recorridoVacio = recorridoVacio + kmsDtoV.getDuracion();
					}
					
					for (KmsDto kmsDtoC : kmsComercial) {
						recorridoTipoComercial = recorridoTipoComercial + kmsDtoC.getDuracion();
					}
					
					ResponseInformeDosDto responseData = new ResponseInformeDosDto();
					responseData.setCocheLogico(itemsCocheLogicoDto.getCocheLogico());
					responseData.setKmsVacio(recorridoVacio);
					responseData.setKmsComercial(recorridoTipoComercial);
					response.add(responseData);
					
				}
				
				
			}
			return response;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			return null;
		}
		
	}


	

}
