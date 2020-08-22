package laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import laptrinhjavaweb.model.NewsModel;

public class NewsMapper implements IRowMapper<NewsModel>{

	@Override
	public NewsModel mapRow(ResultSet rs) {
		try {
			NewsModel newsModel = new NewsModel();
			newsModel.setId(rs.getLong("id"));
			newsModel.setTitle(rs.getString("title"));
			newsModel.setThumbnail(rs.getString("thumbnail"));
			newsModel.setCategoryId(rs.getLong("categoryid"));
			newsModel.setContent(rs.getString("content"));
			newsModel.setShortDescription(rs.getString("shortdescription"));
			newsModel.setCreatedDate(rs.getTimestamp("createddate"));
			newsModel.setCreatedBy(rs.getString("createdby"));
			if(rs.getString("modifiedby") != null) {
				newsModel.setModifiedBy(rs.getString("modifiedby"));
			}
			if(rs.getTimestamp("modifieddate") != null) {
				newsModel.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			return newsModel;
		} catch (SQLException e) {
			return null;
		}

	}


	
}
