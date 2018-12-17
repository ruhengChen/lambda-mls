package com.yatop.lambda.workflow.core.component.chartype.board;

import com.yatop.lambda.workflow.core.component.chartype.ICharType;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CharTyeBoard {

    //<class-path, bean-object>
    public static final HashMap<String, ICharType> CHAR_TYPE_MAPPER = new HashMap<String, ICharType>();

    public ICharType searchCharType(String classpath) {
        return CharTyeBoard.CHAR_TYPE_MAPPER.get(classpath);
    }
}
