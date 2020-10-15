package member.model.service;

import static common.JDBCTemp.getSession;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import member.model.dao.MemberDao;
import member.model.vo.Member;
import member.model.vo.SearchDate;

import static common.JDBCTemp.*;

public class MemberService {
	//의존성 주입 (DI : Dependancy Injection)
	private MemberDao mdao = new MemberDao();
	
	public MemberService() {}
	
	public Member loginCheck(Member member) {
		SqlSession session = getSession();
		member = mdao.loginCheck(session, member);
		session.close();
		return member;
	}

	public int insertMember(Member member) {
		SqlSession session = getSession();
		int result = mdao.insertMember(session, member); //insertMember : MemberDao에 create method로 소스만들기
		if(result > 0) 
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public Member selectMember(String userid) {
		SqlSession session = getSession();
		Member member = mdao.selectMember(session, userid);
		session.close();
		return member;
	}

	public int deleteMember(String userid) {
		SqlSession session = getSession();
		int result = mdao.deleteMember(session, userid);
		if(result > 0) 
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}
	
	public int updateMember(Member member) {
		SqlSession session = getSession();
		int result = mdao.updateMember(session, member);
		if(result > 0) 
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public ArrayList<Member> selectList() {
		SqlSession session = getSession();
		ArrayList<Member> list = mdao.selectList(session);
		session.close();
		return list;
		
	}

	public int updateLoginOK(Member member) {
		SqlSession session = getSession();
		int result = mdao.updateLoginOK(session, member);
		if(result > 0) 
			session.commit();
		else
			session.rollback();
		session.close();
		return result;
	}

	public ArrayList<Member> selectSearchUserid(String keyword) {
		SqlSession session = getSession();
		ArrayList<Member> list = mdao.selectSearchUserid(session, keyword);
		session.close();
		return list;
	}

	public ArrayList<Member> selectSearchGender(String keyword) {
		SqlSession session = getSession();
		ArrayList<Member> list = mdao.selectSearchGender(session, keyword);
		session.close();
		return list;
	}

	public ArrayList<Member> selectSearchAge(int keyword) {
		SqlSession session = getSession();
		ArrayList<Member> list = mdao.selectSearchAge(session, keyword);
		session.close();
		return list;
	}

	public ArrayList<Member> selectSearchEnrollDate(SearchDate date) {
		SqlSession session = getSession();
		ArrayList<Member> list = mdao.selectSearchEnrollDate(session, date);
		session.close();
		return list;
	}

	public ArrayList<Member> selectSearchLoginOk(String keyword) {
		SqlSession session = getSession();
		ArrayList<Member> list = mdao.selectSearchLoginOk(session, keyword);
		session.close();
		return list;
	}

	public int selectCheckId(String userid) {
		SqlSession session = getSession();
		int idcount = mdao.selectCheckId(session, userid);
		session.close();
		return idcount;
	}
}
