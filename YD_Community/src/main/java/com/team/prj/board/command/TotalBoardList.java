package com.team.prj.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.prj.board.service.BoardService;
import com.team.prj.board.serviceImpl.BoardServiceImpl;
import com.team.prj.board.vo.BoardVO;
import com.team.prj.common.Command;

public class TotalBoardList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 커뮤니티 메인 게시글 목록 가져오기
		BoardService boardDao = new BoardServiceImpl();
		List<BoardVO> totalboardlist= new ArrayList<>();
		totalboardlist = boardDao.TboardSelectList();
		request.setAttribute("totalboardlist", totalboardlist);
		return "board/totalBoardList";
	}

}
