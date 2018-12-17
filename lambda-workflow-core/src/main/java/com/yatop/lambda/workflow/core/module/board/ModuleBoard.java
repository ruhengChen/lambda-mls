package com.yatop.lambda.workflow.core.module.board;

import com.yatop.lambda.workflow.core.module.IModule;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ModuleBoard {

    //<class-path, bean-object>
    public static final HashMap<String, IModule> MODULE_MAPPER = new HashMap<String, IModule>();

    public IModule searchModule(String classpath) {
        return ModuleBoard.MODULE_MAPPER.get(classpath);
    }
}
