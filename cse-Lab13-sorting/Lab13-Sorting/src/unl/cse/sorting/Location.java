package unl.cse.sorting;

public class Location implements Comparable<Location> {

	private final String zipCode;
    private final String city;
    private final Double latitude;
    private final Double longitude;
    private final String state;

    public Location(String zipCode, Double latitude, Double longitude, String city, String state) {
    	this.zipCode = zipCode;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.state = state;
    }

    public String getCity() {
        return this.city;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getState() {
		return state;
	}

	/**
      * Complete the implementation of this method that will be used for sorting
      * using the java.util.Collections.sort method.
      * @param o
      * @return
      */
    @Override
    public int compareTo(Location l) {
    	//throw new UnsupportedOperationException("YOU MUST IMPLEMENT THIS");
    	//  Sort by zip, city, then state
    	return this.zipCode.compareTo(l.zipCode);
//    	if(compareZip == 0){
//    		int compareCity = this.city.compareTo(l.city);
//    		if(compareCity==0){
//    			int compareState = this.state.compareTo(l.state);
//    			return compareState;
//    		}else{
//    			return compareCity;
//    		}
//    	}else{
//    		return compareZip;
//    	}
    }

    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	sb.append(this.getCity());
    	sb.append(" ");
    	sb.append(this.getState());
    	sb.append(String.format("%10.10s\n",this.getZipCode()));
    	return sb.toString();
    }

}
