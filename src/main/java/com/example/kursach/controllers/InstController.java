package com.example.kursach.controllers;

import com.example.kursach.models.Instrument;
import com.example.kursach.models.Category;
import com.example.kursach.services.CategService;
import com.example.kursach.services.InstService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class InstController {
    private final InstService instService;

    @GetMapping("/{idCateg}")
    public String categoryPage (@PathVariable String idCateg,
                                @RequestParam(name = "instName", required = false) String instName,
                                Model model)
    {
        model.addAttribute("instrument", instService.listReturn(instName, idCateg));
        //model.addAttribute("idCateg", idCateg);
        return "categoryPage";
    }

    @GetMapping("/{idCateg}/instrument/{ID}")
    public String infoInstrument(@PathVariable Long ID, Model model)
    {
        model.addAttribute("instrument", instService.getInstByID(ID));
        model.addAttribute("images", instService.getInstByID(ID).getImages());
        return "instInfo";
    }

    @PostMapping("/{idCateg}/instrument/create")
    public String createInstrument(@RequestParam("file1") MultipartFile file1,
                                   @RequestParam("file2") MultipartFile file2,
                                   @RequestParam("file3") MultipartFile file3,
                                   Instrument newInst) throws IOException {
        instService.saveInst(newInst, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/{idCateg}/instrument/delete/{ID}")
    public String deleteInstrument(@PathVariable("ID") Long ID){
        instService.delInst(ID);
        return "redirect:/";
    }

}
