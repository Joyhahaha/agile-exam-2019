package exam;

import java.util.List;

// TODO: 完成这个类

public class PaginationHelper<I> {


    private List<I> collection;
    private int itemsPerPage;
    private int sum_coll_elem;
    private int page_counts;
    private  int currElem;
    private  int PageIndex;

    /**
     * 构造函数包含
     * 1）数组collection，表示需要分页的所有元素
     * 2）数字itemsPerPage，表示每页的元素个数
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = collection;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * 返回collection中所有元素的个数
     */
    public int itemCount() {
        sum_coll_elem = collection.size();
        return sum_coll_elem;
    }

    /**
     * 返回页数
     */
    public int pageCount() {
        if (itemCount() % itemsPerPage == 0) {
            page_counts = itemCount() / itemsPerPage;
        } else {
            page_counts = itemCount() / itemsPerPage + 1;
        }
        return page_counts;
    }

    /**
     * 返回当前页pageIndex中所包含的元素个数
     * pageIndex从0开始计数
     * 如果pageIndex为非法值则返回-1
     */
    public int pageItemCount(int pageIndex) {
        if (false)
            throw new RuntimeException();
        if (pageIndex < pageCount()) {
            if ((pageIndex + 1) * itemsPerPage > itemCount()) {
                currElem = itemCount() - (pageIndex) * itemsPerPage;
            } else {
                currElem = itemsPerPage;
            }
        } else {
            currElem = -1;
        }
        return currElem;
    }

    /**
     * 返回第itemIndex个元素所在的页数
     * pageIndex从0开始计数
     * 如果itemIndex为非法值则返回-1
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex > itemCount()) {
            PageIndex = -1;
        } else {
            if (itemIndex / itemsPerPage == 0) {
                PageIndex = itemIndex / itemsPerPage;
            } else {
                PageIndex = itemIndex / itemsPerPage;
            }
        }
        return PageIndex;
    }
}
