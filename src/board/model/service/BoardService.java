package board.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import board.model.dao.BoardDao;
import board.model.vo.Board;
import static common.JDBCTemp.getSession;

public class BoardService {
	//DI
	private BoardDao bdao = new BoardDao();
	
	public BoardService() {}

	public ArrayList<Board> selectTop3() {
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectTop3(session);
		session.close();
		return list;
	}

	public int getListCount() {
		SqlSession session = getSession();
		int listCount = bdao.getListCount(session);
		session.close();
		return listCount;
	}

	public ArrayList<Board> selectList(int currentPage, int limit) {
		SqlSession session = getSession();
		ArrayList<Board> list = bdao.selectList(session, currentPage, limit);
		session.close();
		return list;
	}

	public int insertOriginBoard(Board board) {
		SqlSession session = getSession();
		int result = bdao.insertOriginBoard(session, board);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public void addReadCount(int boardNum) {
		SqlSession session = getSession();
		int result = bdao.addReadCount(session, boardNum);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		
	}

	public Board selectBoard(int boardNum) {
		SqlSession session = getSession();
		Board board = bdao.selectBoard(session, boardNum);
		session.close();
		return board;
	}

	public int insertReply(Board reply) {
		SqlSession session = getSession();
		int result = bdao.insertReply(session, reply);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public void updateReplySeq(Board reply) {
		//댓글 순번 1증가
		SqlSession session = getSession();
		int result = bdao.updateReplySeq(session, reply);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
	}

	public int deleteBoard(Board board) {
		SqlSession session = getSession();
		int result = bdao.deleteBoard(session, board);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public int updateReply(Board reply) {
		SqlSession session = getSession();
		int result = bdao.updateReply(session, reply);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public int updateOrigin(Board board) {
		SqlSession session = getSession();
		int result = bdao.updateOrigin(session, board);
		if(result > 0)
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
}
