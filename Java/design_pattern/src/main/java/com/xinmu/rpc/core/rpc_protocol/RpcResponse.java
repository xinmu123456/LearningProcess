package com.xinmu.rpc.core.rpc_protocol;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * author: xinmu
 * date: 2022/5/31
 * time: 22:33
 */

@Data
@Builder
public class RpcResponse implements Serializable {
    //协议头
    private String header;

    //协议体
    private byte[] body;
}
