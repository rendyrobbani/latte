drop table if exists logs_master_subfungsi;
drop table if exists data_master_subfungsi;
drop table if exists logs_master_fungsi;
drop table if exists data_master_fungsi;

create or replace table data_master_fungsi (
	id         char(2)      not null,
	code       char(2)      not null,
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
create or replace table logs_master_fungsi (
	id         bigint(20)   not null auto_increment,
	code       char(2)      not null,
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
	subject_id char(2)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table data_master_subfungsi (
	id         char(5)      not null,
	code       char(5)      not null,
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
	fungsi_id  char(2)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;
create or replace table logs_master_subfungsi (
	id         bigint(20)   not null auto_increment,
	code       char(5)      not null,
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
	subject_id char(5)      not null,
	primary key (id)
) engine = innodb
  charset = utf8mb4
  collate = utf8mb4_unicode_ci;

alter table data_master_fungsi add constraint ck_data_master_fungsi_01 check (id = code);
alter table data_master_subfungsi add constraint ck_data_master_subfungsi_01 check (id = code);
alter table data_master_subfungsi add constraint ck_data_master_subfungsi_02 check (fungsi_id is null or (left(id, length(fungsi_id)) = fungsi_id));

alter table data_master_fungsi add constraint fk_data_master_fungsi_01 foreign key (locked_by) references data_user (id);
alter table data_master_fungsi add constraint fk_data_master_fungsi_02 foreign key (created_by) references data_user (id);
alter table data_master_fungsi add constraint fk_data_master_fungsi_03 foreign key (updated_by) references data_user (id);
alter table data_master_fungsi add constraint fk_data_master_fungsi_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_fungsi add constraint fk_logs_master_fungsi_01 foreign key (locked_by) references data_user (id);
alter table logs_master_fungsi add constraint fk_logs_master_fungsi_02 foreign key (created_by) references data_user (id);
alter table logs_master_fungsi add constraint fk_logs_master_fungsi_03 foreign key (updated_by) references data_user (id);
alter table logs_master_fungsi add constraint fk_logs_master_fungsi_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_fungsi add constraint fk_logs_master_fungsi_05 foreign key (logged_by) references data_user (id);
alter table logs_master_fungsi add constraint fk_logs_master_fungsi_06 foreign key (subject_id) references data_master_fungsi (id);
alter table data_master_subfungsi add constraint fk_data_master_subfungsi_01 foreign key (locked_by) references data_user (id);
alter table data_master_subfungsi add constraint fk_data_master_subfungsi_02 foreign key (created_by) references data_user (id);
alter table data_master_subfungsi add constraint fk_data_master_subfungsi_03 foreign key (updated_by) references data_user (id);
alter table data_master_subfungsi add constraint fk_data_master_subfungsi_04 foreign key (deleted_by) references data_user (id);
alter table data_master_subfungsi add constraint fk_data_master_subfungsi_05 foreign key (fungsi_id) references data_master_fungsi (id);
alter table logs_master_subfungsi add constraint fk_logs_master_subfungsi_01 foreign key (locked_by) references data_user (id);
alter table logs_master_subfungsi add constraint fk_logs_master_subfungsi_02 foreign key (created_by) references data_user (id);
alter table logs_master_subfungsi add constraint fk_logs_master_subfungsi_03 foreign key (updated_by) references data_user (id);
alter table logs_master_subfungsi add constraint fk_logs_master_subfungsi_04 foreign key (deleted_by) references data_user (id);
alter table logs_master_subfungsi add constraint fk_logs_master_subfungsi_05 foreign key (logged_by) references data_user (id);
alter table logs_master_subfungsi add constraint fk_logs_master_subfungsi_06 foreign key (subject_id) references data_master_subfungsi (id);