package po;

import java.io.Serializable;

public class GoodsClassPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ID;
	String name;
	String upClassName;


	public GoodsClassPO(String id,String name, String upClassName) {
		this.ID=id;
		this.name = name;
		this.upClassName = upClassName;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpClassName() {
		return upClassName;
	}

	public void setUpClass(String upClassName) {
		this.upClassName = upClassName;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
}
