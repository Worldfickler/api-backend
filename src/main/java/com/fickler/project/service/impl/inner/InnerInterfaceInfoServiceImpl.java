package com.fickler.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fickler.apicommon.model.entity.InterfaceInfo;
import com.fickler.apicommon.service.InnerInterfaceInfoService;
import com.fickler.project.common.ErrorCode;
import com.fickler.project.exception.BusinessException;
import com.fickler.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author Fickler
 * @date 2023/11/13 11:18
 */

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        // 参数校验
        if (StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建查询条件包装器
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);
        // 使用 InterfaceInfoMapper 的 selectOne 方法查询接口信息
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
