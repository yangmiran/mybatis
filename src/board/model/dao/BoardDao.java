package board.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import board.model.vo.Board;
import board.model.vo.BoardPage;

public class BoardDao {

	public ArrayList<Board> selectTop3(SqlSession session) {
		List<Board> list = session.selectList("boardMapper.selectTop3");
		return (ArrayList<Board>)list;
	}

	public int getListCount(SqlSession session) {
		return session.selectOne("boardMapper.getListCount");
	}

	public ArrayList<Board> selectList(SqlSession session, int currentPage, int limit) {
		//전달된 값을 이용해서 출력할 시작행과 끝행을 계산함
		int startRow = (currentPage -1) * limit + 1;
		int endRow = startRow + limit -1;
		//2개의 값을 한 객체에 저장함
		BoardPage bpage = new BoardPage(startRow, endRow);
		
		List<Board> list = session.selectList("boardMapper.selectList", bpage);
		return (ArrayList<Board>)list;
	}

	public int insertOriginBoard(SqlSession session, Board board) {
		return session.insert("boardMapper.insertOriginBoard", board);
	}

	public int addReadCount(SqlSession session, int boardNum) {
		return session.update("boardMapper.addReadCount", boardNum);
	}

	public Board selectBoard(SqlSession session, int boardNum) {
		return session.selectOne("boardMapper.selectBoard", boardNum);
	}

	public int updateReplySeq(SqlSession session, Board reply) {
		int result = 0;
		
		if(reply.getBoardLevel() == 1) {
			result = session.update("boardMapper.updateReplySeq1", reply);
		}
		if(reply.getBoardLevel() == 2) {
			result = session.update("boardMapper.updateReplySeq2", reply);
		}
		
		return result;
	}

	public int insertReply(SqlSession session, Board reply) {
		int result = 0;

		if(reply.getBoardLevel() == 1) {
			result = session.insert("boardMapper.insertReply1", reply);
		}
		if(reply.getBoardLevel() == 2) {
			result = session.insert("boardMapper.insertReply2", reply);
		}
		
		return result;
	}

	public int deleteBoard(SqlSession session, Board board) {
		return session.delete("boardMapper.deleteBoard", board);
	}

	public int updateReply(SqlSession session, Board reply) {
		return session.delete("boardMapper.updateReply", reply);
	}

	public int updateOrigin(SqlSession session, Board board) {
		return session.update("boardMapper.updateOrigin", board);
	}


}
