package org.zerock.ex00.domain;

import lombok.Data;

import java.time.LocalDateTime;

/*
create table tbl_board
(
    bno        int auto_increment
        primary key,
    title      varchar(500)                          not null,
    content    varchar(2000)                         not null,
    writer     varchar(100)                          not null,
    regDate    timestamp default current_timestamp() null,
    updateDate timestamp default current_timestamp() null
);

 */
@Data
public class BoardVO {

  private Long bno;
  private String title;
  private String content;
  private String writer;

  private LocalDateTime regDate;
  private LocalDateTime updateDate;
}
