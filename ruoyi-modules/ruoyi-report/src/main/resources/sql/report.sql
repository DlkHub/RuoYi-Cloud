CREATE TABLE report_column_config
(
    id          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    report_id   BIGINT       NOT NULL COMMENT '报表ID',
    field_name  VARCHAR(64)  NOT NULL COMMENT '字段名',
    field_label VARCHAR(128) NOT NULL COMMENT '字段标题',
    field_type  VARCHAR(32)           DEFAULT 'string' COMMENT '字段类型：string、number、date、datetime、currency、percent',
    width       INT                   DEFAULT NULL COMMENT '列宽',
    align       VARCHAR(16)           DEFAULT 'left' COMMENT '对齐方式：left、center、right',
    formatter   VARCHAR(64)           DEFAULT NULL COMMENT '格式化类型',
    dict_type   VARCHAR(64)           DEFAULT NULL COMMENT '字典类型',
    sortable    TINYINT      NOT NULL DEFAULT 0 COMMENT '是否支持排序：0-否，1-是',
    visible     TINYINT      NOT NULL DEFAULT 1 COMMENT '是否显示：0-否，1-是',
    fixed       VARCHAR(16)           DEFAULT NULL COMMENT '固定列：left、right',
    sort        INT          NOT NULL DEFAULT 0 COMMENT '字段顺序',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    KEY         idx_report_id (report_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报表Table字段配置表';

CREATE TABLE report_query_item
(
    id             BIGINT       NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    report_id      BIGINT       NOT NULL COMMENT '报表ID',
    field_name     VARCHAR(64)  NOT NULL COMMENT '查询字段名',
    field_label    VARCHAR(128) NOT NULL COMMENT '显示名称',
    component_type VARCHAR(32)  NOT NULL COMMENT '组件类型：input、select、date、date_range、number、multi_select等',
    query_type     VARCHAR(32)  NOT NULL DEFAULT 'eq' COMMENT '查询方式：eq、like、gt、ge、lt、le、between、in',
    placeholder    VARCHAR(255)          DEFAULT NULL COMMENT '输入提示',
    default_value  VARCHAR(500)          DEFAULT NULL COMMENT '默认值',
    option_source  VARCHAR(32)           DEFAULT NULL COMMENT '选项来源：static、dict、api',
    option_config  JSON                  DEFAULT NULL COMMENT '选项配置',
    required       TINYINT      NOT NULL DEFAULT 0 COMMENT '是否必填：0-否，1-是',
    visible        TINYINT      NOT NULL DEFAULT 1 COMMENT '是否显示：0-否，1-是',
    sort           INT          NOT NULL DEFAULT 0 COMMENT '排序',
    create_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id),
    KEY            idx_report_id (report_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报表查询条件配置表';

CREATE TABLE `report_config`
(
    `id`          bigint(0) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `report_code` varchar(64)   NOT NULL COMMENT '报表编码',
    `report_name` varchar(128)  NOT NULL COMMENT '报表名称',
    `description` varchar(500)  NULL DEFAULT NULL COMMENT '报表描述',
    `data_source` varchar(64)  NULL DEFAULT NULL COMMENT '数据源标识',
    `query_api`   varchar(255)  NULL DEFAULT NULL COMMENT '报表查询接口',
    `status`      tinyint(0) NOT NULL DEFAULT 1 COMMENT '状态：0-停用，1-启用',
    `sort`        int(0) NOT NULL DEFAULT 0 COMMENT '排序',
    `create_by`   varchar(64)  NULL DEFAULT NULL COMMENT '创建人',
    `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_by`   varchar(64)  NULL DEFAULT NULL COMMENT '修改人',
    `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP (0) COMMENT '修改时间',
    `deleted`     tinyint(0) NOT NULL DEFAULT 0 COMMENT '删除标记：0-正常，1-删除',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `uk_report_code`(`report_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '报表配置表' ROW_FORMAT = Dynamic;