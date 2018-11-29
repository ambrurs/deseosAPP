package co.com.springboot.goalsystem.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.goalsystem.app.models.dto.KmsDto;
import co.com.springboot.goalsystem.app.models.dto.InformeUnoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsCocheLogicoDto;
import co.com.springboot.goalsystem.app.models.dto.ItemsCuadradoDto;
import co.com.springboot.goalsystem.app.models.entity.CuadroSolucionesDetIdentity;
import co.com.springboot.goalsystem.app.models.entity.CuadrosSolucionesDet;

/*
 * Clase encargada de hacer las consultas JPQL de la clase CuadrosSolucionesDet
 * 
 * Autor : Andres Marulanda
 * */

@Repository
public interface ICuadroSolucionesSetDao extends JpaRepository<CuadrosSolucionesDet, CuadroSolucionesDetIdentity> {

	/**
	 * Método que retorna un listado de los códigos cuadrados
	 * */
	@Query(" SELECT distinct new co.com.springboot.goalsystem.app.models.dto.ItemsCuadradoDto(c.cuadroSolucionesDetIdentity.codigoCuadro)"
			+ " FROM  CuadrosSolucionesDet c ORDER BY c.cuadroSolucionesDetIdentity.codigoCuadro ")
	public List<ItemsCuadradoDto> findByCodigoCuadradoAll();

	/*
	 *  Método que retorna un listado de cochesLogicos
	 * */
	@Query(" SELECT distinct new co.com.springboot.goalsystem.app.models.dto.ItemsCocheLogicoDto(c.cocheLogico) FROM CuadrosSolucionesDet c "
			+ " ORDER BY  c.cocheLogico ")
	public List<ItemsCocheLogicoDto> findByCocheLogicoAll();

	/**
	 * Método que retorna un listado de la clase CuadrosSolucionesDet segun el código cuadrado
	 * */
	@Query(" SELECT c FROM CuadrosSolucionesDet c WHERE  c.cuadroSolucionesDetIdentity.codigoCuadro = :codigoCuadro ")
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetCodigoCuadro(@Param("codigoCuadro") Long codigoCuadro);

	/*
	 * Método que retorna un listado de la clase CuadrosSolucionesDet segun el número de la solución
	 * */
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityNumeroSolucion(Integer numeroSolucion);

	/*
	 * Método que retorna un listado de la clase CuadrosSolucionesDet segun el código del cuadro y el número de la solución
	 * */
	public List<CuadrosSolucionesDet> findByCuadroSolucionesDetIdentityCodigoCuadroAndCuadroSolucionesDetIdentityNumeroSolucion(
			Long codigoCuadro, Integer numeroSolucion);

	/*
	 * Método que retorna un con la información del infrome uno segun el código cuadrado
	 * */
	@Query("SELECT new co.com.springboot.goalsystem.app.models.dto.InformeUnoDto(c.cocheLogico,po.descripParada,"
			+ "pd.descripParada,c.horaInicio, c.horaFin, c.duracion) "
			+ " FROM CuadrosSolucionesDet c join c.paradaOrigen po join " + " c.paradaDestino pd  "
			+ " WHERE c.cuadroSolucionesDetIdentity.codigoCuadro = :codigoCuadro and "
			+ " po.codigoParada != pd.codigoParada "
			+ " GROUP BY  c.cocheLogico, pd.descripParada, po.descripParada, c.horaInicio, c.horaFin, c.duracion ")
	public List<InformeUnoDto> findInformeUno(@Param("codigoCuadro") Long codigoCuadro);

	/*
	 * Método que retorna un con la información del infrome uno segun el código cuadrado y el coche lógico
	 * */
	@Query("SELECT new co.com.springboot.goalsystem.app.models.dto.InformeUnoDto(c.cocheLogico,po.descripParada,"
			+ "pd.descripParada,c.horaInicio, c.horaFin, c.duracion) "
			+ " FROM CuadrosSolucionesDet c join c.paradaOrigen po join " + " c.paradaDestino pd  "
			+ " WHERE c.cuadroSolucionesDetIdentity.codigoCuadro = :codigoCuadro and "
			+ " po.codigoParada != pd.codigoParada and c.cocheLogico = :cocheLogico "
			+ " GROUP BY  c.cocheLogico, pd.descripParada, po.descripParada, c.horaInicio, c.horaFin, c.duracion ")
	public List<InformeUnoDto> findInformeUnoConCocheLogico(@Param("codigoCuadro") Long codigoCuadro,
			@Param("cocheLogico") Long cocheLogico);

	/*
	 * Método que retorna un listado de los coches logicos de un código cuadrado y las paradas
	 * */
	@Query(" SELECT distinct new co.com.springboot.goalsystem.app.models.dto.ItemsCocheLogicoDto(c.cocheLogico) "
			+ " FROM CuadrosSolucionesDet c join c.paradaOrigen po join c.paradaDestino pd "
			+ " WHERE c.cuadroSolucionesDetIdentity.codigoCuadro = :codigoCuadro AND "
			+ " (po.codigoParada = :paradaOrigen OR pd.codigoParada = :paradaDestino ) ")
	public List<ItemsCocheLogicoDto> findCocheLogicoByParadas(@Param("codigoCuadro") Long codigoCuadro,
			@Param("paradaOrigen") Long paradaOrigen, @Param("paradaDestino") Long paradaDestino);
	
	/*
	 * Método que retorna un listado de kms logicos de un código cuadrado, las paradas y el coche lógico
	 * */
	
	@Query(" SELECT  new co.com.springboot.goalsystem.app.models.dto.KmsDto(c.kms) "
			+ " FROM CuadrosSolucionesDet c join c.paradaOrigen po join c.paradaDestino pd "
			+ " join c.cuadroSolucionesDetIdentity.tiposEventos te  "
			+ " WHERE c.cocheLogico = :cocheLogico AND c.cuadroSolucionesDetIdentity.codigoCuadro = :codigoCuadro"
			+ " AND (po.codigoParada = :paradaOrigen OR pd.codigoParada = :paradaDestino ) AND te.codigoTipoEvento = :codigoTipoEvento ")
	public List<KmsDto> findDuracionByTipoEvento(@Param("cocheLogico") Long cocheLogico,@Param("codigoCuadro")Long codigoCuadro,
				@Param("paradaOrigen")Long paradaOrigen,@Param("paradaDestino") Long paradaDestino,@Param("codigoTipoEvento")Integer codigoTipoEvento);
	
}
