package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CountryBean;
import com.bean.StateBean;
import com.dao.StateDaoImpl;

@Service
public class StateServiceImpl {
	
	@Autowired
    private StateDaoImpl stateDao;
    
    
    
    public List<StateBean> loadState(Integer countryId) {
        return stateDao.loadState(countryId);
    }

    
    
    public List<CountryBean> listCountry() {
        return stateDao.listCountry( );
                
    }

}
