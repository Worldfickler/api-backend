package com.fickler.project.service.impl;

import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fickler.project.common.ErrorCode;
import com.fickler.project.exception.BusinessException;
import com.fickler.project.model.entity.InterfaceInfo;
import com.fickler.project.service.InterfaceInfoService;
import com.fickler.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author dell
 * @description ��Ա�interface_info(�ӿ���Ϣ��)�������ݿ����Serviceʵ��
 * @createDate 2023-05-05 09:54:58
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {

    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {

        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        Long userId = interfaceInfo.getUserId();
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        Date createTime = interfaceInfo.getCreateTime();
        Date updateTime = interfaceInfo.getUpdateTime();
        Integer isDelete = interfaceInfo.getIsDelete();

        // ����ʱ�����в�������ǿ�
        // todo ����У��
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50L) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "���ݹ���");
        }
    }

}




