package businesslogic.memberbl;

public class MemBaseInfo {
	 public MemberType mType; 
	 public MemberLevel mLevel;
	 public String memberID,name;
	 public double points;
	public MemBaseInfo(MemberType mType, MemberLevel mLevel, String memberID,
			String name, double points) {
		
		this.mType = mType;
		this.mLevel = mLevel;
		this.memberID = memberID;
		this.name = name;
		this.points = points;
	}
	 
	
}
