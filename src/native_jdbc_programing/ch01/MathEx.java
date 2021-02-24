package native_jdbc_programing.ch01;

public class MathEx {
	int a;
	int b;
	
	
	public MathEx(int i, int j) {
		// TODO Auto-generated constructor stub
	}

	public MathEx() {
		// TODO Auto-generated constructor stub
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int add(){
		return a+b;
	}
	
	public int sub() {
		return a>b? a-b:b-a;
	}
	
	
}
