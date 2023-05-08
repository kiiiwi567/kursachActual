package com.example.kursach.controllers;

import com.example.kursach.models.Instrument;
import com.example.kursach.services.InstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class Controller1 {
    private final InstService instService;

    @GetMapping("/")
    public String mainPage (Model model)
    {
        model.addAttribute("instrument", instService.listReturn());
        return "mainPage";
    }

    @GetMapping("/instrument/{ID}")
    public String infoInstrument(@PathVariable int ID, Model model)
    {
        model.addAttribute("instrument", instService.getInstByID(ID));
        return "instInfo";
    }

    @PostMapping("/instrument/create")
    public String createInstrument(Instrument newInst){
        instService.saveInst(newInst);
        return "redirect:/";
    }

    @PostMapping("/instrument/delete/{ID}")
    public String deleteInstrument(@PathVariable("ID") int ID){
        instService.delInst(ID);
        return "redirect:/";
    }

}
