package com.xinmu.strategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * author: xinmu
 * date: 2022/6/1
 * time: 10:43
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calculator {
    private Operation operation;

    public int doOperation(int num1, int num2){
        return operation.doOperation(num1, num2);
    }
}
