package com.yezhihao.www.po;

import com.yezhihao.www.dao.GetBookDao;

public class BookPagePo {
		private int curPage = 1; //当前是第几页
	    private int maxPage; //一共有多少页
	    private int maxRowCount; //一共有多少行
	    public int rowsPerPage = 8; //每页多少行
		public BookPagePo() {
			super();
		}
		public int getCurPage() {
			return curPage;
		}
		public void setCurPage(int curPage) {
			this.curPage = curPage;
		}
		public int getMaxPage() {
			return maxPage;
		}
		public void setMaxPage(int maxPage) {
			this.maxPage = maxPage;
		}
		public int getMaxRowCount() {
			return maxRowCount;
		}
		public void setMaxRowCount(int maxRowCount) {
			this.maxRowCount = maxRowCount;
		}
		public int getRowsPerPage() {
			return rowsPerPage;
		}
		public void setRowsPerPage(int rowsPerPage) {
			this.rowsPerPage = rowsPerPage;
		}
		
		public void setPageBean() throws Exception {
	        //得到总行数
			GetBookDao GetBookDao=new GetBookDao();
			int ret=GetBookDao.getBooknum();
	        this.setMaxRowCount(ret);
	        if (this.maxRowCount % this.rowsPerPage == 0) { //根据总行数计算总页数
	            this.maxPage = this.maxRowCount / this.rowsPerPage;
	        } else {
	            this.maxPage = this.maxRowCount / this.rowsPerPage + 1;
	        }
	    }

	
}
