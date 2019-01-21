package com.yatop.lambda.workflow.core.framework.chartype;

import com.yatop.lambda.workflow.core.utils.CollectionUtil;

import java.util.HashMap;

public abstract class CharTyeClazzBaseClazz implements ICharTypeClazz {

    //<class-path, bean-object>
    private static final HashMap<String, ICharTypeClazz> CLAZZ_BEANS = new HashMap<String, ICharTypeClazz>();

    public static ICharTypeClazz getClazzBean(String clazzPath) {
        return CollectionUtil.get(CLAZZ_BEANS, clazzPath);
    }

    private static void putClazzBean(String clazzPath, ICharTypeClazz charTypeBean) {
        CollectionUtil.put(CLAZZ_BEANS, clazzPath, charTypeBean);
    }

    public CharTyeClazzBaseClazz() {
        CharTyeClazzBaseClazz.putClazzBean(this.getClass().getName(), this);
    }
}
