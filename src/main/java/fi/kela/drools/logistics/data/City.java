package fi.kela.drools.logistics.data;

public class City {
	private String name;
	private double taxPerKgEuro;
	private double taxPerPersonEuro;
	private double personCostPerHourEuro;
	private double palletsPerPersonPerHour;
	
	public City(String name, double taxPerKgEuro, double taxPerPersonEuro, double personCostPerHourEuro,
			double palletsPerPersonPerHour) {
		this.name = name;
		this.taxPerKgEuro = taxPerKgEuro;
		this.taxPerPersonEuro = taxPerPersonEuro;
		this.personCostPerHourEuro = personCostPerHourEuro;
		this.palletsPerPersonPerHour = palletsPerPersonPerHour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTaxPerKgEuro() {
		return taxPerKgEuro;
	}

	public void setTaxPerKgEuro(double taxPerKgEuro) {
		this.taxPerKgEuro = taxPerKgEuro;
	}

	public double getTaxPerPersonEuro() {
		return taxPerPersonEuro;
	}

	public void setTaxPerPersonEuro(double taxPerPersonEuro) {
		this.taxPerPersonEuro = taxPerPersonEuro;
	}

	public double getPersonCostPerHourEuro() {
		return personCostPerHourEuro;
	}

	public void setPersonCostPerHourEuro(double personCostPerHourEuro) {
		this.personCostPerHourEuro = personCostPerHourEuro;
	}

	public double getPalletsPerPersonPerHour() {
		return palletsPerPersonPerHour;
	}

	public void setPalletsPerPersonPerHour(double palletsPerPersonPerHour) {
		this.palletsPerPersonPerHour = palletsPerPersonPerHour;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", taxPerKgEuro=" + taxPerKgEuro + ", taxPerPersonEuro=" + taxPerPersonEuro
				+ ", personCostPerHourEuro=" + personCostPerHourEuro + ", palletsPerPersonPerHour="
				+ palletsPerPersonPerHour + "]";
	}
	
}
