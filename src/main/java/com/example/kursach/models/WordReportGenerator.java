package com.example.kursach.models;

import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WordReportGenerator {

    public static void generateReport(List<OrderDetail> orderDetailsList) {
        // Создание нового документа Word
        XWPFDocument document = new XWPFDocument();

        // Создание таблицы

        XWPFTable table = document.createTable();
        XWPFTableRow headerRow = table.getRow(0);
        headerRow.createCell();
        headerRow.getCell(0).setText("ID заказа");
        headerRow.createCell();
        headerRow.getCell(1).setText("Email");
        headerRow.createCell();
        headerRow.getCell(2).setText("Номер телефона");
        headerRow.createCell();
        headerRow.getCell(3).setText("Дата заказа");
        headerRow.createCell();
        headerRow.getCell(4).setText("Дата доставки");
        headerRow.createCell();
        headerRow.getCell(5).setText("Стоимость");
        headerRow.createCell();
        headerRow.getCell(6).setText("Тип");
        headerRow.createCell();
        headerRow.getCell(7).setText("Инструменты");
        headerRow.createCell();
        headerRow.getCell(8).setText("Статус");


        // Заполнение данными из списка
        for (OrderDetail orderDetail : orderDetailsList) {
            XWPFTableRow row = table.createRow();
            row.getCell(0).setText(String.valueOf(orderDetail.getIdOrder()));
            row.getCell(1).setText(orderDetail.getUserEmail());
            row.getCell(2).setText(orderDetail.getUserPhone());
            row.getCell(3).setText(orderDetail.getOrderCrDate().toString());
            row.getCell(4).setText(orderDetail.getOrderDelivDate().toString());
            row.getCell(5).setText(String.valueOf(orderDetail.getOrderSum()));
            row.getCell(6).setText(orderDetail.getOrderType());
            row.getCell(7).setText(String.join(", ", orderDetail.getOrderInstList()));
            row.getCell(8).setText(orderDetail.getStatus());

            if ("Выполнен".equals(orderDetail.getStatus())) {
                for (int j = 0; j < row.getTableCells().size(); j++) {
                    CTShd cellShading = row.getCell(j).getCTTc().addNewTcPr().addNewShd();
                    cellShading.setFill("00FF00"); // Зеленый цвет
                    cellShading.setVal(STShd.CLEAR);
                }
            } else if ("Активный".equals(orderDetail.getStatus())) {
                for (int j = 0; j < row.getTableCells().size(); j++) {
                    CTShd cellShading = row.getCell(j).getCTTc().addNewTcPr().addNewShd();
                    cellShading.setFill("FFFF00"); // Желтый цвет
                    cellShading.setVal(STShd.CLEAR);
                }
            } else if ("Новый".equals(orderDetail.getStatus())) {
                for (int j = 0; j < row.getTableCells().size(); j++) {
                    CTShd cellShading = row.getCell(j).getCTTc().addNewTcPr().addNewShd();
                    cellShading.setFill("FF0000"); // Красный цвет
                    cellShading.setVal(STShd.CLEAR);
                }
            }

            // Сохранение документа в файл
            String filePath = "E:\\kursachActual\\export\\отчёт.docx";
            try (FileOutputStream out = new FileOutputStream(filePath)) {
                document.write(out);
                System.out.println("Отчет успешно сохранен.");
            } catch (IOException e) {
                System.out.println("Ошибка при сохранении отчета: " + e.getMessage());
            }

            // Открытие сгенерированного отчета с помощью приложения по умолчанию
            String os = System.getProperty("os.name").toLowerCase();
            try {
                if (os.contains("win")) {
                    // Для Windows
                    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", filePath);
                    builder.start();
                } else if (os.contains("mac")) {
                    // Для macOS
                    ProcessBuilder builder = new ProcessBuilder("open", filePath);
                    builder.start();
                } else if (os.contains("nix") || os.contains("nux")) {
                    // Для Linux и Unix
                    ProcessBuilder builder = new ProcessBuilder("xdg-open", filePath);
                    builder.start();
                } else {
                    System.out.println("Не удалось определить операционную систему.");
                }
            } catch (IOException e) {
                System.out.println("Ошибка при открытии файла: " + e.getMessage());
            }
        }

    }
}
