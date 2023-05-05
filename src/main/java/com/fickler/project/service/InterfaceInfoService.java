package com.fickler.project.service;

import com.fickler.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.fickler.project.model.entity.Post;

/**
* @author dell
* @description 针对表【interface_info(接口信息表)】的数据库操作Service
* @createDate 2023-05-05 09:54:58
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    /**
     * 校验
     *
     * @param interfaceInfo
     * @param add 是否为创建校验
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
