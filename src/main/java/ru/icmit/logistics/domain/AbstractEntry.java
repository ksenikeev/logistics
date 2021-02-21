package ru.icmit.logistics.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class AbstractEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	public abstract Long getId();
	public abstract void setId(Long id);
}
