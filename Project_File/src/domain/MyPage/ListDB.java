package domain.MyPage;

import java.io.Serializable;
import java.util.List;

public class ListDB implements Serializable {
    private List list;
    private int requestPage;
    private int totalPageCount;
    private int startPage;
    private int endPage;

    public ListDB(int requestPage, int totalPageCount, int startPage, int endPage){}

    public ListDB(List list, int requestPage, int totalPageCount, int startPage, int endPage) {
        this.list = list;
        this.requestPage = requestPage;
        this.totalPageCount = totalPageCount;
        this.startPage = startPage;
        this.endPage = endPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getRequestPage() {
        return requestPage;
    }

    public void setRequestPage(int requestPage) {
        this.requestPage = requestPage;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
