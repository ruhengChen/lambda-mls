package com.yatop.lambda.workflow.core.framework.chartype;

import java.util.HashMap;

public abstract class CharTyeClazzBaseClazz implements ICharTypeClazz {

    //<class-path, bean-object>
    private static final HashMap<String, ICharTypeClazz> CLAZZ_BEANS = new HashMap<String, ICharTypeClazz>();

    public static ICharTypeClazz getClazzBean(String clazzPath) {
        return CLAZZ_BEANS.get(clazzPath);
    }

    private static void putClazzBean(String clazzPath, ICharTypeClazz charTypeBean) {
        CLAZZ_BEANS.put(clazzPath, charTypeBean);
    }

    public CharTyeClazzBaseClazz() {
        CharTyeClazzBaseClazz.putClazzBean(this.getClass().getName(), this);
    }
}
