package com.yatop.lambda.workflow.core.framework.module;

import java.util.HashMap;

public abstract class ModuleClazzClazzBase implements IModuleClazz {

    //<class-path, bean-object>
    private static final HashMap<String, IModuleClazz> CLAZZ_BEANS = new HashMap<String, IModuleClazz>();

    public static IModuleClazz getClazzBean(String classpath) {
        return CLAZZ_BEANS.get(classpath);
    }

    private static void putClazzBean(String classpath, IModuleClazz moduleBean) {
        CLAZZ_BEANS.put(classpath, moduleBean);
    }

    public ModuleClazzClazzBase() {
        ModuleClazzClazzBase.putClazzBean(this.getClass().getName(), this);
    }
}
