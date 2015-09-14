package onlineshopping.bean;

public class Cart {
	
	private int cartId;
	private int productId;
	private int amount;
	private int userId;
	
	public Cart() {
		super();
	}

	public Cart(int cartId, int productId, int amount, int userId) {
		super();
		this.cartId = cartId;
		this.productId = productId;
		this.amount = amount;
		this.userId = userId;
	}
	
	public Cart(int productId, int amount, int userId) {
		super();
		this.productId = productId;
		this.amount = amount;
		this.userId = userId;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
