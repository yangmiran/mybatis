package notice.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

import static common.JDBCTemp.getSession;

public class NoticeService {
	//의존성 주입(DI : Dependancy Injection)
	private NoticeDao ndao = new NoticeDao();
	
	public NoticeService() {}
	
	public ArrayList<Notice> selectAll(){
		SqlSession session = getSession();
		ArrayList<Notice> list = ndao.selectList(session);
		session.close();
		return list;
	}
	
	public Notice selectNotice(int noticeNo) {
		SqlSession session = getSession();
		Notice notice = ndao.selectOne(session, noticeNo);
		session.close();
		return notice;
	}
	
	public int insertNotice(Notice notice) {
		SqlSession session = getSession();
		int result = ndao.insertNotice(session, notice);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
	
	public int updateNotice(Notice notice) {
		SqlSession session = getSession();
		int result = ndao.updateNotice(session, notice);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
	
	public int deleteNotice(int noticeNo) {
		SqlSession session = getSession();
		int result = ndao.deleteNotice(session, noticeNo);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public ArrayList<Notice> selectNewTop3() {
		SqlSession session = getSession();
		ArrayList<Notice> list = ndao.selectNewTop3(session);
		session.close();
		return list;
	}
}
