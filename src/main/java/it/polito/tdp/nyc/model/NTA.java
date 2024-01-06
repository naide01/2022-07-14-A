package it.polito.tdp.nyc.model;

import java.util.Set;

public class NTA {
	private String NTACode;
	private Set<String> SSIDs;
	
	
	public NTA(String nTACode, Set<String> sSIDs) {
		super();
		NTACode = nTACode;
		SSIDs = sSIDs;
	}
	public String getNTACode() {
		return NTACode;
	}
	public void setNTACode(String nTACode) {
		NTACode = nTACode;
	}
	public Set<String> getSSIDs() {
		return SSIDs;
	}
	public void setSSIDs(Set<String> sSIDs) {
		SSIDs = sSIDs;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NTA other = (NTA) obj;
		if (NTACode == null) {
			if (other.NTACode != null)
				return false;
		} else if (!NTACode.equals(other.NTACode))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NTACode: " + NTACode + " . SSIDs: " + SSIDs + "\n";
	}

	
}
