package laptrinhjavaweb.dao;

import laptrinhjavaweb.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
	
}
