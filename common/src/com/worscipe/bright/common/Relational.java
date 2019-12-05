package com.worscipe.bright.common;

import java.util.Date;

public interface Relational {
	
	public Long getId();
	public void setId(Long id);

	public Long getEntityId();
	public void setEntityId(Long entityId);

	public Date getCreatedOn();
	public void setCreatedOn(Date createdOn);

	public Date getModifiedDate();
	public void setModifiedDate(Date modifiedDate);
}
