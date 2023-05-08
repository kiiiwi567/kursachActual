package com.example.kursach.services;

import com.example.kursach.models.Instrument;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class InstService {
    private List<Instrument> instruments = new ArrayList<>();
    private int id = 0;

    {
        instruments.add(new Instrument(++id,"testName1",10.10,1,"testDescription"));
        instruments.add(new Instrument(++id,"testName2",10.10,2,"testDescriptiongyutuy"));
    }
    public List<Instrument> listReturn() {
        return instruments;
    }
    public void saveInst (Instrument newInst) {
        newInst.setID(++id);
        if (newInst.getName().isEmpty()) newInst.setName("AdminEblan"); //todo
        instruments.add(newInst);
    }
    public void delInst (int ID) {
        instruments.removeIf(instrument -> instrument.getID() == ID);
    }

    public Instrument getInstByID (int ID){
        for (Instrument instrument: instruments){
            if (instrument.getID() == ID) return instrument;
        }
        return null;
    }
}
