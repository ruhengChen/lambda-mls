package com.yatop.lambda.core.utils;

import com.yatop.lambda.base.model.SysParameter;
import com.yatop.lambda.core.enums.DataStatusEnum;
import com.yatop.lambda.core.enums.SystemParameterEnum;
import com.yatop.lambda.core.mgr.system.SystemParameterMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class SystemParameterUtil {

    private static HashMap<String, SysParameter> systemParameterBoard;

    @Autowired
    public void setSystemParameterBoard(SystemParameterMgr systemParameterMgr) {
        systemParameterBoard = new HashMap<String, SysParameter>();
        List<SysParameter> sysParameters = systemParameterMgr.querySystemParameter();
        if(DataUtil.isNotEmpty(sysParameters)) {
            for (SysParameter sysParameter : sysParameters) {
                if(DataUtil.isBlank(sysParameter.getParamValue()) || sysParameter.getStatus() == DataStatusEnum.INVALID.getStatus())
                    continue;

                systemParameterBoard.put(sysParameter.getParamCode(), sysParameter);
            }
        }
    }

    private static String find(SystemParameterEnum paramEnum) {
        if(DataUtil.isNull(paramEnum))
            return null;

        if(DataUtil.isBlank(paramEnum.getParamCode()))
            return DataUtil.trim(paramEnum.getParamDefaultValue());

        SysParameter param = systemParameterBoard.get(paramEnum.getParamCode());
        if(DataUtil.isNull(param))
            return DataUtil.trim(paramEnum.getParamDefaultValue());

        return DataUtil.trim(param.getParamValue());
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
