package com.yatop.lambda.workflow.core.config;

import com.yatop.lambda.base.model.*;
import com.yatop.lambda.core.enums.*;
import com.yatop.lambda.core.mgr.component.CmptAlgorithmMgr;
import com.yatop.lambda.core.mgr.component.CmptCharValueMgr;
import com.yatop.lambda.core.mgr.component.CmptSpecRelMgr;
import com.yatop.lambda.core.mgr.component.ComponentMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharEnumMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharTypeMgr;
import com.yatop.lambda.core.mgr.component.characteristic.CmptCharTypeWildMgr;
import com.yatop.lambda.core.mgr.component.specification.CmptSpecCharRelMgr;
import com.yatop.lambda.core.mgr.component.specification.CmptSpecCharValueMgr;
import com.yatop.lambda.core.mgr.component.specification.CmptSpecMgr;
import com.yatop.lambda.core.utils.DataUtil;
import com.yatop.lambda.workflow.core.richmodel.component.CmptAlgorithm;
import com.yatop.lambda.workflow.core.richmodel.component.CmptCharValue;
import com.yatop.lambda.workflow.core.richmodel.component.Component;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptChar;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharEnum;
import com.yatop.lambda.workflow.core.richmodel.component.characteristic.CmptCharType;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpec;
import com.yatop.lambda.workflow.core.richmodel.component.specification.CmptSpecCharValue;
import com.yatop.lambda.workflow.core.utils.CollectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class ComponentConfig implements InitializingBean {

    public static Logger logger = LoggerFactory.getLogger(ComponentConfig.class);

    @Autowired
    private ComponentMgr componentMgr;

    @Autowired
    private CmptAlgorithmMgr cmptAlgorithmMgr;

    @Autowired
    private CmptSpecRelMgr cmptSpecRelMgr;

    @Autowired
    private CmptCharValueMgr cmptCharValueMgr;

    @Autowired
    private CmptSpecMgr cmptSpecMgr;

    @Autowired
    private CmptSpecCharRelMgr cmptSpecCharRelMgr;

    @Autowired
    private CmptSpecCharValueMgr cmptSpecCharValueMgr;

    @Autowired
    private CmptCharMgr cmptCharMgr;

    @Autowired
    private CmptCharEnumMgr cmptCharEnumMgr;

    @Autowired
    private CmptCharTypeMgr cmptCharTypeMgr;

    @Autowired
    private CmptCharTypeWildMgr cmptCharTypeWildMgr;

    private HashMap<Long, CmptAlgorithm> ALL_ALGORITHMS = new HashMap<Long, CmptAlgorithm>();   //计算组件算法
    private HashMap<String, Component> ALL_COMPONENTS = new HashMap<String, Component>();    //计算组件
    private HashMap<String, CmptSpec> ALL_SPECIFICATIONS = new HashMap<String, CmptSpec>();  //计算组件规格
    private HashMap<String, CmptChar> ALL_CHARACTERISTICS = new HashMap<String, CmptChar>(); //计算组件特征
    private HashMap<Integer, CmptCharType> ALL_CHARACTERISTIC_TYPES = new HashMap<Integer, CmptCharType>(); //计算组件特征类型
    private HashMap<Integer, CmptCharType> ALL_PORT_CHARACTERISTIC_TYPES = new HashMap<Integer, CmptCharType>(); //计算组件端口特征类型

    public CmptAlgorithm getAlgorithm(Long algorithmId) {
        if(DataUtil.isNull(algorithmId))
            return null;
        return ALL_ALGORITHMS.get(algorithmId);
    }

    public Component getComponent(String cmptId) {
        if(DataUtil.isEmpty(cmptId))
            return null;
        return ALL_COMPONENTS.get(cmptId);
    }

    public CmptSpec getSpecification(String specId) {
        if(DataUtil.isEmpty(specId))
            return null;
        return ALL_SPECIFICATIONS.get(specId);
    }

    public CmptChar getCharacteristic(String charId) {
        if(DataUtil.isEmpty(charId))
            return null;
        return ALL_CHARACTERISTICS.get(charId);
    }

    public CmptCharType getCharacteristicType(Integer typeId) {
        if(DataUtil.isNull(typeId))
            return null;
        return ALL_CHARACTERISTIC_TYPES.get(typeId);
    }

    public CmptCharType getPortCharacteristicType(Integer typeId) {
        if(DataUtil.isNull(typeId))
            return null;
        return ALL_PORT_CHARACTERISTIC_TYPES.get(typeId);
    }

    public List<CmptCharType> getPortCharacteristicTypes() {
        return CollectionUtil.toList(ALL_PORT_CHARACTERISTIC_TYPES);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadComponentConfiguration();
    }

    private void loadComponentConfiguration() {

        //特征类型相关
        loadCmptCharTypeConfig();

        //特征相关
        loadCmptCharConfig();

        //规格相关
        loadCmptSpecConfig();

        //组件相关
        loadComponentConfig();

        //校验相关
        checkConfiguration();
    }

    private void loadCmptCharTypeConfig() {
        long wildTypeCounter = 0;
        List<CfCmptCharType> typeList = cmptCharTypeMgr.queryCharType();
        if(DataUtil.isEmpty(typeList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type configuration."));
            System.exit(-1);
        }

        for(CfCmptCharType type : typeList) {
            CmptCharType richType = new CmptCharType(type);

            IsWildTypeEnum wildTypeEnum = IsWildTypeEnum.valueOf(richType.getIsWildtype());
            if(DataUtil.isNull(wildTypeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Is-WildType:\n%s.", DataUtil.prettyFormat(type)));
                System.exit(-1);
            }
            if(wildTypeEnum.getMark() == IsWildTypeEnum.YES.getMark()) {
                wildTypeCounter++;
            }
            if(!SpecMaskEnum.isCorrectMask(richType.getSpecMask())) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Mask:\n%s.", DataUtil.prettyFormat(type)));
                System.exit(-1);
            }

            ALL_CHARACTERISTIC_TYPES.put(richType.getCharTypeId(), richType);
        }
        typeList.clear();

        if(wildTypeCounter > 0) {
            List<CfCmptCharTypeWild> matchTypeList = cmptCharTypeWildMgr.queryCharTypeWild();
            if (DataUtil.isEmpty(matchTypeList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic type wild match configuration."));
                System.exit(-1);
            }

            for (CfCmptCharTypeWild match : matchTypeList) {
                CmptCharType targetCharType = ALL_CHARACTERISTIC_TYPES.get(match.getDstCharTypeId());
                if (DataUtil.isNull(targetCharType)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type not found:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                if (targetCharType.getIsWildtype() != IsWildTypeEnum.YES.getMark()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type info error:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                if (!SpecMaskEnum.matchInputAndOutput(targetCharType.getSpecMask())) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Destination port characteristic type must be also support input & output:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                CmptCharType sourceCharType = ALL_CHARACTERISTIC_TYPES.get(match.getSrcCharTypeId());
                if (DataUtil.isNull(sourceCharType)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Source port characteristic type not found:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }
                if (!SpecMaskEnum.matchInputAndOutput(sourceCharType.getSpecMask())) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Source port characteristic type must be also support input & output:\n%s.", DataUtil.prettyFormat(match)));
                    System.exit(-1);
                }

                sourceCharType.putMatchTargetType(targetCharType);
            }
            matchTypeList.clear();
        }

        //sourceCharTypeId, <targetCharTypeId, CmptCharType>
        HashMap<Integer, TreeMap<Integer, CmptCharType>> expandedTargetCharTypesCache = new HashMap<Integer, TreeMap<Integer, CmptCharType>>();
        for(Map.Entry<Integer, CmptCharType> entry: ALL_CHARACTERISTIC_TYPES.entrySet()) {
            CmptCharType sourceCharType = entry.getValue();
            if(!SpecMaskEnum.matchInputAndOutput(sourceCharType.getSpecMask())) {
                ALL_PORT_CHARACTERISTIC_TYPES.put(sourceCharType.getCharTypeId(), sourceCharType);

                TreeMap<Integer, CmptCharType> expandedTargetCharTypes = new TreeMap<Integer, CmptCharType>();
                expandedTargetCharTypes.put(sourceCharType.getCharTypeId(), sourceCharType);
                expandedTargetCharTypesCache.put(sourceCharType.getCharTypeId(), expandedTargetCharTypes);

                expandSourcePortTargetCharType(sourceCharType.getMatchTargetTypes(), expandedTargetCharTypes);
            }
        }

        for(Map.Entry<Integer, TreeMap<Integer, CmptCharType>> entry : expandedTargetCharTypesCache.entrySet()) {
            CmptCharType sourceCharType = ALL_PORT_CHARACTERISTIC_TYPES.get(entry.getKey());
            sourceCharType.replaceMatchTargetTypes(entry.getValue());
        }
        expandedTargetCharTypesCache.clear();
    }

    private void expandSourcePortTargetCharType(List<CmptCharType> targetCharTypes, TreeMap<Integer, CmptCharType> expandedTargetCharTypes) {
        if(DataUtil.isEmpty(targetCharTypes))
            return;
        for(CmptCharType targetCharType : targetCharTypes) {
            expandSourcePortTargetCharType(targetCharType.getMatchTargetTypes(), expandedTargetCharTypes);
            expandedTargetCharTypes.put(targetCharType.getCharTypeId(), targetCharType);
        }
    }

    private void loadCmptCharConfig() {
        long enumCharCounter = 0L;

        List<CfCmptChar> charList = cmptCharMgr.queryCharacteristic();
        if(DataUtil.isEmpty(charList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic configuration."));
            System.exit(-1);
        }

        for(CfCmptChar cmptChar : charList) {

            CmptCharType charType =  ALL_CHARACTERISTIC_TYPES.get(cmptChar.getCharType());
            if(DataUtil.isNull(charType)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic type not found:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            CmptChar richChar = new CmptChar(cmptChar, charType);
            ALL_CHARACTERISTICS.put(richChar.getCharId(), richChar);

            SpecTypeEnum typeEnum = SpecTypeEnum.valueOf(richChar.getSpecType());
            if(DataUtil.isNull(typeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(!SpecMaskEnum.isCorrectFitSpecType(charType.getSpecMask(), typeEnum)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Incorrect Spec-Type:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(SourceLevelEnum.valueOf(richChar.getSrcLevel()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Src-Level:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if((typeEnum.getType() == SpecTypeEnum.INPUT.getType() || typeEnum.getType() == SpecTypeEnum.OUTPUT.getType())
                    && richChar.getSrcLevel() != SourceLevelEnum.WORKFLOW.getSource()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Src-Level(input & output must be workflow-source-level):\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(typeEnum.getType() == SpecTypeEnum.EXECUTION.getType() && richChar.getSrcLevel() == SourceLevelEnum.WORKFLOW.getSource()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Src-Level(forbid execution to be workflow-source-level):\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsAllowGlobalEnum.valueOf(richChar.getIsAllowGlobal()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Allow-Global:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsRequiredEnum.valueOf(richChar.getIsRequired()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Required:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(DataUtil.isNull(IsLimitedEnum.valueOf(richChar.getIsLimited()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Limited:\n%s.", DataUtil.prettyFormat(cmptChar)));
                System.exit(-1);
            }

            if(cmptChar.getIsLimited() == IsLimitedEnum.ENUMERATION.getMark())
                enumCharCounter++;
        }
        charList.clear();

        if(enumCharCounter > 0) {
            List<CfCmptCharEnum> enumList = cmptCharEnumMgr.queryCharEnum();
            if(DataUtil.isEmpty(enumList)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Empty characteristic enumeration configuration."));
                System.exit(-1);
            }

            for(CfCmptCharEnum charEnum : enumList) {
                CmptCharEnum richCharEnum = new CmptCharEnum(charEnum);
                CmptChar cmptChar = ALL_CHARACTERISTICS.get(richCharEnum.getCharId());
                if(DataUtil.isNotNull(cmptChar)) {
                    cmptChar.putEnum(richCharEnum);
                } else {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Owner characteristic not found:\n%s.", DataUtil.prettyFormat(charEnum)));
                    System.exit(-1);
                }
            }
            enumList.clear();
        }
    }

    private void loadCmptSpecConfig() {
        List<CfCmptSpec> specList = cmptSpecMgr.querySpecification();
        if(DataUtil.isEmpty(specList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty specification configuration."));
            System.exit(-1);
        }

        for(CfCmptSpec cmptSpec : specList) {
            CmptSpec richSpec = new CmptSpec(cmptSpec);
            if(DataUtil.isNull(SpecTypeEnum.valueOf(richSpec.getSpecType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.", DataUtil.prettyFormat(cmptSpec)));
                System.exit(-1);
            }

            ALL_SPECIFICATIONS.put(richSpec.getSpecId(), richSpec);
        }
        specList.clear();

        List<CfCmptSpecCharRel> specCharList = cmptSpecCharRelMgr.querySpecCharRel();
        if(DataUtil.isEmpty(specCharList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty Spec-Char-Rel configuration."));
            System.exit(-1);
        }

        for(CfCmptSpecCharRel rel : specCharList) {
            CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(rel.getSpecId());
            if(DataUtil.isNull(cmptSpec)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }
            CmptChar cmptChar = ALL_CHARACTERISTICS.get(rel.getCharId());
            if(DataUtil.isNull(cmptChar)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }
            if(cmptChar.getSpecType() != cmptChar.getSpecType()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Char-Rel:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            cmptSpec.putCmptChar(cmptChar);
        }
        specCharList.clear();

        List<CfCmptSpecCharValue> charValueList = cmptSpecCharValueMgr.querySpecCharValue();
        if (DataUtil.isNotEmpty(charValueList)) {

            for (CfCmptSpecCharValue value : charValueList) {
                CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(value.getSpecId());
                if (DataUtil.isNull(cmptSpec)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                if(cmptSpec.getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Value error(forbid input & output value):\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                CmptChar cmptChar = cmptSpec.getCmptChar(value.getCharId());
                if (DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Rel not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }
                if (DataUtil.isNull(IsSystemParamEnum.valueOf(value.getIsSystemParam()))) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-System-Param:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                cmptSpec.putCharValue(new CmptSpecCharValue(value));
            }
        }
    }

    private void loadComponentConfig() {
        List<CfCmptAlgorithm> algorithmList = cmptAlgorithmMgr.queryAlgorithm();
        if(DataUtil.isEmpty(algorithmList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty algorithm configuration."));
            System.exit(-1);
        }

        for(CfCmptAlgorithm algorithm : algorithmList) {
            CmptAlgorithm richAlgorithm = new CmptAlgorithm(algorithm);
            if (DataUtil.isNull(AlgorithmTypeEnum.valueOf(richAlgorithm.getAlgorithmType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Algorithm-Type:\n%s.", DataUtil.prettyFormat(algorithm)));
                System.exit(-1);
            }
            if (DataUtil.isNull(IsTunableEnum.valueOf(richAlgorithm.getIsTunable()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-Tunable:\n%s.", DataUtil.prettyFormat(algorithm)));
                System.exit(-1);
            }
            ALL_ALGORITHMS.put(richAlgorithm.getAlgorithmId(), richAlgorithm);
        }
        algorithmList.clear();

        List<CfComponent> componentList = componentMgr.queryComponent();
        if(DataUtil.isEmpty(componentList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty component configuration."));
            System.exit(-1);
        }

        for(CfComponent component : componentList) {
            Component richComponent = new Component(component);
            if (DataUtil.isNull(CmptTypeEnum.valueOf(richComponent.getCmptType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Cmpt-Type:\n%s.", DataUtil.prettyFormat(component)));
                System.exit(-1);
            }

            if(richComponent.getRelAlgorithmId() > 0) {
                CmptAlgorithm algorithm = ALL_ALGORITHMS.get(richComponent.getRelAlgorithmId());
                if (DataUtil.isNull(algorithm)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Algorithm not found:\n%s.", DataUtil.prettyFormat(component)));
                    System.exit(-1);
                }
                richComponent.setAlgorithm(algorithm);
            }
            ALL_COMPONENTS.put(richComponent.getCmptId(), richComponent);
        }
        componentList.clear();

        List<CfCmptSpecRel> cmptSpecList = cmptSpecRelMgr.queryCmptSpecRel();
        if(DataUtil.isEmpty(cmptSpecList)) {
            logger.error(String.format("Loading component configuration occurs fatal error -- Empty Cmpt-Spec-Rel configuration."));
            System.exit(-1);
        }

        for(CfCmptSpecRel rel : cmptSpecList) {
            Component component = ALL_COMPONENTS.get(rel.getCmptId());
            if(DataUtil.isNull(component)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Component not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }
            CmptSpec cmptSpec = ALL_SPECIFICATIONS.get(rel.getSpecId());
            if(DataUtil.isNull(cmptSpec)) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Specification not found:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            if(DataUtil.isNull(SpecTypeEnum.valueOf(rel.getSpecType()))) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Spec-Type:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            if(rel.getSpecType() != cmptSpec.getSpecType()) {
                logger.error(String.format("Loading component configuration occurs fatal error -- Error Spec-Type:\n%s.", DataUtil.prettyFormat(rel)));
                System.exit(-1);
            }

            component.setCmptSpec(cmptSpec);
        }
        cmptSpecList.clear();

        List<CfCmptCharValue> charValueList = cmptCharValueMgr.queryCmptCharValue();
        if (DataUtil.isNotEmpty(charValueList)) {

            for (CfCmptCharValue value : charValueList) {
                Component component = ALL_COMPONENTS.get(value.getCmptId());
                if (DataUtil.isNull(component)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Component not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }
                CmptChar cmptChar = ALL_CHARACTERISTICS.get(value.getCharId());
                if (DataUtil.isNull(cmptChar)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Characteristic not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }
                CmptSpec cmptSpec = component.getCmptSpec(SpecTypeEnum.valueOf(cmptChar.getSpecType()));
                if (DataUtil.isNull(cmptSpec)) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Spec-Char-Rel not found:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                if(cmptSpec.getSpecType() == SpecTypeEnum.INPUT.getType() || cmptSpec.getSpecType() == SpecTypeEnum.OUTPUT.getType()) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Cmpt-Char-Value error(forbid input & output value):\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                if (DataUtil.isNull(IsSystemParamEnum.valueOf(value.getIsSystemParam()))) {
                    logger.error(String.format("Loading component configuration occurs fatal error -- Unknown Is-System-Param:\n%s.", DataUtil.prettyFormat(value)));
                    System.exit(-1);
                }

                component.putCharValue(new CmptCharValue(value));
            }
        }
    }

    private void checkConfiguration() {

        //if SrcLevel < WorkFlow && IsRequired == Yes, Config-Char-Value must be existed in component
        for(Map.Entry<String, Component> cmptEntry : ALL_COMPONENTS.entrySet()) {
            Component component = cmptEntry.getValue();
            //execution
            if(component.getExecution().cmptCharCount()> 0) {
                for (CmptChar cmptChar : component.getExecution().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check execution config occurs fatal error -- config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component), DataUtil.prettyFormat(cmptChar)));
                        System.exit(-1);
                    }
                }
            }

            //optimize execution
            if(component.getOptimizeExecution().cmptCharCount()> 0) {
                for (CmptChar cmptChar : component.getOptimizeExecution().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check optimize execution config occurs fatal error -- config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component), DataUtil.prettyFormat(cmptChar)));
                        System.exit(-1);
                    }
                }
            }

            //parameter
            if(component.getParameter().cmptCharCount()> 0) {
                for (CmptChar cmptChar : component.getParameter().getCmptChars()) {
                    if (component.missingConfigCharValue(cmptChar)) {
                        logger.error(String.format("Check parameter config occurs fatal error -- config-char-value not found:\n===Component===\n%s\n===CmptChar===\n%s.", DataUtil.prettyFormat(component), DataUtil.prettyFormat(cmptChar)));
                        System.exit(-1);
                    }
                }
            }
        }
    }
}
