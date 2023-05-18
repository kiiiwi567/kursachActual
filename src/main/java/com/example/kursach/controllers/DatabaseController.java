package com.example.kursach.controllers;

import com.example.kursach.models.DatabaseExporter;
import com.example.kursach.models.DatabaseImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class DatabaseController {
    private final DatabaseExporter databaseExporter;
    private final DatabaseImporter databaseImporter;

    @Autowired
    public DatabaseController(DatabaseExporter databaseExporter, DatabaseImporter databaseImporter) {
        this.databaseExporter = databaseExporter;
        this.databaseImporter = databaseImporter;
    }

    @PostMapping("/export/json")
    public String exportDatabaseToJson() throws IOException {
        String outputPath = "export/output.json"; // Относительный путь
        databaseExporter.exportDatabaseToJson(outputPath);
        return "redirect:/adminPage";
    }

    @PostMapping("/import/json")
    public String importDatabaseFromJson(@RequestParam("file") MultipartFile file) throws IOException {
        databaseImporter.importDatabaseFromJson(file);
        return "redirect:/adminPage";
    }
}
