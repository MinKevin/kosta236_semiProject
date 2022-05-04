package kosta.domain;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosta.mapper.EmpMapper;

public class LoginDao {
	private static LoginDao dao = new LoginDao();
	
	public static LoginDao getInstance() {
		return dao;
	}
	
	public LoginDao() {}
	
	public SqlSessionFactory getSqlSessionFactory() {
		//mybaits-config.xml => SqlSesstionFactory 변환
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public Emp loginEmp(Login login) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Emp emp = new Emp();
		try {
			emp = sqlSession.getMapper(EmpMapper.class).loginEmp(login);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return emp;
	}

	public int insertEmp(Emp emp) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(EmpMapper.class).insertEmp(emp);
			if (re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}

	public int checkId(String id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int check = -1;
		try {
			check = sqlSession.getMapper(EmpMapper.class).checkId(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}
		return check;
	}
	
//	public List<Board> listBoard(int startRow, Search search){ 
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		List<Board> list = null; 
//		try {
//			//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");//mapStatement 호출
//			list = sqlSession.getMapper(EmpMapper.class).listBoard(search, new RowBounds(startRow, 2));
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		
//		return list;
//	}
//	
//	public Board detailBoard(int seq) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		Board board = null;
//		try {
//			board = sqlSession.getMapper(EmpMapper.class).detailBoard(seq);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		
//		return board;
//	}
//	
//	public int updateBoard(Board board) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = -1;
//		try {
//			re = sqlSession.getMapper(EmpMapper.class).updateBoard(board);
//			if(re > 0) {	//트랜잭션처리 insert update delete 필수
//				sqlSession.commit();
//			}else {
//				sqlSession.rollback();
//			} 
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		return re;
//	}
//	
//	
//	public int deleteBoard(int seq) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = -1;
//		try {
//			re = sqlSession.getMapper(EmpMapper.class).deleteBoard(seq);
//			if(re > 0) {	//트랜잭션처리 insert update delete 필수
//				sqlSession.commit();
//			}else {
//				sqlSession.rollback();
//			} 
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession!=null) {
//				sqlSession.close();
//			}
//		}
//		return re;
//	}
//	
//	public int countBoard(Search search) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = 0;
//		try {
//			re = sqlSession.getMapper(EmpMapper.class).countBoard(search);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession!=null) {
//				sqlSession.close();
//			}
//		}
//		return re;
//	}
//	
//	public int insertReply(Reply reply) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = -1;
//		try {
//			re = sqlSession.getMapper(EmpMapper.class).insertReply(reply);
//			if(re > 0) {
//				sqlSession.commit();
//			}else {
//				sqlSession.rollback();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession!=null) {
//				sqlSession.close();
//			}
//		}
//		return re;
//	}
//
//	public List<Reply> listReply(int seq) {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		List<Reply> listReply = null; 
//		try {
//			//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");//mapStatement 호출
//			listReply = sqlSession.getMapper(EmpMapper.class).listReply(seq);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//		
//		return listReply;
//	}
	
}
