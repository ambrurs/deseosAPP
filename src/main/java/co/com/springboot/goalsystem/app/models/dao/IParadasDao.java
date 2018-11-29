package co.com.springboot.goalsystem.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.com.springboot.goalsystem.app.models.dto.ItemsParadaDto;
import co.com.springboot.goalsystem.app.models.entity.Paradas;
/**
 * Clase encargada de ejecutar las consultas JPQL de la clase Paradas
 * Andres Marulanda
 * */
@Repository
public interface IParadasDao extends JpaRepository<Paradas, Long> {

	/*
	 * Metodo encargado de retornar un listado de descripciónes de las paradas con su respectivo id
	 * */
	@Query(" SELECT new  co.com.springboot.goalsystem.app.models.dto.ItemsParadaDto(descripParada,codigoParada)  FROM  Paradas p")
	public List<ItemsParadaDto> findDescripcionParadasAll();
	
}
