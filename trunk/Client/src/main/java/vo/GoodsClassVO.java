package vo;

public class GoodsClassVO {
	String name;
	GoodsClassVO upClass;
	
	public GoodsClassVO(String name, GoodsClassVO upClass) {
		this.name = name;
		this.upClass = upClass;
	}

	public String getName() {
		return name;
	}

	public GoodsClassVO getUpClass() {
		return upClass;
	}
}
