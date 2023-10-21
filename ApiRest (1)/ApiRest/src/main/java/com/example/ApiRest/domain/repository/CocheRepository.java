package com.example.ApiRest.domain.repository;

import com.example.ApiRest.persistence.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {

    @Query(value = "{call lista_procedure() }", nativeQuery = true)
    List<Coche> list_procedure();

    @Query(value = "{call save_procedure(:marcaIn, :modeloIn, :anioIn, :kmIn )}", nativeQuery = true)
    void saveProcedure(
            @Param("marcaIn") String marcaIn,
            @Param("modeloIn") String modeloIn,
            @Param("anioIn") int anioIn,
            @Param("kmIn") int kmIn
    );

    @Query(value = "{call id_procedure(:idIn)}", nativeQuery = true)
    Optional<Coche> idProcedure(@Param("idIn") int idIn);

    @Query(value = "{call marca_procedure(:marcaIn)}", nativeQuery = true)
    Optional<Coche> marcaProcedure(@Param("marcaIn") String marcaIn);

    @Query(value = "{call delete_procedure(:idIn)}", nativeQuery = true)
    Optional<Coche> borrarProcedure(@Param("idIn") int idIn);

    @Query(value = "{call media_km()}", nativeQuery = true)
    float mediaKm();


}
