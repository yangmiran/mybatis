package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JDBCTemp {
	//MyBatis 가 제공하는 sqlSession 인터페이스 생성 및 리턴 처리
	/*
	 *  mybatis-config 설정파일의 environment의 내용을 읽어와서
	 *  db 연결하고, PreparedStatement 객체 생성과 동일하게 처리됨
	*/
	public static SqlSession getSession() {
			SqlSession session = null;
			
			try {
//				String resources = "resources/mybatis-config.xml";
//				InputStream input = Resources.getResourceAsStream(resources);
//				SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//				SqlSessionFactory factory = builder.build(input);
//				session = factory.openSession(false);
				session = new SqlSessionFactoryBuilder().build(
						Resources.getResourceAsStream("resources/mybatis-config.xml")).openSession(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return session;
	}
}
