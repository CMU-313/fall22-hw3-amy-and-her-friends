create cached table T_REVIEW (REVIEW_ID varchar(36) not null, REV_DOC_ID varchar(36) not null, REV_USE_ID varchar(36) not null, NOTES text, OVERALL_SCORE int, primary key (REV_DOC_ID));

alter table T_REVIEW add constraint FK_REV_DOC_ID foreign key (REV_DOC_ID) references T_DOCUMENT (DOC_ID_C) on delete restrict on update restrict;
alter table T_REVIEW add constraint FK_REV_USE_ID foreign key (REV_USE_ID) references T_USER (USE_ID_C) on delete restrict on update restrict;