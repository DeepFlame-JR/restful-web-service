insert into user values(900001, sysdate(), 'User1', 'test1', '701010-1111111');
insert into user values(900002, sysdate(), 'User2', 'test2', '801010-2222222');
insert into user values(900003, sysdate(), 'User3', 'test3', '901010-3333333');


insert into post values(100001, 'My First post', 900001);
insert into post values(100002, 'My Second post', 900001);
