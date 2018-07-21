package com.dao;

import com.bean.CountryBean;
import com.bean.StateBean;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StateDaoImpl {


	@Autowired
    private SessionFactory sessionFactory;

	Session ses;
/*    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
*/
public List<CountryBean> listCountry(){

	 ses=sessionFactory.openSession();
	
	
        return ses.createQuery("from CountryBean").list();
        
    }


public List<StateBean> loadState(Integer countryId) {

	ses.clear();
	ses=sessionFactory.openSession(); 
	
	System.out.println("before load state");
	
List<StateBean>	ls=ses.createQuery(" select s from StateBean s where s.countryId=" + countryId).list();


System.out.println("after load state");


	return ls;

    }

}
