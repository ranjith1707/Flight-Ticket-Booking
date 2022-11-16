package controler;

public class LoginController {
	public boolean loginCheck(String userId, String password) {
		if (userId.equals("adminLogin") && password.equals("admin@123")) {
			return true;
		}

		return false;
	}
}
