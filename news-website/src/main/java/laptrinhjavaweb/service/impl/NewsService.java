package laptrinhjavaweb.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import laptrinhjavaweb.dao.ICategoryDAO;
import laptrinhjavaweb.dao.INewsDAO;
import laptrinhjavaweb.model.CategoryModel;
import laptrinhjavaweb.model.NewsModel;
import laptrinhjavaweb.paging.IPagable;
import laptrinhjavaweb.service.INewsService;

public class NewsService implements INewsService{
	@Inject
	private INewsDAO newsDao;	
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return newsDao.findByCategoryId(categoryId);
	}

	@Override
	public NewsModel save(NewsModel newsModel) {
		// TODO Auto-generated method stub
		newsModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel categoryModel = categoryDao.findOneByCode(newsModel.getCategoryCode());
		newsModel.setCategoryId(categoryModel.getId());
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
		CategoryModel categoryModel = categoryDao.findOneByCode(updateNews.getCategoryCode());
		updateNews.setCategoryId(categoryModel.getId());
		newsDao.update(updateNews);
		return newsDao.findOne(updateNews.getId());
	}

	@Override
	public List<NewsModel> findAll(IPagable pageble) {
		// TODO Auto-generated method stub
		return newsDao.findAll(pageble);
	}

	@Override
	public int getTotalItems() {
		return newsDao.getTotalItems();
	}

	@Override
	public NewsModel findOne(Long id) {
		NewsModel newsModel = newsDao.findOne(id);
		// lấy code thể loại bài viết
		CategoryModel categoryModel = categoryDao.findOne(newsModel.getCategoryId());
		newsModel.setCategoryCode(categoryModel.getCode());
		return newsModel;
	}

}
