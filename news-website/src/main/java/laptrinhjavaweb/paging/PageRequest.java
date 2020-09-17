package laptrinhjavaweb.paging;

import laptrinhjavaweb.sort.Sorter;

public class PageRequest implements IPagable {
	
	private Integer page;
	private Integer maxPageItems;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPageItems, Sorter sort) {
		// TODO Auto-generated constructor stub
		this.maxPageItems = maxPageItems;
		this.page = page;
		this.sorter = sort;
	}

	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		// TODO Auto-generated method stub
		if(this.maxPageItems != null && this.maxPageItems != null) return (this.page - 1) * this.maxPageItems;
		else return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.maxPageItems;
	}

	@Override
	public Sorter getSorter() {
		if(this.sorter != null) return this.sorter;
		return null;
	}



}
