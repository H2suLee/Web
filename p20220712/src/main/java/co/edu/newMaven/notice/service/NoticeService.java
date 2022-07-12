package co.edu.newMaven.notice.service;

import java.util.List;

import co.edu.newMaven.notice.vo.NoticeVO;

public interface NoticeService {
	// 전체 조회
	List<NoticeVO> noticeSelectList();
	
	// 한 건 조회
	NoticeVO noticeSelectOne(NoticeVO vo);
	
	// 삽입
	int noticeInsert(NoticeVO vo);
	
	// 갱신
	int noticeUpdate(NoticeVO vo);
	
	// 삭제
	int deleteUpdate(NoticeVO vo);
	
	// 검색
	List<NoticeVO> noticeSearchList(String key, String val);
	
	

}
