package demo.DAO.service;

import org.springframework.stereotype.Component;

import demo.DAO.factory.DataAccess;
import demo.model.UserAccount;

@Component
public class UserAccountService {
	
	private UserAccount useracc;

	public UserAccount getUseracc() {
		return useracc;
	}

	public void setUseracc(UserAccount useracc) {
		this.useracc = useracc;
	}
	
	public UserAccount getUserById(String user,String pass) {
		return new DataAccess().getUserByUserName(user,pass);
	}

	public void setAccount(UserAccount user) {
		new DataAccess().SetUserAccount(user);
	}
	
	
}
