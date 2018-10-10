use crm;
drop table if exists balance_log;

/*==============================================================*/
/* Table: balance_log                                           */
/*==============================================================*/
create table balance_log
(
   ID                   bigint not null auto_increment comment '����id',
   ORDER_ID             varchar(36) comment '����id',
   OPERATE_TYPE         int(1) not null comment '�������ͣ�1:���� withdraw  ; 2:��� deposit',
   CUSTOMER_ID          int comment '�ͻ�id����customer�����',
   TRANSACTION_ID       varchar(64) comment 'transactionId',
   RECEIVE_ADDRESS      varchar(40) comment '���յ����رҵ�address',
   RECEIVE_AMOUNT       bigint comment '���ս��(��λ:satoshi)',
   CHANGE_ADDRESS       varchar(40) comment '�����ַ',
   SEND_ADDRESS         varchar(200) comment '���ͱ��رҵ�address,��address1,address2,....��',
   FEE                  bigint comment '����������(��λ��satoshi)',
   CONFIRMATIONS        int comment '�������ɵ�block���
            ��¼�����ݿ����ֻ��0,1,�Զ����ȷ�����',
   PLATFORM_FEE         bigint comment 'ƽ̨������(��λ:satoshi)',
   ACTUAL_AMOUNT        bigint comment 'ʵ���տ���=�տ���-ƽ̨������',
   CREATE_TIME          datetime comment '���ʱ��',
   NOTIFY_STATUS        varchar(1) comment '֪ͨ״̬��
            0���ռ�¼���ݿ�
            1��confirmations=6������֪ͨ
            2��confirmations=6������֪ͨ���
            ',
   TRADE_STATUS         varchar(64) comment '����״̬',
   UPDATE_TIME          datetime comment '����ʱ��',
   PNSID                int comment 'pnsid',
   PNSGID               int comment 'pnsgid',
   primary key (ID),
   unique key AK_Key_2 (ORDER_ID)
);

alter table balance_log comment '�ͻ�����/����¼��־��';

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