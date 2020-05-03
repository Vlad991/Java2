package training;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Program {

	private static ABC abc = new ABC(1);

	public static void main(String[] args) {
//		String str1 = new String("Java");
//		String str2 = "Java";
//		System.out.println(str1.charAt(2));
//		System.out.println(str1.codePointAt(1));
//		System.out.println(str1.compareTo(str2));
//		System.out.println(str1.compareToIgnoreCase(str2));
//		System.out.println(str1.concat(str2));
//		System.out.println(str1.equals(str2));
//		System.out.println(str1.hashCode());
//		System.out.println(str1.indexOf(97));

//		foo();
		foo1();

	}

	public static void foo() {

		try {
			abc.show();
			System.out.println(1 / 0);
		} catch (NullPointerException | ArithmeticException e) {
			e.printStackTrace();
//		} catch (ArithmeticException ex) {
//			ex.printStackTrace();
		}

//		if (abc == null) {
//			System.out.println("Null pinter");
//		} else {
//			abc.show();
//		}
	}

	public static void foo1() {
		FileInputStream fileInputStream = null;
//		Throwable 
		try {
			fileInputStream = new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
