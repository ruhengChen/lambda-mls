package com.yatop.lambda.workflow.core.component.chartype;

import com.yatop.lambda.workflow.core.context.CharValueContext;
import org.springframework.beans.factory.InitializingBean;

public interface ICharType extends InitializingBean {
    //方法失败或异常抛出Exception，CharType类实现该接口，适当封装一些中间abstract组件类以便复用

    //是否需要标记被复制
    boolean needMarkDuplicated();

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

    //发生特征值查询时（展开对象，设置对象内容）
    void onQueryValue(CharValueContext context);

    //是否捕获特征值更改事件
    //返回false，否
    //返回true，是
    boolean catchUpdateValue();

    //发生特征值更改时（更新对象，设置对象内容，updateCharValue传入对象修改内容）
    void onUpdateValue(CharValueContext context);

    //必须，校验特征值正确性和合法性
    //返回false，不通过
    //返回true，通过
    boolean validateValue(CharValueContext context);
}
