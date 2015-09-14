package onlineshopping.bean;

public class User {

	private int userId;
	private String name;
	private String password;
	private String email;
	private String address;
	private int cartId;

	public User() {
		super();
	}

	public User(int userId, String name, String password, String email,
			String address, int cartId) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
		this.cartId = cartId;
		
	}
	
	public User(int userId, String name, String password, String email,
			String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public User(String name, String password, String email,
			String address) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;

	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	
}
