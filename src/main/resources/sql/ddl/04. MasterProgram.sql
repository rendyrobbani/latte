drop table if exists sipd_master_program;
drop table if exists logs_master_program;
drop table if exists data_master_program;

create or replace table data_master_program (
	id         char(7)      not null,
	code       char(7)      not null,
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
	bidang_id  char(4)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table logs_master_program (
	id         bigint(20)   not null auto_increment,
	code       char(7)      not null,
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
	subject_id char(7)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table sipd_master_program (
	id         bigint(20)   not null auto_increment,
	code       char(7)      not null,
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
	subject_id char(7)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;

alter table data_master_program add constraint ck_data_master_program_01 check (id = replace(code, 'X', '0'));
alter table data_master_program add constraint ck_data_master_program_02 check (urusan_id is null or (left(id, length(urusan_id)) = urusan_id));
alter table data_master_program add constraint ck_data_master_program_03 check (bidang_id is null or (left(id, length(bidang_id)) = bidang_id));

alter table data_master_program add constraint fk_data_master_program_01 foreign key (locked_by) references data_user (id);
alter table data_master_program add constraint fk_data_master_program_02 foreign key (created_by) references data_user (id);
alter table data_master_program add constraint fk_data_master_program_03 foreign key (updated_by) references data_user (id);
alter table data_master_program add constraint fk_data_master_program_04 foreign key (deleted_by) references data_user (id);
alter table data_master_program add constraint fk_data_master_program_05 foreign key (urusan_id) references data_master_urusan (id);
alter table data_master_program add constraint fk_data_master_program_06 foreign key (bidang_id) references data_master_bidang (id);
alter table logs_master_program add constraint fk_logs_master_program_01 foreign key (locked_by) references data_user (id);
alter table logs_master_program add constraint fk_logs_master_program_02 foreign key (created_by) references data_user (id);
alter table logs_master_program add constraint fk_logs_master_program_03 foreign key (updated_by) references data_user (id);
alter table logs_master_program add constraint fk_logs_master_program_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_program add constraint fk_logs_master_program_05 foreign key (logged_by) references data_user (id);
alter table logs_master_program add constraint fk_logs_master_program_06 foreign key (subject_id) references data_master_program (id);
alter table sipd_master_program add constraint fk_sipd_master_program_01 foreign key (locked_by) references data_user (id);
alter table sipd_master_program add constraint fk_sipd_master_program_02 foreign key (created_by) references data_user (id);
alter table sipd_master_program add constraint fk_sipd_master_program_03 foreign key (updated_by) references data_user (id);
alter table sipd_master_program add constraint fk_sipd_master_program_04 foreign key (deleted_by) references data_user (id);
alter table sipd_master_program add constraint fk_sipd_master_program_05 foreign key (subject_id) references data_master_program (id);