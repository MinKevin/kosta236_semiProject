package service;

import domain.MyPage.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class MyPageService {
    private static final MyPageService myPageService = new MyPageService();
    private static MyPageDao myPageDao;
    private static final int PAGE_SIZE = 5;

    public static MyPageService getInstance() {
        myPageDao = MyPageDao.getInstance();
        return myPageService;
    }

    public ListDB listDB(String tableName, int e_no, HttpServletRequest request) {
        int totalCount = 0;
        if ((tableName.substring(tableName.length()-5)).equals("Admin")) {
            totalCount = myPageDao.countPostByAdmin(tableName.substring(0, tableName.length()-7));
        } else {
            totalCount = myPageDao.countPost(e_no, tableName);
        }

        System.out.println("totalCount : " + totalCount);

        int totalPageCount = totalCount / PAGE_SIZE;
        if (totalCount % PAGE_SIZE != 0)
            totalPageCount++;

        String pageNum = request.getParameter("pageNum");
        if (pageNum == null)
            pageNum = "1";

        int requestPage = Integer.parseInt(pageNum);

        int startPage = requestPage - (requestPage - 1) % 5;
        int endPage = startPage + 4;
        if (endPage > totalPageCount)
            endPage = totalPageCount;

        int startRow = (requestPage - 1) * PAGE_SIZE;

        List list = null;
        switch (tableName) {
            case "Attendance":
                list = myPageDao.listAttendance(e_no, startRow, PAGE_SIZE);
                break;
            case "PhoneBook":
                list = myPageDao.listPhoneBook(e_no, startRow, PAGE_SIZE);
                break;
            case "PayStub":
                list = myPageDao.listPayStub(e_no, startRow, PAGE_SIZE);
                break;
            case "Annual":
                list = myPageDao.listAnnualLeave(e_no, startRow, PAGE_SIZE);
                break;
            case "AnnualByAdmin":
                list = myPageDao.listAnnualLeaveByAdmin(startRow, PAGE_SIZE);
                break;
        }

        ListDB listDB = new ListDB(list, requestPage, totalPageCount, startPage, endPage);

        return listDB;
    }

    public int insertAnnualLeave(AnnualLeave annualLeave) {
        return myPageDao.insertAnnualLeave(annualLeave);
    }

    public PrivateInfo getUserInfo(String userId) {
        return myPageDao.getUserInfo(userId);
    }

    public List<Attendance> ListAttendance(int e_no, HttpServletRequest request) {
        return null;
    }

    public static List<PayStub> getListPayStub(int e_no) {
        //return myPageDao.listPayStub(e_no);
        return null;
    }

    public void insertPayStub(PayStub myPagePayStub) {
        myPageDao.insertPayStub(myPagePayStub);
    }

    public PayStub detailPayStub(int p_no) {
        return myPageDao.detailPayStub(p_no);
    }

    public List<PhoneBook> ListPhoneBook(int e_no) {
        //return myPageDao.listPhoneBook(e_no);
        return null;
    }

    public int insertPhoneBook(PhoneBook phoneBook) {
        return myPageDao.insertPhoneBook(phoneBook);
    }

    public PhoneBook selectPhoneBook(int pb_no) {
        return myPageDao.selectPhoneBook(pb_no);
    }

    public int updatePhoneBook(PhoneBook phoneBook) {
        return myPageDao.updatePhoneBook(phoneBook);
    }

    public int updatePrivateInfo(PrivateInfo privateInfo) {
        return myPageDao.updatePrivateInfo(privateInfo);
    }

    public int deletePhoneBook(int pb_no) {
        return myPageDao.deletePhoneBook(pb_no);
    }

    public int updateAnnualLeave(AnnualLeave annualLeave) {
        return myPageDao.updateAnnualLeave(annualLeave);
    }
}
