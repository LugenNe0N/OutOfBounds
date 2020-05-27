/* DB作成 */
DROP DATABASE IF EXISTS task_db;
CREATE DATABASE task_db CHARACTER SET utf8 COLLATE utf8_general_ci;

/* ユーザを作成 */
DROP USER IF EXISTS taskU;
CREATE USER taskU IDENTIFIED BY 'taskP';

/* 権限付与 */
GRANT ALL PRIVILEGES ON task_db.* TO taskU;

USE task_db;

/*テーブル作成*/
CREATE TABLE m_user
(
    user_id                     VARCHAR(16) PRIMARY KEY NOT NULL,
    password                    VARCHAR(16) NOT NULL,
    name                        VARCHAR(40) UNIQUE NOT NULL,
    update_datetime             TIMESTAMP DEFAULT current_timestamp on update current_timestamp NOT NULL
);

CREATE TABLE m_category
(
  category_id                   INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  category_name                 VARCHAR(20) UNIQUE NOT NULL,
  update_datetime               TIMESTAMP DEFAULT current_timestamp on update current_timestamp NOT NULL
)

CREATE TABLE m_status
(
  status_code                   CHAR(2) PRIMARY KEY NOT NULL,
  status_name                   VARCHAR(20) UNIQUE NOT NULL,
  update_datetime               TIMESTAMP DEFAULT current_timestamp on update current_timestamp NOT NULL
)

CREATE TABLE t_task
(
  task_id                       INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  task_name                     VARCHAR(50) NOT NULL,
  category_id                   INT NOT NULL,
  limit_date                    DATE,
  user_id                       VARCHAR(20) NOT NULL,
  status_code                   CHAR(2) NOT NULL,
  memo                          VARCHAR(100),
  create_datetime               TIMESTAMP DEFAULT current_timestamp NOT NULL,
  update_datetime               TIMESTAMP DEFAULT current_timestamp on update current_timestamp NOT NULL,
  FOREIGN KEY(category_id) REFERENCES m_category(category_id),
  FOREIGN KEY(user_id) REFERENCES m_user(user_id),
)

INSERT INTO task_db.m_category (category_name) VALUES('新商品A：開発プロジェクト');
INSERT INTO task_db.m_category (category_name) VALUES('既存所品B：改良プロジェクト');

INSERT INTO task_db.m_status (status_code, status_name) VALUES(00, '未着手');
INSERT INTO task_db.m_status (status_code, status_name) VALUES(50, '着手');
INSERT INTO task_db.m_status (status_code, status_name) VALUES(99, '完了');
