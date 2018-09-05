use crm;



drop table if exists BALANCE_LOG;

/*==============================================================*/
/* Table: BALANCE_LOG                                           */
/*==============================================================*/
create table BALANCE_LOG
(
   ID                   bigint not null auto_increment comment '����id',
   ORDER_ID             varchar(36) comment '����id',
   OPERATE_TYPE         int(1) not null comment '�������ͣ�1:���� withdraw_deposit  ; 2:��� deposit',
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

alter table BALANCE_LOG comment '�ͻ�����/����¼��־��';





drop table if exists CUSTOMER_ADDRESS_MAP;

/*==============================================================*/
/* Table: CUSTOMER_ADDRESS_MAP                                  */
/*==============================================================*/
create table CUSTOMER_ADDRESS_MAP
(
   ID                   int not null auto_increment comment '����ID',
   CUSTOMER_ID          int comment '�ͻ�ID',
   RECEIVE_ADDRESS      varchar(40) comment '�տ��ַ',
   primary key (ID),
   unique key AK_Key_2 (CUSTOMER_ID, RECEIVE_ADDRESS)
);

alter table CUSTOMER_ADDRESS_MAP comment '���ر��û�-�տ��ַ��';



