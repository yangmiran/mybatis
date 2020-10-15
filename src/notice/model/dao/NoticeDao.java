package notice.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDao {
	public NoticeDao() {}
	
	public ArrayList<Notice> selectList(SqlSession session) {
	      List<Notice> list = session.selectList("noticeMapper.selectList");
	      return (ArrayList<Notice>)list;	
	}
	
	public Notice selectOne(SqlSession session, int noticeNo) {
		return session.selectOne("noticeMapper.selectNotice", noticeNo);
	}
	
	public int insertNotice(SqlSession session, Notice notice) {
		return session.insert("noticeMapper.insertNotice", notice);
	}
	
	public int updateNotice(SqlSession session, Notice notice) {
		return session.update("noticeMapper.updateNotice", notice);
	}
	
	public int deleteNotice(SqlSession session, int noticeNo) {
		return session.delete("noticeMapper.deleteNotice", noticeNo);
	}

	public ArrayList<Notice> selectNewTop3(SqlSession session) {
		List<Notice> list = session.selectList("noticeMapper.selectNewTop3");
		return (ArrayList<Notice>)list;
	}
}
