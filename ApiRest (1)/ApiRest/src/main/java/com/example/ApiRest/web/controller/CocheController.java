package com.example.ApiRest.web.controller;

import com.example.ApiRest.domain.service.CocheServiceImpl;
import com.example.ApiRest.persistence.entity.Coche;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/coche")
public class CocheController {
    @Autowired
    CocheServiceImpl cocheService;

    @GetMapping("/lista")
    public ResponseEntity<List<Coche>> lista(){
        List<Coche> lista = cocheService.lista();
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> save(@RequestBody Coche coche){
        cocheService.saveProcedure(coche);
        return new ResponseEntity<>("car saved", HttpStatus.CREATED);
    }

    @GetMapping("/verId/{id}")
    public ResponseEntity<Coche> getById(@PathVariable("id") int id){
        Optional<Coche> coche = cocheService.getByid(id);
        return new ResponseEntity(coche, HttpStatus.OK);

    }

    @GetMapping("/verMarca/{marca}")
    public ResponseEntity<Coche> getByMarca(@PathVariable("marca") String marca){
        Optional<Coche> coche = cocheService.getByMarca(marca);
        return new ResponseEntity(coche, HttpStatus.OK);
    }

    @GetMapping("/media")
    public ResponseEntity<Float> getMedia(){
        return new ResponseEntity(cocheService.mediaKm(), HttpStatus.OK);
    }

    @DeleteMapping("borrar/{id}")
    public ResponseEntity<Coche> borrarById(@PathVariable("id") int id){
        cocheService.borrar(id);
        return new ResponseEntity("car deleted", HttpStatus.OK);
    }
}
