package laptrinhjavaweb.dao.impl;

import java.util.List;

import laptrinhjavaweb.dao.IUserDAO;
import laptrinhjavaweb.mapper.UserMapper;
import laptrinhjavaweb.model.UserModel;

public class UserDAO extends AbtractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u ");
		sql.append(" INNER JOIN role AS r ON r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
	}

}
