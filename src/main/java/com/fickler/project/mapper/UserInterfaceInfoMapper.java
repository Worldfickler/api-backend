package com.fickler.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fickler.apicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author dell
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2023-09-02 00:11:07
* @Entity com.fickler.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    //select interfaceInfoId, sum(totalNum) as totalNum from user_interface_info group by interfaceInfoId order by totalNum desc limit 3;
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int list);
}




