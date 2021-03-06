package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import org.springframework.beans.factory.InitializingBean;

public interface ICharTypeClazz extends InitializingBean {
    //方法失败或异常抛出Exception，CharType类实现该接口，适当封装一些中间abstract组件类以便复用

    //是否捕获特征值新增事件
    //返回false，否
    //返回true，是
    boolean catchCreateValue();

    //发生特征值新增时（创建对象，设置对象内容）
    void onCreateValue(CharValueContext context);

    //是否捕获特征值删除事件
    //返回false，否
    //返回true，是
    boolean catchDeleteValue();

    //发生特征值删除时（删除对象）
    void onDeleteValue(CharValueContext context);

    //是否捕获特征值恢复事件
    //返回false，否
    //返回true，是
    boolean catchRecoverValue();

    //发生特征值恢复时（恢复对象）
    void onRecoverValue(CharValueContext context);

    //是否捕获特征值查询事件
    //返回false，否
    //返回true，是
    boolean catchQueryValue();

    //发生特征值查询时（展开对象，返回设置对象内容）
    void onQueryValue(CharValueContext context);

    //是否捕获特征值更改事件
    //返回false，否
    //返回true，是
    boolean catchUpdateValue();

    //发生特征值更改时（用于组件参数、执行调优参数，返回设置对象内容）
    void onUpdateValue(CharValueContext context);

    //是否捕获特征值完成事件
    //返回false，否
    //返回true，是
    boolean catchCompleteValue();

    //发生特征值完成时（用于输出特征，返回设置对象内容）
    void onCompleteValue(CharValueContext context);

    //是否捕获特征值校验事件
    //返回false，否
    //返回true，是
    boolean catchValidateValue();

    //校验特征值正确性和合法性
    //返回false，不通过
    //返回true，通过
    boolean onValidateValue(CharValueContext context);
}
