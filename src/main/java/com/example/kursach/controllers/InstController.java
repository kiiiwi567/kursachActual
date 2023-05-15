package com.example.kursach.controllers;

import com.example.kursach.models.*;
import com.example.kursach.services.CategService;
import com.example.kursach.services.InstService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/category/{idCateg}")
public class InstController {
    private final InstService instService;
    private final CategService categService;
    //private final Bucket bucket;

    @GetMapping("")
    public String categoryPage (@RequestParam(name = "instName", required = false) String instName,
                                @RequestParam(name = "minPrice", required = false) Double minPrice,
                                @RequestParam(name = "maxPrice", required = false) Double maxPrice,
                                @RequestParam(name = "sortByName", required = false) boolean sortByName,
                                @RequestParam(name = "sortByPrice", required = false) boolean sortByPrice,
                                @PathVariable Long idCateg, Principal principal,
                                Model model)
    {
        model.addAttribute("instrument", instService.listReturn(instName, idCateg, minPrice, maxPrice, sortByName, sortByPrice));
        model.addAttribute("category", categService.getCategById(idCateg));
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        return "categoryPage";
    }

    @GetMapping("/instrument/{ID}")
    public String infoInstrument(@PathVariable("ID") Long ID, @PathVariable("idCateg") Long idCateg, Principal principal, Model model)
    {
        model.addAttribute("idCateg", idCateg);
        model.addAttribute("instrument", instService.getInstByID(ID));
        model.addAttribute("images", instService.getInstByID(ID).getImages());
        model.addAttribute("user", instService.getUserByPrincipal(principal));
        return "instInfo";
    }

    @PostMapping("/instrument/create")
    public String createInstrument(@RequestParam(name = "file1",required = false) MultipartFile file1,
                                   @RequestParam(name = "file2",required = false) MultipartFile file2,
                                   @RequestParam(name = "file3",required = false) MultipartFile file3,
                                   Instrument newInst, Principal principal, boolean isEdit) throws IOException {
        isEdit=false;
        instService.saveInst(principal ,newInst, file1, file2, file3, false);
        return "redirect:/category/{idCateg}";
    }

    @PostMapping("/instrument/delete/{ID}")
    public String deleteInstrument(@PathVariable("ID") Long ID,@PathVariable ("idCateg") Long idCateg, Model model){
        model.addAttribute("idCateg", idCateg);
        instService.delInst(ID);
        return "redirect:/category/{idCateg}";
    }


    @PostMapping("/instrument/edit/{ID}")
     public String editInstrument(@PathVariable("ID") Long ID, @PathVariable("idCateg") Long idCateg, Principal principal, Model model){
         model.addAttribute("idCateg", idCateg);
         model.addAttribute("instrument", instService.getInstByID(ID));
         model.addAttribute("images", instService.getInstByID(ID).getImages());
         model.addAttribute("user", instService.getUserByPrincipal(principal));
         return "editInst";
     }
     @PostMapping("/instrument/edit/{ID}/1")
     public String editInstrument(@RequestParam(name = "file1",required = false) MultipartFile file1,
                                  @RequestParam(name = "file2",required = false) MultipartFile file2,
                                  @RequestParam(name = "file3",required = false) MultipartFile file3,
                                  @PathVariable("ID") Long oldID,
                                  Instrument editedInst, Principal principal, boolean isEdit) throws IOException{
         isEdit=true;
         editedInst.setIdInst(oldID);
         instService.saveInst(principal ,editedInst, file1, file2, file3, isEdit);
         return "redirect:/category/{idCateg}/instrument/{ID}";
     }

    @GetMapping("/{idInst}/bucket")
    public String addBucket(@PathVariable("idInst") Long idInst, Principal principal, @PathVariable String idCateg) {
        if (principal==null) {
            return "redirect:/category/{idCateg}";
        }
        instService.addOrRemoveToUserBucket(idInst, instService.getUserByPrincipal(principal).getUserEmail(), true, null);
        return "redirect:/category/{idCateg}";
    }
}