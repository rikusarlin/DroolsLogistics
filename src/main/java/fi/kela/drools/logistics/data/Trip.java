package fi.kela.drools.logistics.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Trip {
	private List<TripStep> steps = new ArrayList<TripStep>();
	
	public Trip(List<TripStep> steps) {
		this.steps = steps;
	}

	public List<TripStep> getSteps() {
		return steps;
	}

	public void setSteps(List<TripStep> steps) {
		this.steps = steps;
	}
	
	public Set<City> getTripCities() {
	   	// Helper to get trip cities, since start and destination cites overlap
    	Set<City> cities = new HashSet<City>();
    	for(TripStep tripStep:steps){
    		if(!cities.contains(tripStep.getStartCity())){
    			cities.add(tripStep.getStartCity());
    		}
    		if(!cities.contains(tripStep.getDestinationCity())){
    			cities.add(tripStep.getDestinationCity());
    		}
    	}
 		return cities;
	}

	@Override
	public String toString() {
		return "Trip [steps=" + steps + "]";
	}
	
}
