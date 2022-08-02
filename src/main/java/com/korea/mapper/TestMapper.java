package com.korea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.korea.domain.BoardDTO;

public interface TestMapper {

	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();
	
	@Select("select * from tbl_board")
	public List<BoardDTO> SelectAll();
	
}
