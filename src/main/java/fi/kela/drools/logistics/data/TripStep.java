package fi.kela.drools.logistics.data;

public class TripStep {
	private City startCity;
	private City destinationCity;
	private double distanceKm;
	private Transportation transportation;
	
	public TripStep(City startCity, City destinationCity, double distanceKm, Transportation transportation) {
		this.startCity = startCity;
		this.destinationCity = destinationCity;
		this.distanceKm = distanceKm;
		this.transportation = transportation;
	}

	public City getStartCity() {
		return startCity;
	}

	public void setStartCity(City startCity) {
		this.startCity = startCity;
	}

	public City getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(City destinationCity) {
		this.destinationCity = destinationCity;
	}

	public double getDistanceKm() {
		return distanceKm;
	}

	public void setDistanceKm(double distanceKm) {
		this.distanceKm = distanceKm;
	}

	public Transportation getTransportation() {
		return transportation;
	}

	public void setTransportation(Transportation transportation) {
		this.transportation = transportation;
	}

	@Override
	public String toString() {
		return "TripStep [startCity=" + startCity + ", destinationCity=" + destinationCity + ", distanceKm="
				+ distanceKm + ", transportation=" + transportation + "]";
	}
	
	
}
