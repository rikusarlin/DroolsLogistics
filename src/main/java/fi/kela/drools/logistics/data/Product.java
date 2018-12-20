package fi.kela.drools.logistics.data;

public class Product {
    public static int TYPE_NOT_DEFINED = 0;
    public static int TYPE_PALLET = 1;
    public static int TYPE_BULK = 2;
    public static int TYPE_INDIVIDUAL = 3;
    
	private int productId;
	private String name;
	private double heightCm;
	private double widthCm;
	private double depthCm;
	private int type;
	private double weightKg;
	
	
	public Product(int productId, String name, double heightCm, double widthCm, double depthCm, int type, double weightKg) {
		this.productId = productId;
		this.name = name;
		this.heightCm = heightCm;
		this.widthCm = widthCm;
		this.depthCm = depthCm;
		this.type = type;
		this.weightKg = weightKg;
	}
	
	public Product() {
		this.productId = 0;
		this.name = null;
		this.heightCm = 0;
		this.widthCm = 0;
		this.depthCm = 0;
		this.type = TYPE_NOT_DEFINED;
		this.weightKg = 0;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeightCm() {
		return heightCm;
	}
	public void setHeightCm(double heightCm) {
		this.heightCm = heightCm;
	}
	public double getWidthCm() {
		return widthCm;
	}
	public void setWidthCm(double widthCm) {
		this.widthCm = widthCm;
	}
	public double getDepthCm() {
		return depthCm;
	}
	public void setDepthCm(double depthCm) {
		this.depthCm = depthCm;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getWeightKg() {
		return weightKg;
	}
	public void setWeightKg(double weightKg) {
		this.weightKg = weightKg;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", heightCm=" + heightCm + ", widthCm=" + widthCm + ", "
				+ "depthCm=" + depthCm + ", type=" + type + ", weightKg=" + weightKg + "]";
	}
	
	
}
