package com.daum.daumboard.Service;


import com.daum.daumboard.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BoardService {

    public List<BoardVO> selectAllBoard() throws Exception;

    public void insertBoard(BoardVO boardVO) throws Exception;

    public BoardVO selectUpdate(int no) throws Exception;

    public void updateBoard(BoardVO boardVO) throws Exception;

    public void deleteBoard(int no) throws Exception;
}
