package com.daum.daumboard.DAO;


import com.daum.daumboard.VO.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDAO {

    public List<BoardVO> selectAllBoard() throws Exception;

    public void insertBoard(BoardVO boardVO) throws Exception;

    public BoardVO selectUpdate(int no) throws Exception;

    public void updateBoard(BoardVO boardVO) throws Exception;

    public void deleteBoard(int no) throws Exception;
}
