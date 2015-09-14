package onlineshopping.bean;

public class Product {
	private int productId;
	private String productName;
	private float price;
	private String context;
	private String image;
	private int quantity;
	private String categoryName; // category

	public Product() {
		super();
	}

	public Product(int productId, String productName, float price, 
			String context, String image, int quantity, String categoryName) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.context = context;
		this.image = image;
		this.quantity = quantity;
		this.categoryName = categoryName;
	}
	
	public Product(String productName, float price, 
			String context, String image, int quantity, String categoryName) {
		super();
		this.productName = productName;
		this.price = price;
		this.context = context;
		this.image = image;
		this.quantity = quantity;
		this.categoryName = categoryName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/*
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productStates;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + productId;
		result = prime * result
				+ ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + quantity;
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
		Product other = (Product) obj;
		if (productStates != other.productStates)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	*/



	@Override
	public String toString() {
		return "ProductInfo [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", quantity=" + quantity
				+ ", context=" + context + ", image="
				+ image + ", categoryName =" + categoryName + "]";
	}

}
