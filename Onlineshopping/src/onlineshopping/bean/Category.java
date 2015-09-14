package onlineshopping.bean;

public class Category {
	
	private int categoryId;
	private int pId;
	private String categoryName;
	
	public Category() {
		super();
	}

	public Category(int categoryId, int pId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.pId = pId;
		this.categoryName = categoryName;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
