package com.example.ApiRest.domain.service;

import com.example.ApiRest.persistence.entity.Coche;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CocheService {

    List<Coche> lista();

    void saveProcedure(Coche coche);
    Optional<Coche> getByid(int id);
    Optional<Coche> getByMarca(String marca);

    void borrar(int id);

    float mediaKm();
}
