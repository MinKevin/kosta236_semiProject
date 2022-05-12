package mapper.MyPage;

import domain.MyPage.*;
import org.apache.ibatis.session.RowBounds;

import java.util.List;


public interface Mapper {
    List<Attendance> listAttendance(int e_no, RowBounds rowBounds);

    PrivateInfo getUserInfo(String userId);

    List<PayStub> listPayStub(int e_no, RowBounds rowBounds);

    int insertPayStub(PayStub myPagePayStub);

    PayStub detailPayStub(int p_no);

    List<PhoneBook> listPhoneBook(int e_no, RowBounds rowBounds);

    int insertPhoneBook(PhoneBook phoneBook);

    int maxPb_No();

    PhoneBook selectPhoneBook(int pb_no);

    int updatePhoneBook(PhoneBook phoneBook);

    int countRow(int e_no, String tableName);

    int updatePrivateInfo(PrivateInfo privateInfo);

    int deletePhoneBook(int pb_no);

    List<AnnualLeave> listAnnualLeave(int e_no, RowBounds rowBounds);

    int maxAn_no();

    int insertAnnualLeave(AnnualLeave annualLeave);

    List<AnnualLeave> listAnnualLeaveByAdmin(RowBounds rowBounds);

    int updateAnnualLeave(AnnualLeave annualLeave);

    int countRowByAdmin(String tableName);
}
