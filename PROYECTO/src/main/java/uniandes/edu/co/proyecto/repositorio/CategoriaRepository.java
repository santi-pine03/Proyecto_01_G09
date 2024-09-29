package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    @Query(value = "SELECT * FROM Categorias", nativeQuery=true)
    Collection<Categoria>darCategorias();

    @Query(value = "SELECT * FROM Categorias WHERE codigo = :codigo", nativeQuery=true)
    Categoria darCategoriaPorCodigo(@Param("codigo")Integer codigo);

    @Query(value = "SELECT * FROM Categorias WHERE nombre = :nombre", nativeQuery=true)
    Categoria darCategoriaPorNombre(@Param("nombre")String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Categorias (codigo,nombre,descripcion,caracteristicasAlmacenamiento) VALUES(codigoCategorias.nextval, :nombre, :descripcion, :caracteristicasAlmacenamiento)", nativeQuery=true)
    void insertarCategoria(@Param("nombre")String nombre,@Param("descripcion")String descripcion,@Param("caracteristicasAlmacenamiento")String caracteristicasAlmacenamiento);
}