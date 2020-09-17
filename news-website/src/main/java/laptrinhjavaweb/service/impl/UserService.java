package laptrinhjavaweb.service.impl;

import javax.inject.Inject;

import laptrinhjavaweb.dao.IUserDAO;
import laptrinhjavaweb.model.UserModel;
import laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		// TODO Auto-generated method stub
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}


	
}
