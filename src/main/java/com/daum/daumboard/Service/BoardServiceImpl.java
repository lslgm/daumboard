package com.daum.daumboard.Service;


import com.daum.daumboard.DAO.BoardDAO;
import com.daum.daumboard.VO.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDAO boardDao;

    @Override
    public List<BoardVO> selectAllBoard() throws Exception {
        return boardDao.selectAllBoard();
    }

    @Override
    public void insertBoard(BoardVO boardVO) throws Exception {
         boardDao.insertBoard(boardVO);
    }

    @Override
    public BoardVO selectUpdate(int no) throws Exception {
        return boardDao.selectUpdate(no);
    }

    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
        boardDao.updateBoard(boardVO);
    }

    @Override
    public void deleteBoard(int no) throws Exception {
        boardDao.deleteBoard(no);
    }
}
