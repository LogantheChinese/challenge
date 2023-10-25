package com.example.demo.controller;

import com.example.demo.domain.ResponseResult;
import com.example.demo.domain.entity.IfStatement;
import com.example.demo.service.IfStatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping
public class IfStatementController {

    @Autowired
    private IfStatementService ifStatementService;

    @PostMapping("/ifStatement")
    public ResponseResult createStatement(@RequestBody IfStatement ifStatement){
        return ifStatementService.updateStatement(ifStatement);
    }

    @PutMapping("/ifStatement")
    public ResponseResult updateStatement(@RequestBody IfStatement ifStatement){
        return ifStatementService.updateStatement(ifStatement);
    }

    @PostMapping("/result")
    public ResponseResult evaluateResult(@RequestBody Map<String,Object> map){
        return ifStatementService.evaluateResult(map);
    }

    @PostMapping("/translation")
    public ResponseResult translateFormat(@RequestBody String json){
        return ifStatementService.translateFormat(json);
    }

}
