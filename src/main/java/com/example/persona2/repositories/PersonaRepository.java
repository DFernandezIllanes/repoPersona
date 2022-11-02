package com.example.persona2.repositories;

//DAO: patron que propone separar la logica de negocio de la logica para acceder a la BD

import com.example.persona2.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {

    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //boolean existsByDni(int id);

    /* %?n% n indica el numero del parametro para realizar la busqueda. Usando esta forma, no se debe usar @Param
       %:nombre% nombre indica el nombre del parametro para realizar la busqueda, debe ser indicado mediante @Param("nombre") T t
     */
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);
}
