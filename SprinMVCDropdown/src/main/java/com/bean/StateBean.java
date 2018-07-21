package com.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rajnikant panchal
 */
@Entity
@Table(name="state")
public class StateBean  {

	 @Id
	    @Column(name="stateId")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Integer stateId;
	    
	    @Column(name="stateName")
	    private String stateName;
	    
	    @ManyToOne
	    @JoinColumn(name="countryId", insertable = false, updatable = false)
	    private CountryBean country;
	    
	    @Column(name = "countryId")
	    private Integer countryId;

	    public Integer getCountryId() {
	        return countryId;
	    }

	    public void setCountryId(Integer countryId) {
	        this.countryId = countryId;
	    }
	    
	    
	    public Integer getStateId() {
	        return stateId;
	    }

	    public void setStateId(Integer stateId) {
	        this.stateId = stateId;
	    }

	    public String getStateName() {
	        return stateName;
	    }

	    public void setStateName(String stateName) {
	        this.stateName = stateName;
	    }

	    public CountryBean getCountry() {
	        return country;
	    }

	    public void setCountry(CountryBean country) {
	        this.country = country;
	    }
	    
	
	
	
}
