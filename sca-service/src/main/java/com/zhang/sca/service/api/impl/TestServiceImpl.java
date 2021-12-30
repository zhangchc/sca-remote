package com.zhang.sca.service.api.impl;

import com.zhang.sca.facade.TestService;
import com.zhang.sca.mapper.FormDataMapper;
import com.zhang.sca.mapper.TDdmAppInfoMapper;
import com.zhang.sca.model.po.TDdmAppInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("testService")
public class TestServiceImpl implements TestService {
    @Resource
    private FormDataMapper formDataMapper;

    @Resource
    private TDdmAppInfoMapper tDdmAppInfoMapper;
    public String testQuery() {
        log.info("<<<<<<<<--------------");
//        String tableName ="t_app_info";
//        List<Long> ids = new ArrayList<Long>();
//        ids.add(1l);
//        formDataMapper.getFormData(tableName,ids);

        TDdmAppInfo tdm=tDdmAppInfoMapper.selectByEnterpriseIdAndAppId(1002l,222l);
        return null;
    }
}
