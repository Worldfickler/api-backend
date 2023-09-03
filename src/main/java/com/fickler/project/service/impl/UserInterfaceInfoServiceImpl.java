package com.fickler.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fickler.project.common.ErrorCode;
import com.fickler.project.exception.BusinessException;
import com.fickler.project.model.entity.InterfaceInfo;
import com.fickler.project.model.entity.UserInterfaceInfo;
import com.fickler.project.service.UserInterfaceInfoService;
import com.fickler.project.mapper.UserInterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author dell
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2023-09-02 00:11:08
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {

        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        // 如果是添加操作
        if (add) {
            if (userInterfaceInfo.getUserId() <= 0 || userInterfaceInfo.getInterfaceInfoId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }

    // todo 添加事务和锁来确保数据的准确性
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断(其实这里还应该校验存不存在，这里就不用校验了，因为它如果不存在，也更新不到那条记录)
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 使用 UpdateWrapper 对象构建更新条件
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        // setSql 方法用户设置要更新的 SQL 语句。这里通过 SQL 表达式实现了两个字段的更新操作
        // leftNum = leftNum - 1 和 totalNum = totalNum + 1
        // 意思是将 leftNuM 字段减一，totalNum 字段加一
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }

}




