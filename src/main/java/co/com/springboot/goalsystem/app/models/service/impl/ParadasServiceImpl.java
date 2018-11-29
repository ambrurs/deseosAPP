package co.com.springboot.goalsystem.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.springboot.goalsystem.app.models.dao.IParadasDao;
import co.com.springboot.goalsystem.app.models.dto.ItemsParadaDto;
import co.com.springboot.goalsystem.app.models.service.IParadasService;

@Service
public class ParadasServiceImpl implements IParadasService {

	@Autowired
	private IParadasDao iParadasDao;
	
	/**Metodo encargado de retornar un listado de la clase  ItemsParadaDto*/
	
	@Override
	public List<ItemsParadaDto> findDescripcionParadasAll() {
		// TODO Auto-generated method stub
		return (List<ItemsParadaDto>) iParadasDao.findDescripcionParadasAll();
	}

}
