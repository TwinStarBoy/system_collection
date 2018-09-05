use crm;



drop table if exists BALANCE_LOG;

/*==============================================================*/
/* Table: BALANCE_LOG                                           */
/*==============================================================*/
create table BALANCE_LOG
(
   ID                   bigint not null auto_increment comment '自增id',
   ORDER_ID             varchar(36) comment '订单id',
   OPERATE_TYPE         int(1) not null comment '操作类型：1:出金 withdraw_deposit  ; 2:入金 deposit',
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

alter table BALANCE_LOG comment '客户出金/入金记录日志表';





drop table if exists CUSTOMER_ADDRESS_MAP;

/*==============================================================*/
/* Table: CUSTOMER_ADDRESS_MAP                                  */
/*==============================================================*/
create table CUSTOMER_ADDRESS_MAP
(
   ID                   int not null auto_increment comment '主键ID',
   CUSTOMER_ID          int comment '客户ID',
   RECEIVE_ADDRESS      varchar(40) comment '收款地址',
   primary key (ID),
   unique key AK_Key_2 (CUSTOMER_ID, RECEIVE_ADDRESS)
);

alter table CUSTOMER_ADDRESS_MAP comment '比特币用户-收款地址表';



