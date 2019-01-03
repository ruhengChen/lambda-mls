package com.yatop.lambda.core.utils;

import com.yatop.lambda.base.model.SysParameter;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.mgr.system.SystemParameterMgr;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class SystemParameterUtil implements InitializingBean {

    @Autowired
    SystemParameterMgr systemParameterMgr;

    private static HashMap<String, SysParameter> ALL_SYSTEM_PARAMETERS = new HashMap<String, SysParameter>();

    @Override
    public void afterPropertiesSet() throws Exception {
        loadSystemParameter();
    }

    private void loadSystemParameter() {
        ALL_SYSTEM_PARAMETERS.clear();
        List<SysParameter> sysParameters = systemParameterMgr.querySystemParameter();
        if(DataUtil.isNotEmpty(sysParameters)) {
            for (SysParameter sysParameter : sysParameters) {
                if(DataUtil.isBlank(sysParameter.getParamValue()) || sysParameter.getStatus() == DataStatusEnum.INVALID.getStatus())
                    continue;

                ALL_SYSTEM_PARAMETERS.put(sysParameter.getParamCode(), sysParameter);
            }
        }
    }

    public static String find(String paramCode) {
        if(DataUtil.isNotBlank(paramCode)) {
            SysParameter param = ALL_SYSTEM_PARAMETERS.get(paramCode);
            if(DataUtil.isNotNull(param))
                return DataUtil.trim(param.getParamValue());
        }
        return null;
    }

    private static String find(SystemParameterEnum paramEnum) {
        if(DataUtil.isNull(paramEnum))
            return null;

        String paramValue = find(paramEnum.getParamCode());
        return DataUtil.isNotEmpty(paramValue) ? paramValue : DataUtil.trim(paramEnum.getParamDefaultValue());
    }

    public static String find4String(SystemParameterEnum paramEnum) {
        return SystemParameterUtil.find(paramEnum);
    }

    public static String find4String(SystemParameterEnum paramEnum, String isNullDefaultValue) {
        String value = SystemParameterUtil.find4String(paramEnum);
        return DataUtil.isNotNull(value) ? value : isNullDefaultValue;
    }

    public static Boolean find4Boolean(SystemParameterEnum paramEnum) {
        String value = SystemParameterUtil.find(paramEnum);

        if(DataUtil.isBlank(value))
            return null;

        if(DataUtil.equalsIgnoreCase(value, "true"))
            return true;

        if(DataUtil.equalsIgnoreCase(value, "false"))
            return false;

        return null;
    }

    public static Boolean find4Boolean(SystemParameterEnum paramEnum, Boolean isNullDefaultValue) {
        Boolean value = SystemParameterUtil.find4Boolean(paramEnum);
        return DataUtil.isNotNull(value) ? value : isNullDefaultValue;
    }

    public static Integer find4Integer(SystemParameterEnum paramEnum) {
        String value = SystemParameterUtil.find(paramEnum);

        if(DataUtil.isNotDigits(value))
            return null;

        return Integer.parseInt(value);
    }

    public static Integer find4Integer(SystemParameterEnum paramEnum, Integer isNullDefaultValue) {
        Integer value = SystemParameterUtil.find4Integer(paramEnum);
        return DataUtil.isNotNull(value) ? value : isNullDefaultValue;
    }

    public static Long find4Long(SystemParameterEnum paramEnum) {
        String value = SystemParameterUtil.find(paramEnum);

        if(DataUtil.isNotDigits(value))
            return null;

        return Long.parseLong(value);
    }

    public static Long find4Long(SystemParameterEnum paramEnum, Long isNullDefaultValue) {
        Long value = SystemParameterUtil.find4Long(paramEnum);
        return DataUtil.isNotNull(value) ? value : isNullDefaultValue;
    }

    public static Float find4Float(SystemParameterEnum paramEnum) {
        String value = SystemParameterUtil.find(paramEnum);

        if(DataUtil.isNotNumberic(value))
            return null;

        return Float.parseFloat(value);
    }

    public static Float find4Float(SystemParameterEnum paramEnum, Float isNullDefaultValue) {
        Float value = SystemParameterUtil.find4Float(paramEnum);
        return DataUtil.isNotNull(value) ? value : isNullDefaultValue;
    }

    public static Double find4Double(SystemParameterEnum paramEnum) {
        String value = SystemParameterUtil.find(paramEnum);

        if(DataUtil.isNotNumberic(value))
            return null;

        return Double.parseDouble(value);
    }

    public static Double find4Double(SystemParameterEnum paramEnum, Double isNullDefaultValue) {
        Double value = SystemParameterUtil.find4Double(paramEnum);
        return DataUtil.isNotNull(value) ? value : isNullDefaultValue;
    }
}
