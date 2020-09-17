package laptrinhjavaweb.service;

import java.util.List;

import laptrinhjavaweb.model.CategoryModel;

public interface ICategoryService {
	 List<CategoryModel> findAll();
	 CategoryModel findOne(Long id);
	 CategoryModel findOneByCode(String code);
}
