package laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import laptrinhjavaweb.dao.INewsDAO;
import laptrinhjavaweb.model.NewsModel;
import laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO newsDao;	
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		// TODO Auto-generated method stub
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newsModel.setCreatedBy("");
		Long newsId = newsDao.save(newsModel);
		return newsDao.findOne(newsId);
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long id: ids) {
			newsDao.delete(id);
		}
	}

	@Override
	public NewsModel update(NewsModel updateNews) {
		// TODO Auto-generated method stub
		NewsModel oldNews = newsDao.findOne(updateNews.getId());
		updateNews.setCreatedDate(oldNews.getCreatedDate());
		updateNews.setCreatedBy(oldNews.getCreatedBy());
		updateNews.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNews.setModifiedBy("");
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}

}
