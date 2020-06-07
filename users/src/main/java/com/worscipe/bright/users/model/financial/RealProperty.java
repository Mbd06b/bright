package com.worscipe.bright.users.model.financial;

import java.math.BigDecimal;

public interface RealProperty extends Equity{
	
	enum IsoConstructonClass{
		ONE(1, "Frame"),
		TWO(2, "Joisted Masonry" ),
		THREE(3, "Noncombustible" ),
		FOUR(4, "Masonry noncombustible"),
		FIVE(5, "Modified fire resistive"),
		SIX(6, "Fire resistive");
		
	    int isoClassNumber;
		String description;

		IsoConstructonClass(int isoClassNumber, String description) {
			 this.isoClassNumber = isoClassNumber;
			 this.description = description;
		}
	}
	
	
	BigDecimal getReplacementCostValue();
    void setReplacementCostValue();
	
    Integer getArea();
    void setArea( Integer area );
    
    Integer getAdditionalCoveredArea();
    void setAdditionalCoveredArea();
    
    IsoConstructonClass getIsoClass();
    void setIsoConstructonClass( IsoConstructonClass isoConstructonClass );
    
    Integer getNumBed();
    void setNumBed( Integer numBed );
    
    Integer getNumBath();
    void setNumBath( Integer numBath );
    
    /**
     * 
     * @return
     */
    Integer getNumCarGarage();
    void setNumCarGarage( Integer numCarGarage );
    
    /** 
     *  Monthly Revenue is the monthly mortgage, rent, or income derived from the structure. 
     *  This could be positive when the structure is leased out.
     * 
     * @param monthlyObligation
     */
    void setMonthlyRevenue( BigDecimal revenue );
    BigDecimal getMonthlyRevenue();
    
    void setIsModular( Boolean isModular);
    Boolean isModular();
    
   
}
