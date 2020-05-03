package ua.univer;

public class Program {

	public static void main(String[] args) {
		String a = new String("abc");
		String b = a;
		System.out.println(a);
		System.out.println(b);
		a = a + "d";
		System.out.println(a);
		System.out.println(b);
	}

}
