package laptrinhjavaweb.dao;

import java.util.List;

import laptrinhjavaweb.model.NewsModel;

public interface INewsDAO extends IGenericDAO<NewsModel>{
	List<NewsModel> findByCategoryId(Long categoryId);
	Long save(NewsModel newsModel);
	void delete(long id);
	NewsModel findOne(Long id);
	void update(NewsModel updateNews);
}
