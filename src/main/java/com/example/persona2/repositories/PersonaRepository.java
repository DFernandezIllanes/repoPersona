package com.example.persona2.repositories;

//DAO: patron que propone separar la logica de negocio de la logica para acceder a la BD

import com.example.persona2.entities.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
