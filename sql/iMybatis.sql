drop table if exists t_user;

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   userid               numeric(9,0) not null,
   username             varchar(80),
   password             varchar(15) not null,
   address              varchar(50),
   createtime           datetime default current_timestamp,
   primary key (userid)
);
