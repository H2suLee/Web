package co.edu.newMaven.notice.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.newMaven.comm.Command;
import co.edu.newMaven.notice.service.NoticeService;
import co.edu.newMaven.notice.serviceImple.NoticeServiceImpl;
import co.edu.newMaven.notice.vo.NoticeVO;

public class NoticeList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = dao.noticeSelectList();
		request.setAttribute("list", list);
		return "notice/noticeList";
	}

}
