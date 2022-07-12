package co.edu.newMaven.notice.command;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.edu.newMaven.comm.Command;
import co.edu.newMaven.notice.service.NoticeService;
import co.edu.newMaven.notice.serviceImple.NoticeServiceImpl;
import co.edu.newMaven.notice.vo.NoticeVO;

public class NoticeInsert implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 등록(파일 업로드)
		int n = 0;
		NoticeService dao = new NoticeServiceImpl();
		NoticeVO vo = new NoticeVO();

		// 파일이 저장될 수 있는 패스 찾기
		String savePath = "C:\\Temp\\";

		// 실서버에서는 webapp 밑에 files 해줘야
		// String savePath = request.getServletContext().getRealPath("images");

		// 최대 파일 사이즈 100MB (200메가가 디폴트)
		int size = 1024 * 1024 * 1024;

		try {
			MultipartRequest multi = new MultipartRequest(request, savePath, size, "UTF-8",
					new DefaultFileRenamePolicy());

			String originalFileName = multi.getOriginalFileName("file");
			String saveFileName = multi.getFilesystemName("file");
			System.out.println("==============================================");
			System.out.println("original one: " + originalFileName);
			System.out.println("physical one: " + saveFileName);
			System.out.println("==============================================");

			vo.setNoticeWriter(multi.getParameter("noticeWriter"));
			vo.setNoticeDate(Date.valueOf(multi.getParameter("noticeDate")));
			vo.setNoticeTitle(multi.getParameter("noticeTitle"));
			vo.setNoticeContent(multi.getParameter("noticeContent"));
			if (originalFileName != null) {
				vo.setNoticeAttach(originalFileName);
				saveFileName = savePath + saveFileName; // 파일 경로를 더해줘야
				vo.setNoticeAttachLoc(saveFileName);
			}
			n = dao.noticeInsert(vo);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String returnPage = null;
		if (n != 0) {
			returnPage = "noticeList.do";
		} else {
			request.setAttribute("message", "게시글 등록 실패!");
			returnPage = "notice/noticeError";
		}
		return returnPage;
	}

}
