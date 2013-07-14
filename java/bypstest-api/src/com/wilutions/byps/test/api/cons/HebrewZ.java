package com.wilutions.byps.test.api.cons;

import java.io.Serializable;

public class HebrewZ implements Serializable {

	private static final long serialVersionUID = 8073826324374162061L;
	
	@SuppressWarnings("unused")
	private String core;
	
	protected HebrewZ() {
		
	}
	
	public HebrewZ(String s) {
		this.core = s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((core == null) ? 0 : core.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HebrewZ other = (HebrewZ) obj;
		if (core == null) {
			if (other.core != null)
				return false;
		} else if (!core.equals(other.core))
			return false;
		return true;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}
	
	
}
