package com.example.kursach.controllers;

import com.example.kursach.models.BucketDTO;
import com.example.kursach.services.BucketService;
import com.example.kursach.services.InstService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

public class BucketController {
    private final BucketService bucketService;
    private final InstService instService;
    public BucketController(BucketService bucketService, InstService instService) {
        this.bucketService = bucketService;
        this.instService = instService;
    }

    @GetMapping("/bucket")
    public String aboutBucket(Model model, Principal principal) {
        if (principal==null){
            model.addAttribute("bucket", new BucketDTO());
        }
        else{
            BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDTO);
        }
        return "bucketPage";
    }

    @GetMapping("/bucket/{idInst}")
    public String addBucket(@PathVariable("idInst") Long idInst, Principal principal) {
        if (principal==null) {
            return "redirect:/";
        }
        instService.addToUserBucket(idInst, principal.getName());
        return "redirect:/";
    }
}
