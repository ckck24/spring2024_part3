package org.zerock.ex00.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@ToString
public class TodoDTO {

  private String title;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date dueDate;

}
