package com.fickler.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fickler.apicommon.model.entity.User;
import com.fickler.apicommon.service.InnerUserService;
import com.fickler.project.common.ErrorCode;
import com.fickler.project.exception.BusinessException;
import com.fickler.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author Fickler
 * @date 2023/11/13 11:17
 */

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 实现接口中的 getInvokeUser 方法，用于根据密钥获取内部用户信息
     * @param accessKey 密钥
     * @return 内部用户信息，如果找不到
     */
    @Override
    public User getInvokeUser(String accessKey) {
        System.out.println("成功调用内部接口");
        // 参数校验
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建查询条件包装器
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        // 使用 UserMapper de  selectOne 方法查询用户信息
        return userMapper.selectOne(queryWrapper);
    }
}
