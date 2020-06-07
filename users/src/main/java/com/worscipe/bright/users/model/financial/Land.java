package com.worscipe.bright.users.model.financial;

import java.math.BigDecimal;

public interface Land extends Equity{
	
	
	String getAddress();
	void setAddress(String address);
	    
    BigDecimal getArea();
    void setArea( BigDecimal area );
	
	void setHasPool( Boolean hasPool );
    Boolean hasPool();
    
    void setHasSolar( Boolean hasSolar );
    Boolean hasSolar();
    
    void setHasSeptic( Boolean hasSeptic );
    Boolean hasSeptic();
    
    void setHasWell( Boolean hasWell );
    Boolean hasWell();
    
    void setHasBroadband( Boolean hasBroadband );
    Boolean hasBroadband();
    
    void setHasGridElectric( Boolean gridElectric );
    Boolean hasGridElectric();
    
    void setHasGridGas( Boolean gridGas );
    Boolean hasGridGas();
    

}
