package org.az.app.confRoomBook.utils.model;

/**
 * @author Logeswaran Murugesan
 *
 */
public class Pagination {
    
    private int currentPageNum;
    private int pageCount;
    private Long totalRecords;
    
    public Pagination() {
        
    }
    
    /**
     * 
     * @param currentPageNum
     * @param pageCount
     * @param totalPages
     */
    public Pagination(int currentPageNum, int pageCount, Long totalPages) {
        super();
        this.currentPageNum = currentPageNum;
        this.pageCount = pageCount;
        this.totalRecords = totalPages;
    }
    
    /**
     * @return the currentPageNum
     */
    public int getCurrentPageNum() {
        return currentPageNum;
    }
    
    /**
     * @param currentPageNum
     *            the currentPageNum to set
     */
    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }
    
    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }
    
    /**
     * @param pageCount
     *            the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    
    /**
     * @return the totalRecords
     */
    public Long getTotalRecords() {
        return totalRecords;
    }
    
    /**
     * @param totalRecords
     *            the totalRecords to set
     */
    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Pagination [currentPageNum=");
        builder.append(currentPageNum);
        builder.append(", pageCount=");
        builder.append(pageCount);
        builder.append(", totalPages=");
        builder.append(totalRecords);
        builder.append("]");
        return builder.toString();
    }
}
