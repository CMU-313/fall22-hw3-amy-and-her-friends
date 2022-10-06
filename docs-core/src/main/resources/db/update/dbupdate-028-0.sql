create cached table T_REVIEW (REVIEW_ID varchar(36) not null, REV_USE_ID varchar(36) not null, APPLICANT_NAME text not null, NOTES text, OVERALL_SCORE varchar(1), primary key (REVIEW_ID));

alter table T_REVIEW add constraint FK_REV_USE_ID foreign key (REV_USE_ID) references T_USER (USE_ID_C) on delete restrict on update restrict;