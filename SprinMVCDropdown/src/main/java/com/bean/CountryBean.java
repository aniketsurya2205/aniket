package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class CountryBean {
	
	@Id
    @Column(name="countryId")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer countryId;
    
    @Column(name="countryName")
    private String countryName;
        
    
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
	
	

}
