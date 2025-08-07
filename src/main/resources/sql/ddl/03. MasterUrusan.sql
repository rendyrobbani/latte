drop table if exists sipd_master_bidang;
drop table if exists logs_master_bidang;
drop table if exists data_master_bidang;
drop table if exists sipd_master_urusan;
drop table if exists logs_master_urusan;
drop table if exists data_master_urusan;

create or replace table data_master_urusan (
	id         char(1)      not null,
	code       char(1)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     null,
	created_by char(18)     null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table logs_master_urusan (
	id         bigint(20)   not null auto_increment,
	code       char(1)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     null,
	created_by char(18)     null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	logged_at  datetime     null,
	logged_by  char(18)     null,
	subject_id char(1)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table sipd_master_urusan (
	id         bigint(20)   not null auto_increment,
	code       char(1)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     null,
	created_by char(18)     null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	subject_id char(1)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table data_master_bidang (
	id         char(4)      not null,
	code       char(4)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     null,
	created_by char(18)     null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	urusan_id  char(1)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table logs_master_bidang (
	id         bigint(20)   not null auto_increment,
	code       char(4)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     null,
	created_by char(18)     null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	logged_at  datetime     null,
	logged_by  char(18)     null,
	subject_id char(4)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table sipd_master_bidang (
	id         bigint(20)   not null auto_increment,
	code       char(4)      not null,
	name       varchar(255) not null,
	is_locked  bit(1)       not null,
	locked_at  datetime     null,
	locked_by  char(18)     null,
	created_at datetime     null,
	created_by char(18)     null,
	updated_at datetime     null,
	updated_by char(18)     null,
	is_deleted bit(1)       not null,
	deleted_at datetime     null,
	deleted_by char(18)     null,
	subject_id char(4)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;

alter table data_master_urusan add constraint ck_data_master_urusan_01 check (id = replace(code, 'X', '0'));
alter table data_master_bidang add constraint ck_data_master_bidang_01 check (id = replace(code, 'X', '0'));
alter table data_master_bidang add constraint ck_data_master_bidang_02 check (urusan_id is null or (left(id, length(urusan_id)) = urusan_id));

alter table data_master_bidang add constraint uk_data_master_bidang_01 unique key (urusan_id, id);

alter table data_master_urusan add constraint fk_data_master_urusan_01 foreign key (locked_by) references data_user (id);
alter table data_master_urusan add constraint fk_data_master_urusan_02 foreign key (created_by) references data_user (id);
alter table data_master_urusan add constraint fk_data_master_urusan_03 foreign key (updated_by) references data_user (id);
alter table data_master_urusan add constraint fk_data_master_urusan_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_urusan add constraint fk_logs_master_urusan_01 foreign key (locked_by) references data_user (id);
alter table logs_master_urusan add constraint fk_logs_master_urusan_02 foreign key (created_by) references data_user (id);
alter table logs_master_urusan add constraint fk_logs_master_urusan_03 foreign key (updated_by) references data_user (id);
alter table logs_master_urusan add constraint fk_logs_master_urusan_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_urusan add constraint fk_logs_master_urusan_05 foreign key (logged_by) references data_user (id);
alter table logs_master_urusan add constraint fk_logs_master_urusan_06 foreign key (subject_id) references data_master_urusan (id);
alter table sipd_master_urusan add constraint fk_sipd_master_urusan_01 foreign key (locked_by) references data_user (id);
alter table sipd_master_urusan add constraint fk_sipd_master_urusan_02 foreign key (created_by) references data_user (id);
alter table sipd_master_urusan add constraint fk_sipd_master_urusan_03 foreign key (updated_by) references data_user (id);
alter table sipd_master_urusan add constraint fk_sipd_master_urusan_04 foreign key (deleted_by) references data_user (id);
alter table sipd_master_urusan add constraint fk_sipd_master_urusan_05 foreign key (subject_id) references data_master_urusan (id);
alter table data_master_bidang add constraint fk_data_master_bidang_01 foreign key (locked_by) references data_user (id);
alter table data_master_bidang add constraint fk_data_master_bidang_02 foreign key (created_by) references data_user (id);
alter table data_master_bidang add constraint fk_data_master_bidang_03 foreign key (updated_by) references data_user (id);
alter table data_master_bidang add constraint fk_data_master_bidang_04 foreign key (deleted_by) references data_user (id);
alter table data_master_bidang add constraint fk_data_master_bidang_05 foreign key (urusan_id) references data_master_urusan (id);
alter table logs_master_bidang add constraint fk_logs_master_bidang_01 foreign key (locked_by) references data_user (id);
alter table logs_master_bidang add constraint fk_logs_master_bidang_02 foreign key (created_by) references data_user (id);
alter table logs_master_bidang add constraint fk_logs_master_bidang_03 foreign key (updated_by) references data_user (id);
alter table logs_master_bidang add constraint fk_logs_master_bidang_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_bidang add constraint fk_logs_master_bidang_05 foreign key (logged_by) references data_user (id);
alter table logs_master_bidang add constraint fk_logs_master_bidang_06 foreign key (subject_id) references data_master_bidang (id);
alter table sipd_master_bidang add constraint fk_sipd_master_bidang_01 foreign key (locked_by) references data_user (id);
alter table sipd_master_bidang add constraint fk_sipd_master_bidang_02 foreign key (created_by) references data_user (id);
alter table sipd_master_bidang add constraint fk_sipd_master_bidang_03 foreign key (updated_by) references data_user (id);
alter table sipd_master_bidang add constraint fk_sipd_master_bidang_04 foreign key (deleted_by) references data_user (id);
alter table sipd_master_bidang add constraint fk_sipd_master_bidang_05 foreign key (subject_id) references data_master_bidang (id);