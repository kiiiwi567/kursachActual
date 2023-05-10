package com.example.kursach.controllers;

import com.example.kursach.models.Instrument;
import com.example.kursach.services.InstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class InstController {
    private final InstService instService;

    @GetMapping("/")
    public String mainPage (@RequestParam(name = "instName", required = false) String instName, Model model)
    {
        model.addAttribute("instrument", instService.listReturn(instName));
        return "mainPage";
    }

    @GetMapping("/instrument/{ID}")
    public String infoInstrument(@PathVariable Long ID, Model model)
    {
        model.addAttribute("instrument", instService.getInstByID(ID));
        model.addAttribute("images", instService.getInstByID(ID).getImages());
        return "instInfo";
    }

    @PostMapping("/instrument/create")
    public String createInstrument(@RequestParam("file1") MultipartFile file1,
                                   @RequestParam("file2") MultipartFile file2,
                                   @RequestParam("file3") MultipartFile file3,
                                   Instrument newInst) throws IOException {
        instService.saveInst(newInst, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/instrument/delete/{ID}")
    public String deleteInstrument(@PathVariable("ID") Long ID){
        instService.delInst(ID);
        return "redirect:/";
    }

}
