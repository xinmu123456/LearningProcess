package com.xinmu.rpc.core.codec;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:31
 */

@Data
@Builder
public class RpcResponseBody implements Serializable {
    private Object retObject;
}
