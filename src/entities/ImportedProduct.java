package entities;

public class ImportedProduct extends Product  {

	protected Double customsFee;

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}


	public Double totalprice(Double cust) {
		return price =+ cust;
	}
	

	@Override
	public String priceTag() {
		return name + " $ " + price + "(Customs fee: $ " + customsFee + ")";
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	
	

	
}
