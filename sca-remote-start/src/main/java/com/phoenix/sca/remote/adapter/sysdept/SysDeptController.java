package com.phoenix.sca.remote.adapter.sysdept;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.phoenix.sca.common.response.PageResponseInfo;
import com.phoenix.sca.common.response.ResponseCode;
import com.phoenix.sca.common.response.ResponseInfo;
import com.phoenix.sca.facade.api.sysdept.SysDeptService;
import com.phoenix.sca.facade.api.sysdept.dto.SysDeptRequest;
import com.phoenix.sca.facade.api.sysdept.dto.SysDeptResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * 描述:
 *
 * @author zhangzhang
 * @date 2024/1/9 14:16
 */
@Slf4j
@RestController
@RequestMapping("/dept")
@RefreshScope
public class SysDeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @RequestMapping(value = "/saveDeptInfo", method = RequestMethod.POST)
    public ResponseInfo saveDeptInfo(@RequestBody SysDeptRequest sysDeptRequest) {
        Boolean result = sysDeptService.saveDeptInfo(sysDeptRequest);
        if (result) {
            return ResponseInfo.build(ResponseCode.SUCCESS_CODE.getCode(), "新增部门信息成功！", null);

        }
        return ResponseInfo.build(ResponseCode.SYS_ERROR_CODE.getCode(), "新增部门信息异常！", null);

    }

    /**
     * 获取部门列表查询
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/getDeptList", method = RequestMethod.POST)
    public PageResponseInfo getDeptList(@RequestBody SysDeptRequest sysDeptRequest) {
        PageResponseInfo result;

        log.info("获取部门列表 入参：{}", JSONObject.toJSONString(sysDeptRequest));
        if (Objects.isNull(sysDeptRequest)) {
            log.error("入参对象为null");
            return PageResponseInfo.paramError(ResponseCode.PARAM_ERROR_CODE.getMessage());
        }
        PageInfo<SysDeptResponse> pageInfo = sysDeptService.selectDdptBycon(sysDeptRequest);
        Long total = pageInfo.getTotal();
        result = PageResponseInfo.success(pageInfo.getList(), total.intValue());
        return result;
    }

    /**
     * 更新部门信息
     * @param sysDeptRequest
     * @return
     */
    @RequestMapping(value = "/updateDept", method = RequestMethod.POST)
    public ResponseInfo updateDeptInfo(@RequestBody SysDeptRequest sysDeptRequest) {
        Boolean result = sysDeptService.updateDeptInfo(sysDeptRequest);
        if (result) {
            return ResponseInfo.build(ResponseCode.SUCCESS_CODE.getCode(), "更新部门信息成功！", null);
        }
        return ResponseInfo.build(ResponseCode.SYS_ERROR_CODE.getCode(), "更新部门信息失败！", null);
    }
}
