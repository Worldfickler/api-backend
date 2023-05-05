package com.fickler.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fickler.project.model.entity.InterfaceInfo;
import com.fickler.project.service.InterfaceInfoService;
import com.fickler.project.mapper.InterfaceInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【interface_info(接口信息表)】的数据库操作Service实现
* @createDate 2023-05-05 09:54:58
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{

}




