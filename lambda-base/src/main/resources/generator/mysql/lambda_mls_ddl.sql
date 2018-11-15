/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80011
Source Host           : 127.0.0.1:3306
Source Database       : lambda_mls

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2018-11-14 17:19:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cf_cmpt_algorithm
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_algorithm`;
CREATE TABLE `cf_cmpt_algorithm` (
  `ALGORITHM_ID` bigint(20) NOT NULL COMMENT '算法ID',
  `ALGORITHM_CODE` varchar(200) NOT NULL COMMENT '算法代码',
  `ALGORITHM_NAME` varchar(200) NOT NULL COMMENT '算法名称',
  `ALGORITHM_TYPE` int(11) NOT NULL COMMENT '算法类型\r\n            1：One-Classification，单分类算法\r\n            2：Binary-Classification，二分类算法\r\n            3：Multiple-Classification，多分类算法\r\n            4：Clustering，聚类算法\r\n            5：Regression，回归算法\r\n            \r\n            //更多算法类型在后续组件开发中确定',
  `ALGORITHM_LABELS` varchar(800) DEFAULT NULL COMMENT '算法标签列表（预留），标签之间用‘|’符号分隔',
  `LEARNING_MODE` int(11) NOT NULL COMMENT '算法学习方式（预留）\r\n            0：Supervised Learning，有监督学习\r\n            1：Unsupervised Learning，无监督学习\r\n            2：Semi-Supervised Learning，半监督学习',
  `OPTIMIZE_MODE` int(11) NOT NULL COMMENT '算法最优化方式（预留）\r\n            0：Full-batch Learning，全批量学习\r\n            1：Mini-batch Learning，小批量学习\r\n            2：Online Learning，在线学习',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`ALGORITHM_ID`),
  UNIQUE KEY `Index_1` (`ALGORITHM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='算法表';

