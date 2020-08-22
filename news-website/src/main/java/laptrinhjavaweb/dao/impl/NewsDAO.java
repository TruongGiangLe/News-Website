package laptrinhjavaweb.dao.impl;

import java.util.List;

import laptrinhjavaweb.dao.INewsDAO;
import laptrinhjavaweb.mapper.NewsMapper;
import laptrinhjavaweb.model.NewsModel;

public class NewsDAO extends AbtractDAO<NewsModel> implements INewsDAO {

	@Override
	public List<NewsModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM news WHERE categoryid = ?";
		return query(sql, new NewsMapper(), categoryId);
	}

	@Override
	public Long save(NewsModel newsModel) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO news(title,content,categoryid,shortdescription,thumbnail,createddate,createdby) VALUES (?,?,?,?,?,?,?)";
		return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId(),
				newsModel.getShortDescription(), newsModel.getThumbnail(), newsModel.getCreatedDate(),
				newsModel.getCreatedBy());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM news WHERE id = ?";
		update(sql, id);
	}

	@Override
	public NewsModel findOne(Long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewsModel> news = query(sql, new NewsMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewsModel updateNews) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ?, modifieddate = ?, modifiedby = ? WHERE id = ?;");
		update(sql.toString(), updateNews.getTitle(), updateNews.getThumbnail(), updateNews.getShortDescription(),
				updateNews.getContent(), updateNews.getCategoryId(), updateNews.getCreatedDate(),
				updateNews.getCreatedBy(), updateNews.getModifiedDate(), updateNews.getModifiedBy(),
				updateNews.getId());

	}

}
