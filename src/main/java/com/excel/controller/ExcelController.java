package com.excel.controller;

import com.excel.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @GetMapping("/getData")
    public ResponseEntity<List<String[]>> getExcelData() {
        List<String[]> data = excelService.getData();
        return ResponseEntity.ofNullable(data);
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseEntity<List<String[]>> getExcelDataWebSocket() {
        List<String[]> data = excelService.getData();
        return ResponseEntity.ok(data);
    }
}
