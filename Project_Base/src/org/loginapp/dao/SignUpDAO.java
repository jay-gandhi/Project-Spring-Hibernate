package org.loginapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.loginapp.model.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class SignUpDAO {
	@Autowired
	private SessionFactory factory;
	
	@Transactional
	public void save(LoginDTO loginDTO){
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(loginDTO);
		session.getTransaction().commit();
		session.close();
	}
	
}
