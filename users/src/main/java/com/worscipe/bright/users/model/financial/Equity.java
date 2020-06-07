package com.worscipe.bright.users.model.financial;

import java.math.BigDecimal;
import java.util.Date;

public interface Equity {
	
	Long getId();
	void setId(Long id);
	
	String getName();
	void setName( String name);
	
	Date getAquisitionDate();
	void setAquisitionDate( Date date );
	
	void getCostBasis();
	BigDecimal setCostBasis();
			
	void setMarketValue( BigDecimal marketValue );
	BigDecimal getMarketValue();

}
