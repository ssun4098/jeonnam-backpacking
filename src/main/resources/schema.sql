drop table if exists `member`;

CREATE TABLE `member` (
                           `id`	bigint	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                           `email`	varchar(32)	NOT NULL UNIQUE,
                           `password`	varchar(256)	NOT NULL ,
                           `nickname` varchar(16) NOT NULL UNIQUE,
                           `grade` varchar(16) NOT NULL,
                           `sign_up_datetime`	datetime	NOT NULL ,
                           `info_up_datetime`   datetime,
                           `ban`	boolean	NOT NULL	DEFAULT false,
                           `ban_reason`	varchar(256),
                           `withdrawal`	boolean	NOT NULL	DEFAULT false
);
