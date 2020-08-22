package laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import laptrinhjavaweb.model.CategoryModel;

public class CategoryMapper implements IRowMapper<CategoryModel> {

	@Override
	public CategoryModel mapRow(ResultSet rs) {
		CategoryModel categoryModel = new CategoryModel();
		try {
			categoryModel.setId(rs.getLong("id"));
			categoryModel.setCode(rs.getString("code"));
			categoryModel.setName(rs.getString("name"));
			return categoryModel;
		} catch (SQLException e) {
			return null;
		}

	}

}
