package com.example.kursach.services;

import com.example.kursach.models.Instrument;
import com.example.kursach.repositories.InstRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InstService {
    private final InstRepository instRepository;

    public List<Instrument> listReturn(String instName) {
        if (instName != null) return instRepository.findByInstName(instName);
        return instRepository.findAll();
    }

    public void saveInst (Instrument newInst) {
        newInst.setIdInst(instRepository.findTopByOrderByIdInstDesc().getIdInst() + 1);
        //todo check for invalid entries + error message if so, no saving
        log.info("Saving new {}", newInst);
        instRepository.save(newInst);
    }
    public void delInst (Long instId) {
        instRepository.deleteById(instId);
    }

    public Instrument getInstByID (Long instId){
        return instRepository.findById(instId).orElse(null);
    }
}
