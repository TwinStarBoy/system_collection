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



drop table if exists customer_address_map;

/*==============================================================*/
/* Table: customer_address_map                                  */
/*==============================================================*/
create table customer_address_map
(
   ID                   int not null auto_increment comment '主键ID',
   CUSTOMER_ID          int comment '客户ID',
   RECEIVE_ADDRESS      varchar(40) comment '收款地址',
   primary key (ID),
   unique key AK_Key_2 (CUSTOMER_ID, RECEIVE_ADDRESS)
);

alter table customer_address_map comment '比特币用户-收款地址表';
