package org.loginapp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.loginapp.model.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginDAO {
	
	@Autowired
	private SessionFactory factory;
	
	public boolean login(LoginDTO loginDTO){
		
		if(loginDTO.getUsername() == null || loginDTO.getPassword() == null){
			return false;
		}
		Session session = factory.openSession();
		Criteria c = session.createCriteria(LoginDTO.class);
		Criterion cn =  Restrictions.eq("username", loginDTO.getUsername());
		c.add(cn);
		LoginDTO dto =(LoginDTO) c.uniqueResult();
		if(dto == null){
			return false;
		}
		if(loginDTO.equals(dto)){
			return true;
		}
		
		return false;
	}

	@Override
	protected void finalize() throws Throwable {
		factory.close();
	}
	
}
