package fi.kela.drools.logistics.data;

public class Transportation {
	private String type;
	private double costPerPalletPerKmEuro;
	
	public Transportation(String type, double costPerPalletPerKmEuro) {
		this.type = type;
		this.costPerPalletPerKmEuro = costPerPalletPerKmEuro;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCostPerPalletPerKmEuro() {
		return costPerPalletPerKmEuro;
	}

	public void setCostPerPalletPerKmEuro(double costPerPalletPerKmEuro) {
		this.costPerPalletPerKmEuro = costPerPalletPerKmEuro;
	}

	@Override
	public String toString() {
		return "Transportation [type=" + type + ", costPerPalletPerKmEuro=" + costPerPalletPerKmEuro + "]";
	}
	
}
