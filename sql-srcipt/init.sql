CREATE TABLE `permission` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`USER_ID` INT(11) NOT NULL COMMENT '用户id',
	`PERMISSION_CODE` BIGINT(20) NOT NULL COMMENT '用户权限码',
	`SCAN_ALL_CUSTOMERS` INT(1) NOT NULL DEFAULT '0' COMMENT '查看所有用户',
	`SCAN_CUSTOMER_POSITION` INT(1) NOT NULL DEFAULT '0' COMMENT '查看客户仓位',
	`CREATE_CUSTOMER` INT(1) NOT NULL DEFAULT '0' COMMENT '增加客户',
	`UPDATE_CUSTOMER` INT(1) NOT NULL DEFAULT '0' COMMENT '修改客户信息',
	`LIMIT_CUSTOMER_TRADE` INT(1) NOT NULL DEFAULT '0' COMMENT '限制用户交易   ',
	`LIMIT_CUSTOMER_DEPOSIT_WITHDRAW` INT(1) NOT NULL DEFAULT '0' COMMENT '限制用户出入金 ',
	`UPDATE_CUSTOMER_ORDERS` INT(1) NOT NULL DEFAULT '0' COMMENT '修改客户订单',
	`CREATE_ORDER` INT(1) NOT NULL DEFAULT '0' COMMENT '新增订单',
	`DELETE_ORDER` INT(1) NOT NULL DEFAULT '0' COMMENT '删除订单',
	`SCAN_OPRATOR_LOG` INT(1) NOT NULL DEFAULT '0' COMMENT '查看操作日志  ',
	`MANAGE_USER` INT(1) NOT NULL DEFAULT '0' COMMENT '管理登录用户',
	PRIMARY KEY (`ID`),
	UNIQUE INDEX `AK_userId` (`USER_ID`)
)
COMMENT='权限表'
COLLATE='utf8_bin'
ENGINE=InnoDB;

CREATE TABLE `customer` (
	`ID` INT(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
	`USERNAME` VARCHAR(50) NOT NULL COMMENT '用户名',
	`PASSWORD` VARCHAR(200) NOT NULL COMMENT '密码',
	`MOBILE` VARCHAR(15) NULL DEFAULT NULL COMMENT '联系手机号',
	`IDENTIFICATION` VARCHAR(20) NULL DEFAULT NULL COMMENT '身份证号',
	`EMAIL` VARCHAR(50) NOT NULL COMMENT '邮箱',
	`IS_EMAIL_VERIFY` VARCHAR(1) NULL DEFAULT NULL COMMENT '是否邮箱验证(0：否，1：是)',
	`IS_FROZEN` VARCHAR(1) NULL DEFAULT NULL COMMENT '是否冻结（0：否，1：是）',
	`IS_ENABLE` VARCHAR(1) NULL DEFAULT NULL COMMENT '是否失效（0：否，1：是）',
	`CREATE_TIME` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`UPDATE_TIME` DATETIME NULL DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`ID`),
	INDEX `AK_unique_username` (`USERNAME`),
	INDEX `AK_unique_email` (`EMAIL`)
)
COMMENT='客户表'
COLLATE='utf8_general_ci'
ENGINE=InnoDB;