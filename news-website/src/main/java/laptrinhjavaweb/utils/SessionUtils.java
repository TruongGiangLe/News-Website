package laptrinhjavaweb.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	
	private static SessionUtils sessionUtils = null;
	
	public static SessionUtils getInstance() {
		if(sessionUtils == null) {
			sessionUtils = new SessionUtils();
			return sessionUtils;
		} else return sessionUtils;
	}
	
	public void putValue(HttpServletRequest request, String key, Object value) {
		// request dùng đề khởi tạo session
		// put giá trị cần duy trì vào session
		request.getSession().setAttribute(key, value);
		
	}
	
	public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest request, String key) {
		//remove giá trị sau khi đóng session
		request.getSession().removeAttribute(key);
	}
}
