CREATE TABLE account
(
  accountNumber numeric(10,0) NOT NULL,  
  accountName character varying(60) NOT NULL,
  CONSTRAINT accountNumber_key PRIMARY KEY (accountNumber)
)
WITH (
  OIDS=FALSE
);