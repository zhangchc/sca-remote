package com.zhang.sca.common.response;

public interface BizResponseStatus {

    Integer SUCCESS_CODE = 1;

    Integer PARAM_ERROR_CODE = 400;


    Integer SYSTEM_ERROR_CODE = 500;


    /**
     * 随访表单过期
     */
    Integer FOLLOW_FROM_EXPIRED = 1002;

    /**
     * 随访计划接口异常
     */
    Integer FOLLOW_PLAN_ERROR_CODE = 1001;
    Integer FOLLOW_TEMPLATE_ERROR = 1010;

    Integer FOLLOW_FROM_REPEAT =1003;

    //强制移交主诊医生
    Integer NEED_CHANGE_DOCTOR = 1004;

    //未设置强制移交主诊医生
    Integer NO_NEED_CHANGE_DOCTOR = 1005;

    //不是主诊医生
    Integer NOT_ATTENDING_DOCTOR = 1006;
    /**
     * 接口缺失必要参数
     */
    Integer LOGIN_MISSING_CONDITION = 1007;

    /**
     * 查询对象不存在
     * */
    Integer NOT_PRESENT = 10001;

    /**
     * code验证错误
     * */
    Integer INCORRECT_CHECK_CODE = 10002;

    /**
     * 密码验证错误
     * */
    Integer INCORRECT_PASSWORD = 10003;

    /**
     * 失败code
     */
    Integer FAILURE_CODE = 20000;
    
    String TK_SUCCESS_CODE = "000_000_000";

    /**
     * 患者状态更新频繁
     */
    Integer PATIENT_STATUS_FREQUENTLY = 20001;

}
