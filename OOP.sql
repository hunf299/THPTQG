USE OOP_schema;
create table users (
	id int not null,
    username varchar(12) not null,
    password varchar(30) not null,
    user_name nvarchar(50) not null
);
alter table users
add constraint pk_users primary key(username);
INSERT INTO users (id, username, password, user_name) 
VALUES 
(1, '066205003632', 'viethung', N'Nguyễn Việt Hùng');
create table candidate (
	name nvarchar(50) not null,
    gender nvarchar(3) not null,
    birthdate datetime not null,
    birthplace nvarchar(50) not null,
    nation nvarchar(30) not null,
    personal_id varchar(12) not null,
    livingaddress nvarchar(100) not null,
    highschool nvarchar(50) not null,
    mobilephone varchar(10) not null,
    email varchar(50) not null,
    contactaddress nvarchar(100) not null,
    thptqg int not null,
    edumethod varchar(4) not null,
    freecandidate nvarchar(30),
    math int,
    literature int,
    science int,
    social int,
    foreign_language int,
    physic int,
    chemistry int,
    bio int,
    history int,
    geography int,
    gdcd int
);
alter table candidate
add constraint pk_candiate primary key(personal_id);
alter table candidate
add constraint fk_can_user foreign key (personal_id) references users(username);
create table testinfo (
	personal_id varchar(12) not null primary key,
	candidateid varchar(12) not null,
    testvenue nvarchar(50) not null,
    checkintime datetime not null,
    testroom varchar(10) not null
);
alter table testinfo
add constraint fk_testi4_user foreign key (personal_id) references users(username);
create table subjectinfo (
	personal_id varchar(12) not null,
	subject_column varchar(50) not null,
    literature_column varchar(50) not null, 
    math_column varchar(50) not null,
    physic_column varchar(50) not null,
    chemistry_column varchar(50) not null,
    bio_column varchar(50) not null,
    foreignlanguage_column varchar(50) not null,
    history_column varchar(50) not null,
    geo_column varchar(50) not null,
    gdcd_column varchar(50) not null
);
alter table subjectinfo
add constraint fk_subjecti4_user foreign key (personal_id) references users(username);
INSERT INTO subjectinfo (personal_id, subject_column, literature_column, math_column, physic_column,chemistry_column,bio_column,foreignlanguage_column,history_column,geo_column,gdcd_column)
VALUES 
('066205003632','Phòng thi', 'A131','A131','A301','A301','A301','A302','X','X','X'),
('066205003632','Ngày thi','07-04','07-04','08-04','08-04','08-04','08-04','X','X','X'),
('066205003632','Giờ phát đề','09h00','14h00','07h30','08h30','09h30','14h20','X','X','X'),
('066205003632','Giờ làm bài','09h05','14h05','07h35','08h35','09h35','14h30','X','X','X');
CREATE TABLE request (
	personal_id VARCHAR(12) NOT NULL,
    request_order INT NOT NULL,
    uni_name NVARCHAR(100) NOT NULL,
    major NVARCHAR(50) NOT NULL,
    training_unit NVARCHAR(20) NOT NULL,
    training_program NVARCHAR(50) NOT NULL
);
alter table request
add constraint fk_request_user foreign key (personal_id) references users(username);
CREATE TABLE score (
	personal_id VARCHAR(12) not null primary key,
    math double not null,
    literature double not null,
    foreignlanguage double not null,
    physic varchar(3) not null,
    chemistry varchar(3) not null,
    bio varchar(3) not null,
    history varchar(3) not null,
    geography varchar(3) not null,
    gdcd varchar(3) not null
);
alter table score
add constraint fk_score_user foreign key (personal_id) references users(username);
alter table accepteduni
add constraint fk_accepteduni_user foreign key (personal_id) references users(username);
INSERT INTO uniinfo (id, name, major, training_unit, training_program, a00, a01, b00, c00, d00, d07)
VALUES 
('1','DAD-Đại học Đông Á', 'Quản trị Kinh doanh','Đại học','Đại trà','15','15','40','40','15','40'),
('2','DAD-Đại học Đông Á', 'Du lịch và Lữ hành','Đại học','Đại trà','40','15','40','15','15','40'),
('3','DAD-Đại học Đông Á', 'Ngôn ngữ Anh','Đại học','Đại trà','40','15','40','40','15','40'),
('4','DAD-Đại học Đông Á', 'Kỹ thuật Xây dựng','Đại học','Đại trà','15','15','40','40','15','40'),
('5','DDF-Đại học Ngoại Ngữ', 'Ngôn ngữ Anh','Đại học','Đại trà','40','23.22','40','40','23.22','40'),
('6','DDF-Đại học Ngoại Ngữ', 'Ngôn ngữ Trung','Đại học','Đại trà','40','40','40','40','25.28','40'),
('7','DDF-Đại học Ngoại Ngữ', 'Ngôn ngữ Nhật','Đại học','Đại trà','40','40','40','40','23.63','40'),
('8','DDF-Đại học Ngoại Ngữ', 'Ngôn ngữ Hàn','Đại học','Đại trà','40','40','40','40','25.14','40'),
('9','DDF-Đại học Ngoại Ngữ', 'Ngôn ngữ Pháp','Đại học','Đại trà','40','40','40','40','21.08','40'),
('10','CPN-Cao đẳng Phương Đông', 'Dược sĩ','Cao đẳng','Đại trà','0','0','0','0','0','0'),
('11','CPN-Cao đẳng Phương Đông', 'Điều dưỡng','Cao đẳng','Đại trà','0','0','0','0','0','0'),
('12','CPN-Cao đẳng Phương Đông', 'Quản trị dịch vụ du lịch và lữ hành','Cao đẳng','Đại trà','0','0','0','0','0','0'),
('13','CPN-Cao đẳng Phương Đông', 'Quản trị kinh doanh','Cao đẳng','Đại trà','0','0','0','0','0','0'),
('14','DDK-Đại học Bách Khoa', 'Kỹ thuật Cơ khí','Đại học','Đại trà','24.55','24.55','40','40','40','40'),
('15','DDK-Đại học Bách Khoa', 'Khoa học Máy tính','Đại học','Đại trà','25.55','25.55','40','40','40','40'),
('16','DDK-Đại học Bách Khoa', 'Kỹ thuật Môi trường','Đại học','Đại trà','17.5','40','17.5','40','40','17.5'),
('17','DDK-Đại học Bách Khoa', 'Công nghệ Thực phẩm','Đại học','Đại trà','22.1','40','22.1','40','40','22.1'),
('18','DDK-Đại học Bách Khoa', 'Điện tử Viễn thông','Đại học','Tiên tiến','40','22.63','40','40','40','22.63'),
('19','DDQ-Đại học Kinh Tế', 'Quản trị Kinh doanh','Đại học','Đại trà','24.75','24.75','40','40','24.75','40'),
('20','DDQ-Đại học Kinh Tế', 'Kinh tế Quốc tế','Đại học','Đại trà','26.5','26.5','40','40','26.5','40'),
('21','DDQ-Đại học Kinh Tế', 'Kế toán','Đại học','Đại trà','23.85','23.85','40','40','23.85','40'),
('22','DDQ-Đại học Kinh Tế', 'Tài chính - Ngân hàng','Đại học','Đại trà','24','24','40','40','24','40'),
('23','DDQ-Đại học Kinh Tế', 'Marketing','Đại học','Đại trà','25.75','25.75','40','40','25.75','40'),
('24','DDY-Khoa Y dược-Đại học Đà Nẵng', 'Y khoa','Đại học','Đại trà','27','40','25.05','40','40','40'),
('25','DDY-Khoa Y dược-Đại học Đà Nẵng', 'Dược học','Đại học','Đại trà','24.56','40','24.56','40','40','40'),
('26','DDY-Khoa Y dược-Đại học Đà Nẵng', 'Điều dưỡng','Đại học','Đại trà','40','40','20.95','40','40','40'),
('27','DDY-Khoa Y dược-Đại học Đà Nẵng', 'Kỹ thuật Y học','Đại học','Đại trà','40','40','19.05','40','40','40'),
('28','DDY-Khoa Y dược-Đại học Đà Nẵng', 'Y học Cổ truyền','Đại học','Đại trà','40','40','20.05','40','40','40'),
('29','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Công nghệ thông tin (kỹ sư)','Đại học','Đại trà','25.01','25.01','40','40','25.01','40'),
('30','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Công nghệ thông tin (cử nhân)','Đại học','Đại trà','23.5','23.5','40','40','23.5','40'),
('31','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'An toàn thông tin (kỹ sư)','Đại học','Đại trà','23','23','40','40','23','40'),
('32','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Trí tuệ nhân tạo','Đại học','Đại trà','25.01','25.01','40','40','25.01','40'),
('33','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Công nghệ Truyền thông','Đại học','Đại trà','23.5','23.5','40','40','23.5','40'),
('34','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Công nghệ kỹ thuật máy tính','Đại học','Đại trà','23','23','40','40','23','40'),
('35','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Chuyên ngành Thiết kế mỹ thuật số','Đại học','Đại trà','24','24','40','40','24','40'),
('36','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Chuyên ngành thiết kế Vi mạch bán dẫn','Đại học','Đại trà','24','24','40','40','24','40'),
('37','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Marketing','Đại học','Đại trà','23','23','40','40','23','40'),
('38','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Chuyên ngành Quản trị Logistics và Chuỗi cung ứng số','Đại học','Đại trà','23','23','40','40','23','40'),
('39','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Chuyên ngành Quản trị Dịch vụ du lịch và Lữ hành số','Đại học','Đại trà','22.5','22.5','40','40','22.5','40'),
('40','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Chuyên ngành Quản trị Tài chính số','Đại học','Đại trà','22.5','22.5','40','40','22.5','40'),
('41','VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn', 'Chuyên ngành Quản trị Dự án Công nghệ thông tin','Đại học','Đại trà','22','22','40','40','22','40'),
('42','DDT-Đại học Duy Tân', 'Công nghệ Thông tin','Đại học','Đại trà','14','14','40','40','14','40'),
('43','DDT-Đại học Duy Tân', 'Quản trị Kinh doanh','Đại học','Đại trà','14','40','40','40','14','40'),
('44','DDT-Đại học Duy Tân', 'Du lịch','Đại học','Đại trà','14','40','40','40','14','40'),
('45','DDT-Đại học Duy Tân', 'Ngoại ngữ','Đại học','Đại trà','40','40','40','40','14','40'),
('46','DDT-Đại học Duy Tân', 'Kỹ thuật Môi trường','Đại học','Đại trà','14','14','40','40','40','40'),
('47','DDT-Đại học Duy Tân', 'Kiến trúc','Đại học','Đại trà','40','40','40','40','40','40'),
('48','FPT-Đại học FPT Đà Nẵng', 'Công nghệ Thông tin','Đại học','Đại trà','21','21','40','40','21','40'),
('49','FPT-Đại học FPT Đà Nẵng', 'Quản trị Kinh doanh','Đại học','Đại trà','21','21','40','40','21','40'),
('50','FPT-Đại học FPT Đà Nẵng', 'Thiết kế Đồ họa','Đại học','Đại trà','21','21','40','40','21','40'),
('51','FPT-Đại học FPT Đà Nẵng', 'Truyền thông Đa phương tiện','Đại học','Đại trà','21','21','40','40','21','40'),
('52','FPT-Đại học FPT Đà Nẵng', 'Ngôn ngữ Anh','Đại học','Đại trà','21','21','40','40','21','40'),
('53','FPT-Đại học FPT Đà Nẵng', 'Ngôn ngữ Nhật','Đại học','Đại trà','21','21','40','40','21','40'),
('54','YDN-Đại học Kỹ thuật Y-Dược', 'Kỹ thuật Xét nghiệm Y học','Đại học','Đại trà','19','40','19','40','40','40'),
('55','YDN-Đại học Kỹ thuật Y-Dược', 'Kỹ thuật Hình ảnh Y học','Đại học','Đại trà','19','40','19','40','40','40'),
('56','YDN-Đại học Kỹ thuật Y-Dược', 'Kỹ thuật Phục hồi Chức năng','Đại học','Đại trà','19','40','19','40','40','40'),
('57','YDN-Đại học Kỹ thuật Y-Dược', 'Điều dưỡng','Đại học','Đại trà','19','40','19','40','40','40'),
('58','DSK-Đại học Sư phạm Kỹ thuật', 'Kỹ thuật Điện - Điện tử','Đại học','Đại trà','20.7','20.7','40','40','20.7','40'),
('59','DSK-Đại học Sư phạm Kỹ thuật', 'Kỹ thuật Cơ khí','Đại học','Đại trà','19.7','19.7','40','40','19.7','40'),
('60','DSK-Đại học Sư phạm Kỹ thuật', 'Kỹ thuật Xây dựng','Đại học','Đại trà','15','15','40','40','15','40'),
('61','DSK-Đại học Sư phạm Kỹ thuật', 'Công nghệ Thông tin','Đại học','Đại trà','23.79','23.79','40','40','23.79','40'),
('62','DSK-Đại học Sư phạm Kỹ thuật', 'Sư phạm Kỹ thuật','Đại học','Đại trà','21.7','21.7','40','40','21.7','40');

