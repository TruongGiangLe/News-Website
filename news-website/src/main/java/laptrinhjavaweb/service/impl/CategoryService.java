package laptrinhjavaweb.service.impl;

import java.util.List;

import javax.inject.Inject;

import laptrinhjavaweb.dao.ICategoryDAO;
import laptrinhjavaweb.model.CategoryModel;
import laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService{
		
	
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		return categoryDAO.findAll();
	}
	@Override
	public CategoryModel findOne(Long id) {
		return categoryDAO.findOne(id);
	}
	@Override
	public CategoryModel findOneByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
