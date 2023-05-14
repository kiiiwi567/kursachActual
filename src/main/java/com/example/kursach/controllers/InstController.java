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
import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/category")
public class InstController {
    private final InstService instService;
    private final CategService categService;

    @GetMapping("/{idCateg}")
    public String categoryPage (@RequestParam(name = "instName", required = false) String instName,
                                @PathVariable Long idCateg, Principal principal,
                                Model model)
    {
        model.addAttribute("instrument", instService.listReturn(instName, idCateg));
        model.addAttribute("category", categService.getCategById(idCateg));
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        return "categoryPage";
    }

    @GetMapping("/{idCateg}/instrument/{ID}")
    public String infoInstrument(@PathVariable("ID") Long ID, @PathVariable("idCateg") Long idCateg, Principal principal, Model model)
    {
        model.addAttribute("idCateg", idCateg);
        model.addAttribute("instrument", instService.getInstByID(ID));
        model.addAttribute("images", instService.getInstByID(ID).getImages());
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        return "instInfo";
    }

    @PostMapping("/{idCateg}/instrument/create")
    public String createInstrument(@RequestParam(name = "file1",required = false) MultipartFile file1,
                                   @RequestParam(name = "file2",required = false) MultipartFile file2,
                                   @RequestParam(name = "file3",required = false) MultipartFile file3,
                                   Instrument newInst, Principal principal) throws IOException {
        instService.saveInst(principal ,newInst, file1, file2, file3);
        return "redirect:/category/{idCateg}";
    }

    @PostMapping("/{idCateg}/instrument/delete/{ID}")
    public String deleteInstrument(@PathVariable("ID") Long ID,@PathVariable ("idCateg") Long idCateg, Model model){
        model.addAttribute("idCateg", idCateg);
        instService.delInst(ID);
        return "redirect:/category/{idCateg}";
    }

    @PostMapping("/{idCateg}/instrument/edit/{ID}")
    public String editInstrument(@PathVariable("ID") Long ID, @PathVariable("idCateg") Long idCateg, Principal principal, Model model){
        model.addAttribute("idCateg", idCateg);
        model.addAttribute("instrument", instService.getInstByID(ID));
        model.addAttribute("images", instService.getInstByID(ID).getImages());
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        return "editInst";
    }
    @PostMapping("/{idCateg}/instrument/edit/{ID}/1")
    public String editInstrument(@RequestParam(name = "file1",required = false) MultipartFile file1,
                                 @RequestParam(name = "file2",required = false) MultipartFile file2,
                                 @RequestParam(name = "file3",required = false) MultipartFile file3,
                                 Instrument editedInst, Principal principal) throws IOException{
        instService.saveInst(principal ,editedInst, file1, file2, file3);
        return "redirect:/{idCateg}/instrument/{ID}";
    }

}
