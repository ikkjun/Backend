package com.website.login.dao;

import com.website.login.BoardDto;

import java.util.List;

public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    int count() throws Exception;

    int insert(BoardDto boardDto) throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer bno) throws Exception;

    int update(BoardDto boardDto) throws Exception;
}