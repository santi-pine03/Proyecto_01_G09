package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

    @Query(value = "SELECT * FROM CATEGORIAS", nativeQuery=true)
    Collection<Categoria>darCategorias();

    //RF5
    @Query(value = "SELECT * FROM Categorias WHERE codigo = :codigo", nativeQuery=true)
    Categoria darCategoriaPorCodigo(@Param("codigo")Integer codigo);

    //RF5
    @Query(value = "SELECT * FROM Categorias WHERE nombre = :nombre", nativeQuery=true)
    Categoria darCategoriaPorNombre(@Param("nombre")String nombre);

    //RF5
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Categorias (codigo,nombre,descripcion,caracteristicasAlmacenamiento) VALUES(codigo.nextval, :nombre, :descripcion, :caracteristicasAlmacenamiento)", nativeQuery=true)
    void insertarCategoria(@Param("nombre")String nombre,@Param("descripcion")String descripcion,@Param("caracteristicasAlmacenamiento")String caracteristicasAlmacenamiento);
}
