package com.fickler.project.model.dto.interfaceinfo;

import lombok.Data;

/**
 * @author dell
 * @date 2023/8/31 23:14
 */

@Data
public class InterfaceInfoInvokeRequest {

    /**
     * 主键
     */
    private Long id;


    /**
     * 用户请求参数
     */
    private String userRequestParams;


    private static final long serialVersionUID = 1L;

}
