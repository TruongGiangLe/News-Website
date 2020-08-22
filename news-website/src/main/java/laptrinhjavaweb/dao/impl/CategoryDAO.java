package laptrinhjavaweb.dao.impl;

import java.util.List;

import laptrinhjavaweb.dao.ICategoryDAO;
import laptrinhjavaweb.mapper.CategoryMapper;
import laptrinhjavaweb.model.CategoryModel;

public class CategoryDAO extends AbtractDAO<CategoryModel> implements ICategoryDAO {

	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}
