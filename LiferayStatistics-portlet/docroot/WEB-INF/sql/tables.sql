create table Statistics_Statistics (
	statId LONG not null primary key,
	userId LONG,
	groupId LONG,
	actionDate DATE null,
	action VARCHAR(2000) null,
	portletId VARCHAR(2000) null,
	url VARCHAR(2000) null
);