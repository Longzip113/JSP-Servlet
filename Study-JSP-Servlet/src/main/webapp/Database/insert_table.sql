use NewServlet;

insert into role(code,name) values('ADMIN','Quan Tri');
insert into role(code,name) values('USER','Nguoi Dung');

insert into user(username,password,fullname,status, roleid) values('admin','123456','admin',1,1);
insert into user(username,password,fullname,status, roleid) values('nguyenvana','123456','nguyen van a',1,2);
insert into user(username,password,fullname,status, roleid) values('nguyenvanb','123456','nguyen van b',1,2);