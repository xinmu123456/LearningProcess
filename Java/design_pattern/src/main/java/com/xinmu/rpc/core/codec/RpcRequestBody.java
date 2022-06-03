package com.xinmu.rpc.core.codec;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:27
 */

@Data
@Builder
public class RpcRequestBody implements Serializable {
    private String interfaceName;
    private String methodName;
    private Object[] parameters;
    private Class<?>[] paramTypes;
}
