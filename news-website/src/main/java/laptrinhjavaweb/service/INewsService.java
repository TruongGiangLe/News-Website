package laptrinhjavaweb.service;

import java.util.List;

import laptrinhjavaweb.model.NewsModel;
import laptrinhjavaweb.paging.IPagable;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	void delete(long[] ids);
	NewsModel update(NewsModel updateNews);
	List<NewsModel> findAll(IPagable pageble);
	int getTotalItems();
	NewsModel findOne(Long id);
}
