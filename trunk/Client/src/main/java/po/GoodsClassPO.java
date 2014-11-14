package po;

import java.io.Serializable;

public class GoodsClassPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	GoodsClassPO upClass;

	public GoodsClassPO(String name, GoodsClassPo cs) {
		this.name = name;
		this.upClass = class;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GoodsClassPO getUpClass() {
		return upClass;
	}

	public void setUpClass(GoodsClassPO upClass) {
		this.upClass = upClass;
	}
}
