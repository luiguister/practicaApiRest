package com.example.ApiRest.domain.service;

import com.example.ApiRest.domain.repository.CocheRepository;
import com.example.ApiRest.persistence.entity.Coche;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CocheServiceImpl implements CocheService{
    @Autowired
    CocheRepository cocheRepository;

    @Override
    public List<Coche> lista() {
        return cocheRepository.list_procedure();
    }

    @Override
    public void saveProcedure(Coche coche) {

        cocheRepository.saveProcedure(coche.getMarca(), coche.getModelo(), coche.getAnio(), coche.getKm());
    }

    @Override
    public Optional<Coche> getByid(int id) {
        return cocheRepository.idProcedure(id);
    }

    @Override
    public Optional<Coche> getByMarca(String marca) {
        return cocheRepository.marcaProcedure(marca);
    }

    @Override
    public void borrar(int id) {
        cocheRepository.borrarProcedure(id);
    }

    @Override
    public float mediaKm() {
        return cocheRepository.mediaKm();
    }

}
