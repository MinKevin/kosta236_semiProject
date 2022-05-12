package domain.MyPage;

import mapper.MyPage.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyPageDao {
    private static MyPageDao myPageDao = new MyPageDao();

    public static MyPageDao getInstance() {
        return myPageDao;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "resources/mybatis-config-MyPage.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    public int countPost(int e_no, String tableName) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try {
            result = sqlSession.getMapper(Mapper.class).countRow(e_no, tableName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;
    }

    public int countPostByAdmin(String tableName) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try {
            result = sqlSession.getMapper(Mapper.class).countRowByAdmin(tableName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;
    }

    public PrivateInfo getUserInfo(String userId) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PrivateInfo myPagePrivateInfo = null;
        try {
            myPagePrivateInfo = sqlSession.getMapper(Mapper.class).getUserInfo(userId);
            System.out.println("dao userNo : " + myPagePrivateInfo.getE_No());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return myPagePrivateInfo;
    }

    public List listAnnualLeave(int e_no, int startRow, int PAGE_SIZE) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<AnnualLeave> listAnnualLeave = null;
        try {
            listAnnualLeave = sqlSession.getMapper(Mapper.class).listAnnualLeave(e_no, new RowBounds(startRow, PAGE_SIZE));
            System.out.println("listAttendance.size() : " + listAnnualLeave.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return listAnnualLeave;
    }

    public List listAnnualLeaveByAdmin(int startRow, int PAGE_SIZE) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<AnnualLeave> listAnnualLeave = null;
        try {
            listAnnualLeave = sqlSession.getMapper(Mapper.class).listAnnualLeaveByAdmin(new RowBounds(startRow, PAGE_SIZE));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return listAnnualLeave;
    }

    public int insertAnnualLeave(AnnualLeave annualLeave) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try {
            int an_no = sqlSession.getMapper(Mapper.class).maxAn_no();
            annualLeave.setAn_no(an_no + 1);
            result = sqlSession.getMapper(Mapper.class).insertAnnualLeave(annualLeave);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;
    }

    public int updateAnnualLeave(AnnualLeave annualLeave) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        System.out.println(annualLeave.getAn_acknowledge());
        System.out.println(annualLeave.getAn_no());
        try {
            result = sqlSession.getMapper(Mapper.class).updateAnnualLeave(annualLeave);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;
    }

    public List<Attendance> listAttendance(int e_no, int startRow, int PAGE_SIZE) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<Attendance> listAttendance = null;
        try {
            listAttendance = sqlSession.getMapper(Mapper.class).listAttendance(e_no, new RowBounds(startRow, PAGE_SIZE));
            System.out.println("listAttendance.size() : " + listAttendance.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return listAttendance;
    }

    public List<PayStub> listPayStub(int e_no, int startRow, int PAGE_SIZE) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<PayStub> listPayStub = null;
        try {
            listPayStub = sqlSession.getMapper(Mapper.class).listPayStub(e_no, new RowBounds(startRow, PAGE_SIZE));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return listPayStub;
    }

    public void insertPayStub(PayStub myPagePayStub) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try {
            result = sqlSession.getMapper(Mapper.class).insertPayStub(myPagePayStub);
            System.out.println("inserPayStub result : " + result);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
    }

    public PayStub detailPayStub(int p_no) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PayStub detailPayStub = null;
        try {
            detailPayStub = sqlSession.getMapper(Mapper.class).detailPayStub(p_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return detailPayStub;
    }

    public List<PhoneBook> listPhoneBook(int e_no, int startRow, int PAGE_SIZE) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<PhoneBook> listPhoneBook = null;
        try {
            listPhoneBook = sqlSession.getMapper(Mapper.class).listPhoneBook(e_no, new RowBounds(startRow, PAGE_SIZE));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return listPhoneBook;

    }

    public int insertPhoneBook(PhoneBook phoneBook) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try {
            int pb_No = sqlSession.getMapper(Mapper.class).maxPb_No();
            phoneBook.setPb_No(pb_No + 1);
            result = sqlSession.getMapper(Mapper.class).insertPhoneBook(phoneBook);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;
    }

    public PhoneBook selectPhoneBook(int pb_no) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        PhoneBook phoneBook = null;
        try {
            phoneBook = sqlSession.getMapper(Mapper.class).selectPhoneBook(pb_no);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return phoneBook;
    }

    public int updatePhoneBook(PhoneBook phoneBook) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try {
            System.out.println("update in dao : " + phoneBook.getPb_Email());
            result = sqlSession.getMapper(Mapper.class).updatePhoneBook(phoneBook);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;

    }

    public int updatePrivateInfo(PrivateInfo privateInfo) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try{
            result = sqlSession.getMapper(Mapper.class).updatePrivateInfo(privateInfo);
            System.out.println("result in UPI : " + result);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null)
                sqlSession.close();
        }
        return result;
    }

    public int deletePhoneBook(int pb_no) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;
        try{
            result = sqlSession.getMapper(Mapper.class).deletePhoneBook(pb_no);
            if (result > 0)
                sqlSession.commit();
            else
                sqlSession.rollback();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(sqlSession != null)
                sqlSession.close();
        }
        return result;
    }



}

