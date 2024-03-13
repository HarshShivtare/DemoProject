package test;

public class TestClass2 extends Testtt{
	
	public static void m() {
		System.out.println("sadfas");
	}
	
	public TestClass2(int b) {
		super(b);
		System.out.println("constructor"+b);
	}
	
	public static void  main(String args[])
	{
		Testtt s= new Testtt(20);	
		System.out.println(new Testtt(20));
		m();
	}
	
}
