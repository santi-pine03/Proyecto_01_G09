package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.EspecificacionesEmpacado;

public interface EspecificacionesEmpacadoRepository extends JpaRepository<EspecificacionesEmpacado, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO EspecificacionesEmpacado (id, volumen, pesoGR) VALUES(id_especificaciones.nextval, :volumen, :pesoGR)", nativeQuery = true)
    void crearEspecificaciones(@Param("volumen")Integer volumen, @Param("pesoGR")Integer pesoGR);
}
