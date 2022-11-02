package com.example.persona2.services;

import com.example.persona2.entities.Persona;

import java.util.List;

public interface PersonaService extends BaseService<Persona, Long> {
    List<Persona> search(String filtro) throws Exception;
}
