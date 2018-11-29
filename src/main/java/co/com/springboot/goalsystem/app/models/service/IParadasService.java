package co.com.springboot.goalsystem.app.models.service;

import java.util.List;

import co.com.springboot.goalsystem.app.models.dto.ItemsParadaDto;

public interface IParadasService {
	
	List<ItemsParadaDto> findDescripcionParadasAll();

}
