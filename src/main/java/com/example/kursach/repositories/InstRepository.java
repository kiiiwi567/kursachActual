package com.example.kursach.repositories;

import com.example.kursach.models.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstRepository extends JpaRepository<Instrument, Long> {
    List<Instrument> findByInstName (String InstName);
    Instrument findTopByOrderByIdInstDesc();
    List<Instrument> findAllByIdCateg(Long idCateg);
    List<Instrument> findAllByInstPriceBetweenAndIdCateg(Double minPrice, Double maxPrice, Long idCateg);
    List<Instrument> findAllByIdCategOrderByInstName(Long idCateg);
    List<Instrument> findAllByIdCategOrderByInstNameAscInstPriceAsc(Long idCateg);
    List<Instrument> findAllByIdCategOrderByInstPrice(Long idCateg);

}