-- ----------------------------
-- Table structure for cf_cmpt_char
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char`;
CREATE TABLE `cf_cmpt_char` (
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID\r\n            \r\n            输入内容规格类型\r\n            特征ID范围：IN@C-[0000 ~ 9999]\r\n            \r\n            输出内容规格类型\r\n            特征ID范围：OUT@C[0000 ~ 9999]\r\n            \r\n            调用执行规格类型\r\n            特征ID范围：EX@C-[0000 ~ 9999]\r\n            \r\n            执行调优参数规格类型\r\n            特征ID范围：OEX@C-[0000 ~ 9999]\r\n            \r\n            组件参数规格类型\r\n            通用特征ID范围：CPP@C-[0000 ~ 9999]\r\n            专用特征ID值组成：SPP@C--${SPEC-ID}-[00~99]',
  `CHAR_CODE` varchar(200) NOT NULL COMMENT '特征代码',
  `CHAR_NAME` varchar(200) NOT NULL COMMENT '特征名称',
  `CHAR_ALIAS` varchar(200) DEFAULT NULL COMMENT '特征别名，非空时，使用特征别名替代特征代码作为参数名',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '适用规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE',
  `CHAR_TYPE` int(11) NOT NULL COMMENT '特征类型ID，说明参考CF_CMPT_CHAR_TYPE.CHAR_TYPE_ID',
  `VALUE_SRC` int(11) NOT NULL COMMENT '特征值来源\r\n            0：计算组件规格\r\n            1：计算组件\r\n            2：工作流节点\r\n            \r\n            注意，仅限在正确的地方配置特征值有效，否则无效，未配置则使用默认值',
  `IS_REQUIRED` int(11) NOT NULL COMMENT '特征值是否必须设置\r\n            0：否\r\n            1：是',
  `IS_LIMITED` int(11) NOT NULL COMMENT '特征值是否受限定\r\n            0：否\r\n            1：开区间方式限定，限数值和日期类型\r\n            2：闭区间方式限定，限数值和日期类型\r\n            3：枚举方式限定',
  `STEP_SIZE` varchar(2000) DEFAULT NULL COMMENT '特征值步长，限数值和日期类型，日期以天为单位，时间以秒为单位',
  `MIN_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷小',
  `MAX_VALUE` varchar(2000) DEFAULT NULL COMMENT '最大特征值，未设置表示无穷大',
  `DEFAULT_VALUE` varchar(2000) DEFAULT NULL COMMENT '默认特征值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`),
  UNIQUE KEY `Index_1` (`CHAR_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征表，配置组件相关的一系列特征参数项';

-- ----------------------------
-- Table structure for cf_cmpt_char_enum
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_enum`;
CREATE TABLE `cf_cmpt_char_enum` (
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `ENUM_CODE` varchar(200) NOT NULL COMMENT '枚举值代码',
  `ENUM_NAME` varchar(200) NOT NULL COMMENT '枚举值名称',
  `ENUM_VALUE` varchar(2000) NOT NULL COMMENT '枚举值',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_ID`,`ENUM_CODE`),
  UNIQUE KEY `Index_1` (`CHAR_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征枚举表，配置受枚举方式限定的组件特征，其所有预置的枚举项';

-- ----------------------------
-- Table structure for cf_cmpt_char_type
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_type`;
CREATE TABLE `cf_cmpt_char_type` (
  `CHAR_TYPE_ID` int(11) NOT NULL COMMENT '特征类型ID',
  `CHAR_TYPE_CODE` varchar(200) NOT NULL COMMENT '特征类型代码',
  `CHAR_TYPE_NAME` varchar(200) NOT NULL COMMENT '特征类型名称',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CHAR_TYPE_ID`),
  UNIQUE KEY `Index_1` (`CHAR_TYPE_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件特征类型表（仅查询用）';

-- ----------------------------
-- Table structure for cf_cmpt_char_value
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_char_value`;
CREATE TABLE `cf_cmpt_char_value` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件配置特征值表，预置在组件上的组件特征值设定';

-- ----------------------------
-- Table structure for cf_cmpt_spec
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec`;
CREATE TABLE `cf_cmpt_spec` (
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID，长度限制20\r\n            \r\n            输入内容规格ID范围：IN@SPEC-[0000 ~ 9999]\r\n            输出内容规格ID范围：OUT@SPEC-[0000 ~ 9999]\r\n            调用执行规格ID范围：EX@SPEC-[0000 ~ 9999]\r\n            执行调优参规格ID范围：OEX@SPEC-[0000 ~ 9999]\r\n            组件参数规格ID范围：CP@SPEC-${CMPT-ID}',
  `SPEC_CODE` varchar(200) NOT NULL COMMENT '规格代码（预留）',
  `SPEC_NAME` varchar(200) NOT NULL COMMENT '规格名称',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '规格类型\r\n            0：input，输入内容规格（无此类规格代表无输入内容）\r\n            1：output，输出内容规格（无此类规格代表无输出内容）\r\n            2：execution，调用执行规格（无此类规格代表无需执行）\r\n            3：execution_optimize，执行调优参数规格（无此类规格代表无执行调优参数）\r\n            4：parameter，组件参数规格（无此类规格代表无需组件参数配置）',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格表';

-- ----------------------------
-- Table structure for cf_cmpt_spec_char_rel
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_char_rel`;
CREATE TABLE `cf_cmpt_spec_char_rel` (
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格使用特征表，要求同一规格下特征代码和特征别名唯一';

-- ----------------------------
-- Table structure for cf_cmpt_spec_char_value
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_char_value`;
CREATE TABLE `cf_cmpt_spec_char_value` (
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `CHAR_ID` varchar(64) NOT NULL COMMENT '特征ID',
  `IS_SYSTEM_PARAM` int(11) NOT NULL COMMENT '特征值是否为系统参数\r\n            0：否\r\n            1：是',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SPEC_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件规格配置特征值表，预置在组件规格上的组件特征值设定';

-- ----------------------------
-- Table structure for cf_cmpt_spec_rel
-- ----------------------------
DROP TABLE IF EXISTS `cf_cmpt_spec_rel`;
CREATE TABLE `cf_cmpt_spec_rel` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID',
  `SPEC_ID` varchar(64) NOT NULL COMMENT '规格ID',
  `SPEC_TYPE` int(11) NOT NULL COMMENT '组件规格类型，说明参考CF_CMPT_SPEC.SPEC_TYPE',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`,`SPEC_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件使用规格表';

-- ----------------------------
-- Table structure for cf_component
-- ----------------------------
DROP TABLE IF EXISTS `cf_component`;
CREATE TABLE `cf_component` (
  `CMPT_ID` varchar(64) NOT NULL COMMENT '组件ID，长度限制20\r\n            \r\n            输入输出组件ID范围：IO@COM-[0000 ~ 9999]\r\n            脚本工具组件ID范围：ST@COM-[0000 ~ 9999]\r\n            数据预处理组件ID范围：DP@COM-[0000 ~ 9999]\r\n            特征工程组件ID范围：FE@COM-[0000 ~ 9999]\r\n            统计分析组件ID范围：SA@COM-[0000 ~ 9999]\r\n            机器学习组件ID范围：ML@COM-[0000 ~ 9999]\r\n            深度学习组件ID范围：DL@COM-[0000 ~ 9999]\r\n            文本分析组件ID范围：TA@COM-[0000 ~ 9999]\r\n            网络分析组件ID范围：NA@COM-[0000 ~ 9999]\r\n            ',
  `CMPT_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `CMPT_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `CMPT_TYPE` int(11) NOT NULL COMMENT '组件种类\r\n            0：输入输出组件\r\n            1：脚本工具组件\r\n            2：数据预处理组件\r\n            3：特征工程组件\r\n            4：统计分析组件\r\n            5：机器学习组件\r\n            6：深度学习组件\r\n            7：文本分析组件\r\n            8：网络分析组件',
  `CMPT_REVISION` int(11) NOT NULL DEFAULT '0' COMMENT '组件修订号',
  `REL_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '关联算法ID，非算法组件设为-1',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CMPT_ID`),
  UNIQUE KEY `Index_1` (`CMPT_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='计算组件表';

-- ----------------------------
-- Table structure for dw_data_table
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_table`;
CREATE TABLE `dw_data_table` (
  `TABLE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据表ID',
  `TABLE_NAME` varchar(200) NOT NULL COMMENT '数据表名\r\n            \r\n            普通数据表：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            临时数据表：tmp$<node_id>_<node_port_id>_<snapshot_version>',
  `TABLE_TYPE` int(11) NOT NULL COMMENT '数据表类型\r\n            0：普通数据表\r\n            1：动态数据表（预留）\r\n            2：临时数据表',
  `TABLE_SRC` int(11) NOT NULL DEFAULT '0' COMMENT '数据表来源\r\n            0：内部生成\r\n            1：外部导入',
  `OWNER_DW_ID` bigint(20) NOT NULL COMMENT '所属数据库ID',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，创建数据表时的工作流快照，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建数据表的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建数据表的工作流节点输出特征，无关联则设为-1',
  `TABLE_COLUMNS` bigint(20) DEFAULT NULL COMMENT '列数',
  `TABLE_ROWS` bigint(20) DEFAULT NULL COMMENT '行数',
  `DATA_FILE_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '数据文件类型\r\n            1：Parquet文件格式 ',
  `DATA_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '文件大小，单位为字节',
  `DATA_FILE` varchar(800) DEFAULT NULL COMMENT '数据文件名，存放于数据目录下\r\n            \r\n            普通数据表：tab_<table_id>.parquet\r\n            临时数据表完整路径：<data_dir>/tmp/<flow_id>/<snapshot_version>/tab_<table_id>.parquet',
  `DATA_SUMMARY_FILE` varchar(800) DEFAULT NULL COMMENT '数据概要文件名，存放于数据目录下\r\n            \r\n            普通数据表：tab_<table_id>_summary.json\r\n            临时数据表完整路径：<data_dir>/tmp/<flow_id>/<snapshot_version>/tab_<table_id>_summary.json',
  `TABLE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '数据表状态\r\n            0：空表\r\n            1：正常\r\n            2：仅概要文件',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TABLE_ID`),
  UNIQUE KEY `Index_1` (`OWNER_DW_ID`,`TABLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据表';

-- ----------------------------
-- Table structure for dw_data_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `dw_data_warehouse`;
CREATE TABLE `dw_data_warehouse` (
  `DW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库ID',
  `DW_CODE` varchar(100) NOT NULL COMMENT '数据库代码\r\n            \r\n            公共数据库：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            项目数据库：$符号前缀 + 项目代码',
  `DW_NAME` varchar(200) NOT NULL COMMENT '数据库名',
  `DW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共数据库，暂用于存放实验模版所预置的数据表\r\n            1：项目数据库，随项目创建同时生成，存放项目中产生的数据表',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID，数据库类型为公共数据库时设为-1',
  `DFS_DATA_DIR` varchar(800) NOT NULL COMMENT 'DFS数据目录，存放全量数据文件和数据概要文件\r\n            \r\n            示例如下：\r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/dw_data/<dw_code>',
  `LOCAL_DATA_DIR` varchar(800) NOT NULL COMMENT '本地数据目录，仅缓存数据概要文件\r\n            \r\n            示例如下：\r\n            ${LOCAL_WORK_ROOT}/dw_data/<dw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`DW_ID`),
  UNIQUE KEY `Index_1` (`DW_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据库表，对数据表做分组，辅助项目权限隔离';

-- ----------------------------
-- Table structure for em_experiment
-- ----------------------------
DROP TABLE IF EXISTS `em_experiment`;
CREATE TABLE `em_experiment` (
  `EXPERIMENT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '实验ID',
  `EXPERIMENT_NAME` varchar(200) NOT NULL COMMENT '实验名称',
  `EXPERIMENT_TYPE` int(11) NOT NULL DEFAULT '0' COMMENT '实验类型\r\n            0：主实验，正常创建实验\r\n            1：预测实验，通过选择主实验中的已训练模型进行自动创建',
  `MAIN_EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '所属主实验ID，正常创建实验设为-1',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `FLOW_ID` bigint(20) NOT NULL COMMENT '流程图ID',
  `SEQUENCE` int(11) NOT NULL DEFAULT '0' COMMENT '实验序号，用于辅助复制实验时的新名称后缀编号',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要，冗余WF_FLOW.SUMMARY信息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述，冗余WF_FLOW.DESCRIPTION信息',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`EXPERIMENT_ID`),
  UNIQUE KEY `Index_1` (`OWNER_PROJECT_ID`,`EXPERIMENT_NAME`),
  KEY `Index_3` (`OWNER_PROJECT_ID`,`EXPERIMENT_TYPE`,`MAIN_EXPERIMENT_ID`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验表，实验是工作流的外壳主体';

-- ----------------------------
-- Table structure for em_experiment_template
-- ----------------------------
DROP TABLE IF EXISTS `em_experiment_template`;
CREATE TABLE `em_experiment_template` (
  `TEMPLATE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模版ID',
  `TEMPLATE_NAME` varchar(200) NOT NULL COMMENT '模版名称',
  `SEQUENCE` int(11) NOT NULL COMMENT '模版序号',
  `TEMPLATE_CONTENT` mediumtext COMMENT '模版内容',
  `TEMPLATE_COUNT` bigint(20) NOT NULL DEFAULT '0' COMMENT '模版计数',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TEMPLATE_ID`),
  UNIQUE KEY `Index_1` (`TEMPLATE_NAME`),
  KEY `Index_2` (`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='实验模版表';

-- ----------------------------
-- Table structure for mw_model
-- ----------------------------
DROP TABLE IF EXISTS `mw_model`;
CREATE TABLE `mw_model` (
  `MODEL_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '模型ID',
  `MODEL_NAME` varchar(200) NOT NULL COMMENT '模型名称\r\n            \r\n            普通模型：由字符和数字组成，无特殊字符\r\n            临时模型：tmp$<node_id>_<node_port_id>_<snapshot_version>',
  `MODEL_TYPE` int(11) NOT NULL COMMENT '模型类型\r\n            0：普通模型\r\n            1：动态模型（预留）\r\n            2：临时模型',
  `MODEL_SRC` int(11) NOT NULL COMMENT '模型来源\r\n            0：内部生成\r\n            1：外部导入',
  `OWNER_MW_ID` bigint(20) NOT NULL COMMENT '所属模型库ID',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，创建模型时的工作流快照，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建模型的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建模型的工作流节点输出特征，无关联则设为-1',
  `REF_ALGORITHM_ID` bigint(20) NOT NULL COMMENT '引用算法ID',
  `MODEL_FILE_SIZE` bigint(20) DEFAULT NULL COMMENT '模型文件大小，单位为字节',
  `MODEL_FILE` varchar(800) DEFAULT NULL COMMENT '模型文件名，存放于模型目录下\r\n            \r\n            普通模型：model_<model_id>.mdl\r\n            临时模型完整路径：<model_dir>/tmp/<flow_id>/<snapshot_version>/model_<model_id>.mdl',
  `MODEL_SUMMARY_FILE` varchar(800) DEFAULT NULL COMMENT '模型概要文件名，存放于模型目录下，记录训练算法参数，训练收敛过程（e.g. LogLoss，AUC），以及其他模型训练相关可以收集到的所有信息\r\n            \r\n            普通模型：model_<model_dir>_summary.json\r\n            临时模型完整路径：<model_dir>/tmp/<flow_id>/<snapshot_version>/model_<model_id>_summary.json',
  `MODEL_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '模型状态\r\n            0：空模型\r\n            1：正常',
  `TRAIN_TABLE_ID` bigint(20) DEFAULT NULL COMMENT '训练集数据表ID\r\n            \r\n            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理\r\n            （关联训练集是否需要另外拷贝一份全量数据，待定）',
  `TRAIN_COST_TIME` bigint(20) DEFAULT NULL COMMENT '训练运行时间，单位毫秒',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODEL_ID`),
  UNIQUE KEY `Index_1` (`OWNER_MW_ID`,`MODEL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型表，导入外部模型待暂不考虑';

-- ----------------------------
-- Table structure for mw_model_evaluation_report
-- ----------------------------
DROP TABLE IF EXISTS `mw_model_evaluation_report`;
CREATE TABLE `mw_model_evaluation_report` (
  `REPORT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评估报告ID',
  `REPORT_NAME` varchar(200) NOT NULL COMMENT '评估报告名称',
  `OWNER_MODEL_ID` bigint(20) NOT NULL COMMENT ' 所属模型ID',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，无关联则设为-1',
  `TEST_TABLE_ID` bigint(20) DEFAULT NULL COMMENT '测试集数据表ID\r\n            \r\n            由于快照策略会使得工作流节点的输出模型特征值记录被置位为被拷贝过，暂时无需做任何处理\r\n            （关联测试集是否需要另外拷贝一份全量数据，待定）',
  `REPORT_FILE` mediumblob COMMENT '模型文件名，存放于模型目录下\r\n            \r\n            普通模型完整路径：model_<model_id>_<report_id>.rpt',
  `REPORT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '报告状态\r\n            0：空报告\r\n            1：正常',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`REPORT_ID`),
  KEY `Index_1` (`OWNER_MODEL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型评估报告表（预留），仅存放普通模型的评估报告，模型可以有多份评估报告';

-- ----------------------------
-- Table structure for mw_model_warehouse
-- ----------------------------
DROP TABLE IF EXISTS `mw_model_warehouse`;
CREATE TABLE `mw_model_warehouse` (
  `MW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '数据库ID',
  `MW_CODE` varchar(100) NOT NULL COMMENT '模型库代码（预留）\r\n            \r\n            公共模型库：由英文字符、数字和下划线组成，起始字符不能为下划线\r\n            项目模型库：$符号前缀 + 项目代码',
  `MW_NAME` varchar(200) NOT NULL COMMENT '模型库名',
  `MW_TYPE` int(11) NOT NULL COMMENT '数据库类型\r\n            0：公共模型库（预留）\r\n            1：项目模型库，随项目创建同时生成，存放项目中产生的模型',
  `OWNER_PROJECT_ID` bigint(20) DEFAULT NULL COMMENT '所属项目ID，模型库类型为公共模型库时设为-1',
  `DFS_MODEL_DIR` varchar(800) NOT NULL COMMENT 'DFS模型目录，存放模型文件、模型概要文件、模型评估文件\r\n            \r\n            示例如下：\r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/mw_model/<mw_code>',
  `LOCAL_MODEL_DIR` varchar(800) NOT NULL COMMENT '本地模型目录，缓存模型文件、模型概要文件、模型评估文件\r\n            \r\n            示例如下：\r\n            ${LOCAL_WORK_ROOT}/mw_model/<mw_code>',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MW_ID`),
  UNIQUE KEY `Index_1` (`MW_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模型库表，对模型做分组，辅助项目权限隔离';

-- ----------------------------
-- Table structure for pr_project
-- ----------------------------
DROP TABLE IF EXISTS `pr_project`;
CREATE TABLE `pr_project` (
  `PROJECT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `PROJECT_CODE` varchar(100) NOT NULL COMMENT '项目代码',
  `PROJECT_NAME` varchar(200) NOT NULL COMMENT '项目名称',
  `DW_ID` bigint(20) NOT NULL COMMENT '项目数据库ID',
  `MW_ID` bigint(20) NOT NULL COMMENT '项目模型库ID',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`),
  UNIQUE KEY `Index_1` (`PROJECT_CODE`),
  UNIQUE KEY `Index_2` (`PROJECT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目表';

-- ----------------------------
-- Table structure for pr_project_member
-- ----------------------------
DROP TABLE IF EXISTS `pr_project_member`;
CREATE TABLE `pr_project_member` (
  `PROJECT_ID` bigint(20) NOT NULL COMMENT '项目ID',
  `IS_OWNER` int(11) DEFAULT '0' COMMENT '是否为项目所有者\r\n            0：否\r\n            1：是',
  `MEMBER_USER` varchar(100) NOT NULL COMMENT '项目成员用户名',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PROJECT_ID`,`MEMBER_USER`),
  KEY `Index_1` (`MEMBER_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目成员表';

-- ----------------------------
-- Table structure for sys_parameter
-- ----------------------------
DROP TABLE IF EXISTS `sys_parameter`;
CREATE TABLE `sys_parameter` (
  `PARAM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '参数ID',
  `PARAM_CODE` varchar(200) NOT NULL COMMENT '参数代码',
  `PARAM_NAME` varchar(200) NOT NULL COMMENT '参数名称',
  `PARAM_CLASS` int(11) NOT NULL COMMENT '参数类别，按系统模块划分',
  `PARAM_SUB_CLASS` int(11) NOT NULL COMMENT '参数子类别，按系统模块下的功能模块划分',
  `PARAM_VALUE` varchar(2000) NOT NULL COMMENT '参数值',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '参数状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PARAM_ID`),
  UNIQUE KEY `Index_1` (`PARAM_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统参数表';

-- ----------------------------
-- Table structure for wf_code_script
-- ----------------------------
DROP TABLE IF EXISTS `wf_code_script`;
CREATE TABLE `wf_code_script` (
  `SCRIPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '脚本ID',
  `SCRIPT_NAME` varchar(200) NOT NULL COMMENT '脚本名称\r\n            \r\n            由工作流创建：<module_code>_<node_id>_<char_id>_<snapshot_version>',
  `SCRIPT_TYPE` int(11) NOT NULL COMMENT '脚本类型\r\n            0：普通脚本\r\n            1：SQL脚本\r\n            2：Python脚本（预留）\r\n            3：R脚本（预留）\r\n            4：特征抽取脚本（预留）',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，创建脚本时的工作流快照，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `SCRIPT_CONTENT` mediumtext COMMENT '脚本内容',
  `SCRIPT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '脚本状态\r\n            0：正常\r\n            1：空脚本',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SCRIPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='代码脚本表';

-- ----------------------------
-- Table structure for wf_execution_fork
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_fork`;
CREATE TABLE `wf_execution_fork` (
  `FORK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分叉ID',
  `OWNER_JOB_ID` bigint(20) NOT NULL COMMENT '所属作业ID',
  `FORK_NODE_ID` bigint(20) NOT NULL COMMENT '触发分叉节点ID',
  `FORK_NUM` int(11) NOT NULL COMMENT '分叉数量',
  `FORK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '分叉状态\r\n            0：waiting，等待中\r\n            1：passed，已通过\r\n            2：terminated，已终止',
  `DESCRIPTION` varchar(800) NOT NULL DEFAULT '0' COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FORK_ID`),
  KEY `Index_1` (`OWNER_JOB_ID`,`FORK_NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行分叉点表';

-- ----------------------------
-- Table structure for wf_execution_fork_path
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_fork_path`;
CREATE TABLE `wf_execution_fork_path` (
  `FORK_ID` bigint(20) NOT NULL COMMENT '分叉ID',
  `DOWNSTREAM_PATH_ID` bigint(20) NOT NULL COMMENT '下游路径ID',
  `FORK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '分叉状态\r\n            0：waiting，等待中\r\n            1：forked，已分叉\r\n            2：terminated，已终止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`FORK_ID`,`DOWNSTREAM_PATH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行分叉路径表';

-- ----------------------------
-- Table structure for wf_execution_job
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_job`;
CREATE TABLE `wf_execution_job` (
  `JOB_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `JOB_NAME` varchar(200) NOT NULL COMMENT '作业名称，自动生成',
  `JOB_TYPE` int(11) NOT NULL COMMENT '作业类型\r\n            0：全部运行\r\n            1：从此处开始运行\r\n            2：执行到此处\r\n            3：执行该节点\r\n            10：全部运行（小数据试运行）\r\n            11：从此处开始运行（小数据试运行）\r\n            12：执行到此处（小数据试运行）\r\n            13：执行该节点（小数据试运行）\r\n            20：定时调度运行\r\n            30：在线调度运行\r\n            99：非实验中的任务运行（数据文件上传）',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID，无关联工作流设为-1',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID，填写与触发运行相关的节点ID，无关联则设为-1',
  `JOB_CONTENT` mediumtext COMMENT '任务上下文',
  `DFS_EXEC_DIR` varchar(800) NOT NULL COMMENT 'DFS运行目录\r\n            \r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>\r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/proc/<project_id>/other/<exec_id>',
  `LOCAL_EXEC_DIR` varchar(800) NOT NULL COMMENT '本地运行目录（预留）\r\n            \r\n            ${LOCAL_WORK_ROOT}/proc/<project_id>/<experiment_id>/<exec_id>\r\n            ${LOCAL_WORK_ROOT}/proc/<project_id>/other/<exec_id>',
  `JOB_SUBMIT_TIME` timestamp NULL DEFAULT NULL COMMENT '作业提交时间',
  `JOB_START_TIME` timestamp NULL DEFAULT NULL COMMENT '作业开始时间',
  `JOB_END_TIME` timestamp NULL DEFAULT NULL COMMENT '作业结束时间',
  `JOB_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '作业状态\r\n            0：preparing，准备中\r\n            1：queueing，排队中\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`OWNER_PROJECT_ID`,`REL_FLOW_ID`,`CREATE_TIME`),
  KEY `Index_2` (`OWNER_PROJECT_ID`,`JOB_TYPE`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行作业表，实验粒度的运行任务，由工作流引擎将其分解为以节点为粒度的运行任务';

-- ----------------------------
-- Table structure for wf_execution_join
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_join`;
CREATE TABLE `wf_execution_join` (
  `JOIN_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '会合ID',
  `OWNER_JOB_ID` bigint(20) NOT NULL COMMENT '所属作业ID',
  `JOIN_NODE_ID` bigint(20) NOT NULL COMMENT '等候会合节点ID',
  `JOIN_NUM` int(11) NOT NULL COMMENT '会合数量',
  `JOIN_COUNT` int(11) NOT NULL COMMENT '会合计数',
  `JOIN_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '会合状态\r\n            0：waiting，等待中\r\n            1：passed，已通过\r\n            2：terminated，已终止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOIN_ID`),
  KEY `Index_1` (`OWNER_JOB_ID`,`JOIN_NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行会合点表';

-- ----------------------------
-- Table structure for wf_execution_join_path
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_join_path`;
CREATE TABLE `wf_execution_join_path` (
  `JOIN_ID` bigint(20) NOT NULL COMMENT '会合ID',
  `UPSTREAM_PATH_ID` bigint(20) NOT NULL COMMENT '上游路径ID',
  `JOIN_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '会合状态\r\n            0：waiting，等待中\r\n            1：joined，已会合\r\n            2：terminated，已终止',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOIN_ID`,`UPSTREAM_PATH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行会合路径表';

-- ----------------------------
-- Table structure for wf_execution_path
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_path`;
CREATE TABLE `wf_execution_path` (
  `PATH_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '路径ID',
  `OWNER_JOB_ID` bigint(20) NOT NULL COMMENT '所属作业ID',
  `START_NODE_ID` bigint(20) NOT NULL COMMENT '起始节点ID',
  `END_NODE_ID` bigint(20) NOT NULL COMMENT '结束节点ID',
  `CUR_NODE_ID` bigint(20) NOT NULL COMMENT '当前节点ID',
  `PATH_NODE_NUM` int(11) NOT NULL COMMENT '路径节点数量',
  `PATH_NODE_COUNT` int(11) NOT NULL COMMENT '路径节点计数',
  `PATH_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '运行状态\r\n            0：ready，已就绪\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户终止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PATH_ID`),
  UNIQUE KEY `Index_2` (`OWNER_JOB_ID`,`END_NODE_ID`),
  KEY `Index_1` (`OWNER_JOB_ID`,`PATH_STATE`),
  KEY `Index_3` (`OWNER_JOB_ID`,`START_NODE_ID`),
  KEY `Index_4` (`OWNER_JOB_ID`,`CUR_NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行路径表，配合队列表找出DAG图中在运行路径和在运行节点';

-- ----------------------------
-- Table structure for wf_execution_queue
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_queue`;
CREATE TABLE `wf_execution_queue` (
  `JOB_ID` bigint(20) NOT NULL COMMENT '作业ID',
  `STATE` int(11) NOT NULL DEFAULT '0' COMMENT '处理状态\r\n            0：queueing，排队中\r\n            1：processing，处理中',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`JOB_ID`),
  KEY `Index_1` (`STATE`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行队列表，结束运行后移除';

-- ----------------------------
-- Table structure for wf_execution_task
-- ----------------------------
DROP TABLE IF EXISTS `wf_execution_task`;
CREATE TABLE `wf_execution_task` (
  `TASK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `OWNER_JOB_ID` bigint(20) NOT NULL COMMENT '所属作业ID',
  `OWNER_PATH_ID` bigint(20) NOT NULL COMMENT '所属路径ID',
  `SEQUENCE` int(11) NOT NULL COMMENT '路径中任务序号',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID',
  `ENGINE_TYPE` varchar(200) NOT NULL DEFAULT '0' COMMENT '计算引擎类型（预留）',
  `EXTERNAL_ID` varchar(800) NOT NULL DEFAULT 'unknown' COMMENT '外部任务ID，比如yarn的application id，默认unknown',
  `TASK_CONTEXT` mediumtext COMMENT '任务上下文',
  `SUBMIT_FILE` varchar(800) NOT NULL COMMENT '提交文件名，存放在运行目录下\r\n            \r\n            submit_<exec_path_id>_<exec_task_id>_<module_code>.json',
  `RETURN_FILE` varchar(800) NOT NULL COMMENT '返回文件名，存放在运行目录下\r\n            \r\n            return_<exec_path_id>_<exec_task_id>_<module_code>.json',
  `LOG_FILE` varchar(800) NOT NULL COMMENT '日志文件名，存放在运行目录下\r\n            \r\n            log_<exec_path_id>_<exec_task_id>_<module_code>.log',
  `COST_TIME` bigint(20) NOT NULL DEFAULT '-1' COMMENT '运行时间，单位毫秒，默认为-1',
  `TASK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '运行状态\r\n            0：ready，已就绪\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：finished，运行完成\r\n            4：error terminated，出错终止\r\n            5：user terminated，用户中止',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`TASK_ID`),
  UNIQUE KEY `Index_1` (`OWNER_JOB_ID`,`REL_NODE_ID`),
  KEY `Index_2` (`OWNER_PATH_ID`,`SEQUENCE`),
  KEY `Index_3` (`OWNER_JOB_ID`,`TASK_STATE`),
  KEY `Index_4` (`OWNER_PATH_ID`,`TASK_STATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流运行任务表';

-- ----------------------------
-- Table structure for wf_flow
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow`;
CREATE TABLE `wf_flow` (
  `FLOW_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '流程图ID',
  `FLOW_NAME` varchar(200) NOT NULL COMMENT '流程图名称，自动生成',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_EXPERIMENT_ID` bigint(20) NOT NULL COMMENT '所属实验ID',
  `LOCK_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '加锁状态，实验运行和快照期间加锁，可读不可写\r\n            \r\n            0：未加锁\r\n            1：已加锁',
  `LOCK_MSG` varchar(512) DEFAULT NULL COMMENT '加锁消息',
  `LAST_SNAPSHOT_ID` bigint(20) DEFAULT NULL COMMENT '最后快照ID',
  `NEXT_SNAPSHOT_VERSION` bigint(20) NOT NULL DEFAULT '1' COMMENT '下一快照版本',
  `LAST_JOB_ID` bigint(20) DEFAULT NULL COMMENT '最后作业ID',
  `FLOW_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '工作流状态\r\n            0：draft，草稿\r\n            1：preparing，准备中\r\n            2：running，运行中\r\n            3：finished running，运行结束',
  `SUMMARY` varchar(256) DEFAULT NULL COMMENT '摘要，实验摘要信息',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述，实验描述信息',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  `VERSION` bigint(20) NOT NULL COMMENT '版本号，解决同一实验多用户编辑问题',
  PRIMARY KEY (`FLOW_ID`),
  UNIQUE KEY `Index_1` (`OWNER_EXPERIMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流表，记录当前的实验状态，由一系列子表记录实验画布上节点和边的图形信息，以及节点参数内容和输出内容';

-- ----------------------------
-- Table structure for wf_flow_global_parameter
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_global_parameter`;
CREATE TABLE `wf_flow_global_parameter` (
  `GLOBAL_PARAM_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '全局参数ID',
  `GLOBAL_PARAM_NAME` varchar(200) NOT NULL COMMENT '全局参数名',
  `REL_FLOW_ID` bigint(20) NOT NULL COMMENT '关联工作流ID',
  `REL_NODE_ID` bigint(20) NOT NULL COMMENT '关联节点ID',
  `REL_CHAR_ID` bigint(20) NOT NULL COMMENT '关联组件特征ID',
  `DEFAULT_VALUE` varchar(2000) NOT NULL COMMENT '默认值',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`GLOBAL_PARAM_ID`),
  UNIQUE KEY `Index_1` (`REL_FLOW_ID`,`REL_NODE_ID`,`REL_CHAR_ID`),
  UNIQUE KEY `Index_2` (`REL_FLOW_ID`,`GLOBAL_PARAM_NAME`),
  KEY `Index_3` (`REL_FLOW_ID`,`CREATE_TIME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流全局参数表，用于定时调度任务和开放服务API，指定哪些参数可以暴露到外部，从而调用方可以根据作业需要动态设置工作流节点参数值。';

-- ----------------------------
-- Table structure for wf_flow_node
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node`;
CREATE TABLE `wf_flow_node` (
  `NODE_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点ID',
  `NODE_NAME` varchar(200) NOT NULL COMMENT '节点名称，自动生成，可编辑',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID，无关联实验设为-1',
  `REF_MODULE_ID` bigint(20) NOT NULL COMMENT '引用工作流组件ID',
  `POSITION_X` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点X轴坐标',
  `POSITION_Y` bigint(20) NOT NULL DEFAULT '0' COMMENT '流程图节点Y轴坐标',
  `SEQUENCE` int(11) NOT NULL DEFAULT '0' COMMENT '节点序号，用于辅助创建新节点时节点名称的自动生成',
  `LAST_TASK_ID` bigint(20) DEFAULT NULL COMMENT '最后任务ID',
  `DESCRIPTION` varchar(800) NOT NULL COMMENT '流程图节点描述',
  `NODE_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '节点状态\r\n            0：not ready，未就绪\r\n            1：ready，已就绪\r\n            2：preparing，准备中\r\n            3：running，运行中\r\n            4：success，运行成功\r\n            5：error，运行出错',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`),
  KEY `Index_1` (`OWNER_FLOW_ID`,`REF_MODULE_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点表';

-- ----------------------------
-- Table structure for wf_flow_node_link
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_link`;
CREATE TABLE `wf_flow_node_link` (
  `LINK_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '链路ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属工作流ID',
  `SRC_NODE_PORT_ID` bigint(20) NOT NULL COMMENT '流出节点端口ID',
  `DST_NODE_PORT_ID` bigint(20) NOT NULL COMMENT '流入节点端口ID',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`LINK_ID`),
  UNIQUE KEY `Index_2` (`DST_NODE_PORT_ID`),
  KEY `Index_1` (`SRC_NODE_PORT_ID`),
  KEY `Index_3` (`OWNER_FLOW_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点链路表';

-- ----------------------------
-- Table structure for wf_flow_node_parameter
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_parameter`;
CREATE TABLE `wf_flow_node_parameter` (
  `NODE_ID` bigint(20) NOT NULL COMMENT '节点ID',
  `CHAR_ID` bigint(20) NOT NULL COMMENT '组件特征ID',
  `CHAR_VALUE` varchar(2000) DEFAULT NULL COMMENT '特征值',
  `IS_GLOBAL_PARAMETER` int(11) NOT NULL DEFAULT '0' COMMENT '是否为全局参数\r\n            0：否\r\n            1：是',
  `IS_DUPLICATED` int(11) NOT NULL DEFAULT '0' COMMENT '是否被复制\r\n            0：否\r\n            1：是\r\n            \r\n            创建快照和运行任务时对象数据类型会以浅拷贝方式复制，同时该标记会被置位，辅助于对象类型特征值发生更新时，判断是否创建新对象来保存新值',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_ID`,`CHAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点参数表，记录组件参数和调优参数的特征值';

-- ----------------------------
-- Table structure for wf_flow_node_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_port`;
CREATE TABLE `wf_flow_node_port` (
  `NODE_PORT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '节点端口ID',
  `OWNER_NODE_ID` bigint(20) NOT NULL COMMENT '所属节点ID',
  `REF_PORT_ID` bigint(20) NOT NULL COMMENT '引用组件端口ID',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`),
  UNIQUE KEY `Index_1` (`OWNER_NODE_ID`,`REF_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点端口表';

-- ----------------------------
-- Table structure for wf_flow_node_schema
-- ----------------------------
DROP TABLE IF EXISTS `wf_flow_node_schema`;
CREATE TABLE `wf_flow_node_schema` (
  `NODE_PORT_ID` bigint(20) NOT NULL COMMENT '所属节点输出端口ID',
  `JSON_OBJECT_ID` bigint(20) DEFAULT NULL COMMENT 'json对象ID',
  `SCHEMA_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'JSON数据状态\r\n            0：空对象\r\n            1：非空对象',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`NODE_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流节点schema表，缓存节点输出端口内容为数据表的字段结构';

-- ----------------------------
-- Table structure for wf_json_object
-- ----------------------------
DROP TABLE IF EXISTS `wf_json_object`;
CREATE TABLE `wf_json_object` (
  `OBJECT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '对象ID',
  `OBJECT_NAME` varchar(200) NOT NULL COMMENT '对象名称\r\n            \r\n            字段列表\r\n            schema_<node_id>_<node_port_id>\r\n            \r\n            输出内容\r\n            output_<node_id>_<node_port_id>_<snapshot_version>\r\n            \r\n            节点参数 （预留）\r\n            param_<node_id>_<char_id>_<snapshot_version> ',
  `OBJECTY_TYPE` int(11) NOT NULL COMMENT '对象类型\r\n            0：普通对象（暂无）\r\n            1：模型参数（未训练模型）\r\n            2：模型评估报告\r\n            3：统计分析报告\r\n            4：智能规则（预留）\r\n            5：表schema',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `REL_SNAPSHOT_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联快照ID，创建脚本时的工作流快照，无关联则设为-1',
  `REL_NODE_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联节点ID，创建脚本的工作流节点，无关联则设为-1',
  `REL_CHAR_ID` bigint(20) NOT NULL DEFAULT '-1' COMMENT '关联特征ID，创建脚本的工作流节点输出特征，无关联则设为-1',
  `STORAGE_LOCATION` int(11) NOT NULL DEFAULT '0' COMMENT '存储位置\r\n            0：OBJECT_DATA字段\r\n            1：文件系统',
  `OBJECT_DATA` mediumblob COMMENT 'JSON数据',
  `OBJECT_FILE` varchar(800) DEFAULT NULL COMMENT 'JSON文件路径（预留）\r\n            \r\n            视具体来源决定存储位置\r\n            ${HDFS_SITE}/${DFS_WORK_ROOT}/json_data/<project_id>/<experiment_id>/\r\n            ${LOCAL_WORK_ROOT}/json_data/<project_id>/<experiment_id>/',
  `OBJECT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT 'JSON数据状态\r\n            0：空对象\r\n            1：非空对象',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`OBJECT_ID`),
  KEY `Index_1` (`OBJECT_STATE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='JSON对象表';

-- ----------------------------
-- Table structure for wf_module
-- ----------------------------
DROP TABLE IF EXISTS `wf_module`;
CREATE TABLE `wf_module` (
  `MODULE_ID` bigint(20) NOT NULL COMMENT '组件ID',
  `MODULE_CODE` varchar(200) NOT NULL COMMENT '组件代码',
  `MODULE_NAME` varchar(200) NOT NULL COMMENT '组件名称',
  `CATALOG_ID` bigint(20) NOT NULL COMMENT '所属目录ID，不进目录设为-1',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CLASS_PATH` varchar(200) NOT NULL COMMENT '组件类class path',
  `PKG_CMPT_ID` varchar(64) NOT NULL COMMENT '所封装的计算组件ID',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`MODULE_ID`),
  UNIQUE KEY `Index_1` (`MODULE_CODE`),
  KEY `Index_2` (`CATALOG_ID`,`SEQUENCE`),
  KEY `Index_3` (`PKG_CMPT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件表';

-- ----------------------------
-- Table structure for wf_module_catalog
-- ----------------------------
DROP TABLE IF EXISTS `wf_module_catalog`;
CREATE TABLE `wf_module_catalog` (
  `CATALOG_ID` bigint(20) NOT NULL COMMENT '目录ID',
  `CATALOG_CODE` varchar(200) NOT NULL COMMENT '目录代码',
  `CATALOG_NAME` varchar(200) NOT NULL COMMENT '目录名称',
  `PARENT_CATALOG_ID` bigint(20) NOT NULL COMMENT '上级目录ID，一级目录设为0',
  `SEQUENCE` int(11) NOT NULL COMMENT '排序序号',
  `ICON_TYPE` int(11) NOT NULL COMMENT '图标类型',
  `CATEGORY` varchar(200) DEFAULT NULL COMMENT '组件类别（预留），自定义类别',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`CATALOG_ID`),
  UNIQUE KEY `Index_1` (`CATALOG_CODE`),
  KEY `Index_2` (`PARENT_CATALOG_ID`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件目录表，用于定义工作流组件目录结构';

-- ----------------------------
-- Table structure for wf_module_port
-- ----------------------------
DROP TABLE IF EXISTS `wf_module_port`;
CREATE TABLE `wf_module_port` (
  `PORT_ID` bigint(20) NOT NULL COMMENT '端口ID，组件的同一类型端口数最多6个\r\n            端口ID值组成：工作流组件ID * 100 + 一位节点端口类型 * 10 + 一位端口序号',
  `PORT_NAME` varchar(200) NOT NULL COMMENT '端口名称',
  `PORT_TYPE` int(11) NOT NULL COMMENT '端口类型\r\n            0：输入端口\r\n            1：输出端口',
  `OWNER_MODULE_ID` bigint(20) NOT NULL COMMENT '所属工作流组件ID',
  `BIND_CHAR_ID` varchar(64) NOT NULL COMMENT '绑定计算组件输入输出特征ID，SPEC_TYPE in （0, 1）',
  `SEQUENCE` int(11) NOT NULL COMMENT '端口序号',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '端口状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`PORT_ID`),
  UNIQUE KEY `Index_2` (`OWNER_MODULE_ID`,`BIND_CHAR_ID`),
  KEY `Index_1` (`OWNER_MODULE_ID`,`PORT_TYPE`,`SEQUENCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流组件端口表，映射计算组件输入输出内容到工作流组件端口上';

-- ----------------------------
-- Table structure for wf_snapshot
-- ----------------------------
DROP TABLE IF EXISTS `wf_snapshot`;
CREATE TABLE `wf_snapshot` (
  `SNAPSHOT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '快照ID',
  `SNAPSHOT_NAME` varchar(200) NOT NULL COMMENT '快照名称',
  `SHAPSHOT_SRC` int(11) NOT NULL COMMENT '快照来源\r\n            0：工作流运行\r\n            1：工作流副本',
  `OWNER_PROJECT_ID` bigint(20) NOT NULL COMMENT '所属项目ID',
  `OWNER_FLOW_ID` bigint(20) NOT NULL COMMENT '所属流程图ID',
  `SNAPSHOT_CONTENT` mediumtext COMMENT '快照内容',
  `SNAPSHOT_VERSION` bigint(20) NOT NULL COMMENT '快照版本',
  `SNAPSHOT_STATE` int(11) NOT NULL DEFAULT '0' COMMENT '快照状态\r\n            0：generating，快照生成中\r\n            1：finished，快照完成',
  `DESCRIPTION` varchar(800) DEFAULT NULL COMMENT '描述',
  `STATUS` int(11) NOT NULL DEFAULT '0' COMMENT '状态\r\n            0：正常\r\n            1：失效',
  `LAST_UPDATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `LAST_UPDATE_OPER` varchar(100) NOT NULL COMMENT '最后更新用户',
  `CREATE_TIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `CREATE_OPER` varchar(100) NOT NULL COMMENT '创建用户',
  PRIMARY KEY (`SNAPSHOT_ID`),
  KEY `Index_1` (`OWNER_FLOW_ID`,`SHAPSHOT_SRC`,`SNAPSHOT_VERSION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='工作流快照表，在实验工作台创建副本和运行实验都会触发快照创建，由此实现类似checkpoint功能';
