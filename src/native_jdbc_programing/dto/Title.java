package native_jdbc_programing.dto;

public class Title {
	private int tNo;
	private String tName;

	public Title(int tNo) {
		super();
		this.tNo = tNo;
	}

	public Title(int tNo, String tName) {
		super();
		this.tNo = tNo;
		this.tName = tName;
	}

	public int gettNo() {
		return tNo;
	}

	public void settNo(int tNo) {
		this.tNo = tNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	@Override
	public String toString() {
		return String.format("Title [tNo=%s, tName=%s]", tNo, tName);
	}

}
