use crm;
drop table if exists balance_log;

/*==============================================================*/
/* Table: balance_log                                           */
/*==============================================================*/
create table balance_log
(
   ID                   bigint not null auto_increment comment '自增id',
   ORDER_ID             varchar(36) comment '订单id',
   OPERATE_TYPE         int(1) not null comment '操作类型：1:出金 withdraw  ; 2:入金 deposit',
   CUSTOMER_ID          int comment '客户id，与customer表关联',
   TRANSACTION_ID       varchar(64) comment 'transactionId',
   RECEIVE_ADDRESS      varchar(40) comment '接收到比特币的address',
   RECEIVE_AMOUNT       bigint comment '接收金额(单位:satoshi)',
   CHANGE_ADDRESS       varchar(40) comment '找零地址',
   SEND_ADDRESS         varchar(200) comment '发送比特币的address,（address1,address2,....）',
   FEE                  bigint comment '交易手续费(单位：satoshi)',
   CONFIRMATIONS        int comment '交易生成的block深度
            记录在数据库里的只有0,1,自定义的确认深度',
   PLATFORM_FEE         bigint comment '平台手续费(单位:satoshi)',
   ACTUAL_AMOUNT        bigint comment '实际收款金额=收款金额-平台手续费',
   CREATE_TIME          datetime comment '入库时间',
   NOTIFY_STATUS        varchar(1) comment '通知状态：
            0：刚记录数据库
            1：confirmations=6，发送通知
            2：confirmations=6，发送通知完毕
            ',
   TRADE_STATUS         varchar(64) comment '交易状态',
   UPDATE_TIME          datetime comment '更新时间',
   PNSID                int comment 'pnsid',
   PNSGID               int comment 'pnsgid',
   primary key (ID),
   unique key AK_Key_2 (ORDER_ID)
);

alter table balance_log comment '客户出金/入金记录日志表';

CREATE TABLE `dword` (
	`TIMESTAMP` BIGINT(20) NOT NULL,
	`OID` VARCHAR(45) NOT NULL,
	`CID` VARCHAR(45) NOT NULL,
	`SIDE` VARCHAR(45) NULL DEFAULT NULL,
	`PNSGID` BIGINT(20) NOT NULL,
	`PNSID` BIGINT(20) NOT NULL,
	`QUANT` BIGINT(20) NULL DEFAULT NULL,
	`FEES` BIGINT(20) NULL DEFAULT NULL,
	`NETQUANT` BIGINT(20) NULL DEFAULT NULL,
	`TRANID` VARCHAR(64) NULL DEFAULT NULL,
	`TOADDRESS` VARCHAR(45) NULL DEFAULT NULL,
	`STATUS` VARCHAR(45) NULL DEFAULT NULL,
	PRIMARY KEY (`OID`, `CID`, `PNSGID`, `PNSID`),
	UNIQUE INDEX `OID_UNIQUE` (`OID`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT;


CREATE TABLE `fees` (
	`pnsgid` BIGINT(20) NOT NULL,
	`pnsid` BIGINT(20) NOT NULL,
	`SIDE` VARCHAR(45) NOT NULL,
	`TYPE` VARCHAR(45) NULL DEFAULT NULL,
	`FIXAMT` BIGINT(20) NULL DEFAULT NULL,
	`FIXRATE` FLOAT NULL DEFAULT NULL,
	PRIMARY KEY (`pnsgid`, `pnsid`, `SIDE`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DEFAULT;

INSERT INTO `fees` (`pnsgid`, `pnsid`, `SIDE`, `TYPE`, `FIXAMT`, `FIXRATE`) VALUES
	(8, 1, 'D', 'FIXED', 5, 0.0005),
	(8, 1, 'W', 'FIXED', 5, 0.0005);