package com.daum.daumboard.Contorller;

import com.daum.daumboard.Service.BoardService;
import com.daum.daumboard.VO.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//view와 service의 연계처리
@Controller
public class BoardController {
    //로그로 정보출력
    private Logger logger = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    BoardService boardService; //서비스 주입하고 사용할 메소드 지정
    //get과 post 구분없이 맵핑 처리
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("인덱스 페이지 처리");
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    //목록
    @GetMapping("/board-list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("리스트 페이지 처리");
        List<BoardVO> lists = boardService.selectAllBoard();
        ModelAndView mav = new ModelAndView("/board/list");
        mav.addObject("lists",lists); //""이름이 html 에서 ${xx} 와 동일
        return mav;
    }

    //등록
    @GetMapping("/board-insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
        logger.info("등록 페이지 처리");
        //데이터베이처리가 없음
        ModelAndView mav = new ModelAndView("/board/insert");
        return mav;
    }

    @PostMapping("/board-insert")
    public ModelAndView insertProc(@ModelAttribute("BoardVO") BoardVO boardVO, HttpServletResponse response) throws Exception {
        logger.info("등록 내용 데이터베이스에 처리");
        boardService.insertBoard(boardVO);
        ModelAndView mav = new ModelAndView("redirect:/board-list");
        return mav;
    }

    //수정
    @GetMapping("/board-update")
    public ModelAndView update(@RequestParam("no") int no, HttpServletResponse response) throws Exception {
        logger.info("수정 페이지 처리");
        BoardVO boardVO = boardService.selectUpdate(no);
        ModelAndView mav = new ModelAndView("/board/update");
        mav.addObject("data",boardVO);
        return mav;
    }

    @PostMapping("/board-update")
    public ModelAndView indexProc(@ModelAttribute("BoardVO") BoardVO boardVO, HttpServletResponse response) throws Exception {
        logger.info("수정값 데이터베이스 처리");
        boardService.updateBoard(boardVO);
        ModelAndView mav = new ModelAndView("redirect:/board-list");
        return mav;
        //삭제
    }

    @GetMapping("/board-delete")
    public ModelAndView delete(@RequestParam("no") int no, HttpServletResponse response) throws Exception {
        logger.info("삭제 페이지 처리");
        boardService.deleteBoard(no);
        ModelAndView mav = new ModelAndView("redirect:/board-list");
        return mav;
    }
}
