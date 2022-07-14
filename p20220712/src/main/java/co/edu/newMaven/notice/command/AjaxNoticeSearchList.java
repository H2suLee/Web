package co.edu.newMaven.notice.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.newMaven.comm.Command;
import co.edu.newMaven.notice.service.NoticeService;
import co.edu.newMaven.notice.serviceImple.NoticeServiceImpl;
import co.edu.newMaven.notice.vo.NoticeVO;

public class AjaxNoticeSearchList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("????????");
		// 게시글 검색
		NoticeService dao = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<>();

		// jackson binder library
		// https://github.com/FasterXML/jackson-databind/blob/2.14/README.md
		ObjectMapper mapper = new ObjectMapper();
		String key = request.getParameter("key");
		String val = request.getParameter("val");
		System.out.println(key + " " + val);
		list = dao.noticeSearchList(key, val);
		String jsonList = null;
		try {
			jsonList = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ajax:" + jsonList;
	}
}
