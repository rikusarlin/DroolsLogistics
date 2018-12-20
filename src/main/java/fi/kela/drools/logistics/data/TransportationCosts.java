package fi.kela.drools.logistics.data;

public class TransportationCosts {
	public static double MAX_HANDLING_HOURS = 12.0;
	
	int numberOfPallets;
	double transportCostsEuro;
	double taxesEuro;
	double handlingCostsEuro;
	double totalWeightOfOrder;

	public double getTotalWeightOfOrder() {
		return totalWeightOfOrder;
	}
	public void setTotalWeightOfOrder(double totalWeightOfOrder) {
		this.totalWeightOfOrder = totalWeightOfOrder;
	}
	public int getNumberOfPallets() {
		return numberOfPallets;
	}
	public void setNumberOfPallets(int numberOfPallets) {
		this.numberOfPallets = numberOfPallets;
	}
	public double getTransportCostsEuro() {
		return transportCostsEuro;
	}
	public void setTransportCostsEuro(double transportCostsEuro) {
		this.transportCostsEuro = transportCostsEuro;
	}
	public double getTaxesEuro() {
		return taxesEuro;
	}
	public void setTaxesEuro(double taxesEuro) {
		this.taxesEuro = taxesEuro;
	}
	public double getHandlingCostsEuro() {
		return handlingCostsEuro;
	}
	public void setHandlingCostsEuro(double handlingCostsEuro) {
		this.handlingCostsEuro = handlingCostsEuro;
	}
	
}
