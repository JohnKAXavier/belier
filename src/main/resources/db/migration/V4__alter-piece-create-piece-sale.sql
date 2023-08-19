alter table piece add column quantity bigint;
create table piece_sale (id bigint not null auto_increment, quantity bigint, sold_at datetime(6), piece_id bigint, transaction_type_id bigint, primary key (id)) engine=InnoDB;
alter table piece_sale add constraint FK3qv0p007txqsibvqxx0ptxp4l foreign key (piece_id) references piece (id);
alter table piece_sale add constraint FK8s2vu16eungqmf0coi6kdkg4o foreign key (transaction_type_id) references transaction_type (id);