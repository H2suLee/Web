package co.edu.newMaven.notice.vo;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NoticeVO {
	private int noticeId, noticeHit;
	private String noticeWriter, noticeTitle, noticeContent, noticeAttach, noticeAttachLoc;
	private Date noticeDate;
}
