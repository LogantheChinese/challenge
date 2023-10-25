package com.example.demo.service;

import com.example.demo.domain.ResponseResult;
import com.example.demo.domain.entity.IfStatement;

import java.io.IOException;
import java.util.Map;

public interface IfStatementService {

    ResponseResult updateStatement(IfStatement ifStatement);

    ResponseResult evaluateResult(Map<String,Object> context);

    ResponseResult translateFormat(String json);
}
