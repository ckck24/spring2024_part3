package org.zerock.ex00.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex00.domain.BoardVO;
import org.zerock.ex00.domain.Criteria;
import org.zerock.ex00.domain.PageDTO;
import org.zerock.ex00.service.BoardService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

  private final BoardService boardService;
  //list
//  @GetMapping("/list")
//  public void list(Model model){
//    log.info("list................");
//
//    java.util.List<BoardVO> list = boardService.list();
//
//    log.info(list);
//    log.info("리스트 출력");
//    log.info("리스트 출력");
//    log.info("리스트 출력");
//    log.info("리스트 출력");
//
//    model.addAttribute("list",list);
//
//  }

  @GetMapping("/list")
  public void list(
          @ModelAttribute("cri") Criteria criteria,
          Model model){
    log.info("list................");
    log.info("criteria: " + criteria);

    java.util.List<BoardVO> list = boardService.getList(criteria);

    log.info(list);
    log.info("리스트 출력");
    log.info("리스트 출력");
    log.info("리스트 출력");
    log.info("리스트 출력");

    model.addAttribute("list",list);

    PageDTO pageDTO = new PageDTO(criteria, boardService.getTotal(criteria));

    model.addAttribute("pageMaker", pageDTO);

  }


  @GetMapping({"/{job}/{bno}"})
  public String read(
          @PathVariable(name = "job") String job,
          @PathVariable(name = "bno") Long bno,
          @ModelAttribute("cri") Criteria criteria,
          Model model ) {

    log.info("job: " + job);
    log.info("bno: " + bno);

    if( !(  job.equals("read") || job.equals("modify")  ) ){
      throw new RuntimeException("Bad Request job");
    }

    BoardVO boardVO = boardService.get(bno);

    log.info("boardVO: " + boardVO);

    model.addAttribute("vo", boardVO);

    return "/board/"+job;

  }

  @GetMapping("/register")
  public void register() {

  }

  @PostMapping("/register")
  public String registerPost(BoardVO boardVO, RedirectAttributes rttr){

    log.info("boardVO: " + boardVO);

    Long bno = boardService.register(boardVO);

    log.info("bno: " + bno);

    rttr.addFlashAttribute("result", bno);

    return "redirect:/board/list";
  }


  @PostMapping("/remove/{bno}")
  public String remove(
          @PathVariable(name="bno") Long bno,
          RedirectAttributes rttr){

    BoardVO boardVO = new BoardVO();
    boardVO.setBno(bno);
    boardVO.setTitle("해당 글은 삭제 되었습니다");
    boardVO.setContent("해당 글은 삭제 되었습니다.");

    log.info("boardVO: " + boardVO);

    boardService.modify(boardVO);

    rttr.addFlashAttribute("result", boardVO.getBno());

    return "redirect:/board/list";

  }

  @PostMapping("/modify/{bno}")
  public String modify(
          @PathVariable(name="bno") Long bno,
          BoardVO boardVO,
          RedirectAttributes rttr){

    boardVO.setBno(bno);

    log.info("boardVO: " + boardVO);

    boardService.modify(boardVO);

    rttr.addFlashAttribute("result", boardVO.getBno());

    return "redirect:/board/read/"+bno;

  }



//  @GetMapping("/modify/{bno}")
//  public String modify(
//          @PathVariable(name = "bno") Long bno, Model model ) {
//
//    log.info("bno: " + bno);
//
//    BoardVO boardVO = boardService.get(bno);
//
//    log.info("boardVO: " + boardVO);
//
//    model.addAttribute("vo", boardVO);
//
//    return "/board/modify";
//
//  }




}
