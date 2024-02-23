package org.zerock.ex00.mappers;

import org.zerock.ex00.domain.BoardVO;

public interface BoardMapper {

  java.util.List<BoardVO> getList();

  int insert(BoardVO boardVO);

  BoardVO select(Long bno);

  int update(BoardVO boardVO);

}
