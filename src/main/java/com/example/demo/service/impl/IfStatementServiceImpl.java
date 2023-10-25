package com.example.demo.service.impl;

import com.example.demo.domain.ResponseResult;
import com.example.demo.domain.entity.IfStatement;
import com.example.demo.enumpkg.AppHttpCodeEnum;
import com.example.demo.exception.SystemException;
import com.example.demo.service.IfStatementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class IfStatementServiceImpl implements IfStatementService {
    @Override
    public ResponseResult updateStatement(IfStatement ifStatement) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("IfStatement.json"),ifStatement);
        } catch (IOException e) {
            throw new SystemException(AppHttpCodeEnum.WRITE_ERROR);
        }
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult evaluateResult(Map<String, Object> context){
        ObjectMapper objectMapper = new ObjectMapper();
        IfStatement ifStatement;
        try {
            ifStatement = objectMapper.readValue(new File("IfStatement.json"), IfStatement.class);
        } catch (IOException e) {
            throw new SystemException(AppHttpCodeEnum.READ_ERROR);
        }
        boolean r = (Boolean)ifStatement.evaluate(context);
        return ResponseResult.okResult(r);
    }

    @Override
    public ResponseResult translateFormat(String json) {
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
    }

}
