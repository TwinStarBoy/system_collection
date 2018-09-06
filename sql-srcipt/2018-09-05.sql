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



drop table if exists customer_address_map;

/*==============================================================*/
/* Table: customer_address_map                                  */
/*==============================================================*/
create table customer_address_map
(
   ID                   int not null auto_increment comment '����ID',
   CUSTOMER_ID          int comment '�ͻ�ID',
   RECEIVE_ADDRESS      varchar(40) comment '�տ��ַ',
   primary key (ID),
   unique key AK_Key_2 (CUSTOMER_ID, RECEIVE_ADDRESS)
);

alter table customer_address_map comment '���ر��û�-�տ��ַ��';
