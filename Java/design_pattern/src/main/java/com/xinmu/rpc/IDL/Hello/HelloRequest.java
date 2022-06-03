package com.xinmu.rpc.IDL.Hello;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:20
 */

@Data
@AllArgsConstructor
public class HelloRequest implements Serializable {
    private String name;
}
