package laptrinhjavaweb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import laptrinhjavaweb.model.RoleModel;
import laptrinhjavaweb.model.UserModel;

public class UserMapper implements IRowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(rs.getLong("id"));
			userModel.setUserName(rs.getString("username"));
			userModel.setFullName(rs.getString("fullname"));
			userModel.setPassword(rs.getString("password"));
			userModel.setStatus(rs.getInt("status"));
			try {
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				userModel.setRole(role);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
