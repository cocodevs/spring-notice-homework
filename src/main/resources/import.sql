-- 기본 회원
INSERT INTO MEMBER (name, email, password, user_role, created_date) VALUES ('admin', 'admin@rsupport.com', '$2a$10$xJ6HT5U7RldehbNa7RJouefiX6LQxh/Uj75NPdPoy/5tOBv62cpCS', '1', now());
INSERT INTO MEMBER (name, email, password, user_role, created_date) VALUES ('김다정', 'cocodev@naver.com', '$2a$10$xJ6HT5U7RldehbNa7RJouefiX6LQxh/Uj75NPdPoy/5tOBv62cpCS', '2', now());

-- 기본 게시글
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 1', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 2', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 3', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 4', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 5', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 6', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 7', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 8', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 9', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 10', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 11', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 12', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 13', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 14', '내용내용내용22222', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 15', '내용내용내용111', now(), 1);
INSERT INTO POST (title, contents, created_date, member_id) VALUES ('공지사항 16', '내용내용내용22222', now(), 1);

-- 기본 첨부 파일
INSERT INTO POST_FILE (file_path, file_size, original_file_name, post_id) VALUES ('/upload/sample/cat1.jpg', 120829, 'cat1.jpg', 16);
INSERT INTO POST_FILE (file_path, file_size, original_file_name, post_id) VALUES ('/upload/sample/cat2.jpg', 120829, 'cat2.jpg', 16);
INSERT INTO POST_FILE (file_path, file_size, original_file_name, post_id) VALUES ('/upload/sample/cat3.jpg', 120829, 'cat3.jpg', 15);
INSERT INTO POST_FILE (file_path, file_size, original_file_name, post_id) VALUES ('/upload/sample/cat1.jpg', 120829, 'cat1.jpg', 14);