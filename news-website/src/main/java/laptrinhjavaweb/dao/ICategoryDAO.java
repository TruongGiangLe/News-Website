package laptrinhjavaweb.dao;

import laptrinhjavaweb.model.CategoryModel;
import java.util.List;

public interface ICategoryDAO extends IGenericDAO<CategoryModel>{
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
}
