package com.yatop.lambda.workflow.core.component.chartype;

import com.yatop.lambda.workflow.core.richmodel.IRichModel;

public class CharValue {
    private String charValue;	//特征值内容
    private Integer isDuplicated;
    private String inText;		//传入文本内容，所有新值以文本内容方式传入
    private String outText;		//传出文本内容，代码脚本、普通JSON对象 & JSON数组、算法参数等以文本内容方式进行传出
    private IRichModel outObject;	//传出对象内容，outText之外的非基础特征类型以对象内容方式进行传出
}
