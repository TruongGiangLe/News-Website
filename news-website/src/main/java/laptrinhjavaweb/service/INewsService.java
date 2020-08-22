package laptrinhjavaweb.service;

import java.util.List;

import laptrinhjavaweb.model.NewsModel;

public interface INewsService {
	List<NewsModel> findByCategoryId(Long categoryId);
	NewsModel save(NewsModel newsModel);
	void delete(long[] ids);
	NewsModel update(NewsModel updateNews);
}
