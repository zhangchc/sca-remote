package com.phoenix.sca.service.api.sysdept.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.phoenix.sca.common.utils.ThreadLocalHelp;
import com.phoenix.sca.entity.sysdept.SysDept;
import com.phoenix.sca.entity.userinfo.UserInfo;
import com.phoenix.sca.facade.api.sysdept.SysDeptService;
import com.phoenix.sca.facade.api.sysdept.dto.SysDeptRequest;
import com.phoenix.sca.facade.api.sysdept.dto.SysDeptResponse;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoResponse;
import com.phoenix.sca.mapper.sysdept.SysDeptMapper;
import com.phoenix.sca.mapper.userinfo.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/1/9 13:31
 */
@Slf4j
@Service
@RefreshScope
public class SysDeptServiceImpl implements SysDeptService {

    @Resource
    private SysDeptMapper sysDeptfoMapper;
    @Resource
    private MapperFacade mapperFacade;
    @Override
    public Boolean saveDeptInfo(SysDeptRequest request) {
        SysDept sysDept =mapperFacade.map(request, SysDept.class);
        sysDept.setCreateBy(ThreadLocalHelp.getCurrentUserName());
       int i = sysDeptfoMapper.insertSelective(sysDept);
       if(i>0){
           return Boolean.TRUE;
       }
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateDeptInfo(SysDeptRequest request) {
        return null;
    }

    @Override
    public PageInfo<SysDeptResponse> selectUserInfoBycon(SysDeptRequest request) {
        PageInfo<SysDeptResponse> resultDto;
        SysDept sysDept =mapperFacade.map(request, SysDept.class);
        PageHelper.startPage(Math.max(request.getPageNo(), 1), Math.min(request.getPageSize(), 100));
       List<SysDept> sysDeptList =sysDeptfoMapper.selectByCond(sysDept);
        PageInfo<SysDept> pageInfo = new PageInfo(sysDeptList);
        List<SysDeptResponse> sysDeptResponse = mapperFacade.mapAsList(sysDeptList, SysDeptResponse.class);
        resultDto = new PageInfo<>(sysDeptResponse);
        resultDto.setTotal(pageInfo.getTotal());
        return resultDto;
    }

    @Override
    public SysDeptResponse selectUserInfoByUserId(SysDeptRequest request) {
        return null;
    }
}
