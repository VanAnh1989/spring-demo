package demo.DAO.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import demo.model.UserAccount;

public class DataAccess {

	private SessionFactory sessF;
	private Session session;
	private Transaction trans;

	public DataAccess() {
		try {
			Configuration config = new Configuration();
			config.configure("demo/model/Hibernate.conf.xml");
			sessF = config.buildSessionFactory();
			session = sessF.openSession();
			trans = session.beginTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	public UserAccount getUserByUserName(String user, String pass) {
		try {
			UserAccount userAcc = new UserAccount();
			Query<UserAccount> query = session.createQuery("FROM UserAccount WHERE user_name =:user AND pass =:passWord");
			query.setParameter("user", user);
			query.setParameter("passWord", pass);
			userAcc = (UserAccount) query.uniqueResult();
			if (userAcc != null) {
				return userAcc;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public void SetUserAccount(UserAccount user) {
		try {
			session.save(user);
			System.out.println("why ");
			trans.commit();
			sessF.close();
			session.close();
		} catch (Exception e) {

		}
	}

}
