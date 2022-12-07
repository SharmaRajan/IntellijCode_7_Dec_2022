--This is for user
INSERT INTO users(username, password,enabled)
values('user','pass',true);

--This is for admin
INSERT INTO users(username, password,enabled)
values('admin','admin',true);

--authorities given for Role
INSERT INTO authorities(username, authority)
values('user','ROLE_USER');

INSERT INTO authorities(username, authority)
values('admin','ROLE_ADMIN');

