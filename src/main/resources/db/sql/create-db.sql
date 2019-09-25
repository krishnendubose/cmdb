CREATE SCHEMA cmdb AUTHORIZATION cmdb; 

create table cmdb.build (
buildId varchar(50),
appName varchar(50),
appVersion varchar(50),
buildVersion varchar(50),
buildDate varchar(50),
buildStatus varchar(50),
buildBy varchar(50),
commitId varchar(50)
);

CREATE SEQUENCE cmdb_buildId
AS BIGINT
START WITH 0
INCREMENT BY 1
;


/* https://www.codejava.net/frameworks/spring/spring-mvc-with-jdbctemplate-example*/