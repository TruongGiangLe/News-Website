package laptrinhjavaweb.paging;

import laptrinhjavaweb.sort.Sorter;

public interface IPagable {
	Integer getPage();
	Integer getOffset();
	Integer getLimit();
	Sorter getSorter();
}
