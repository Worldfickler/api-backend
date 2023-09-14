package com.fickler.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fickler.project.common.ErrorCode;
import com.fickler.project.exception.BusinessException;
import com.fickler.apicommon.model.entity.InterfaceInfo;
import com.fickler.project.service.InterfaceInfoService;
import com.fickler.project.mapper.InterfaceInfoMapper;
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

        // ��ȡ�ӿڶ�������
        String name = interfaceInfo.getName();

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




