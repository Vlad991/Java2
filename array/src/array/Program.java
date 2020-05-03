package array;

public class Program {

	public static void main(String[] args) throws ArrayException {
//		try {
			Array a = new Array(10);
		Array a1 = new Array(10);
		Array a2 = new Array(10);
		Array a3 = new Array(10);
		Array a4 = new Array(10);
//		} catch (ArrayException e) {
//			System.out.println("Error of creating arrays" + e);
//		}
		
		a.FillRandom(-10, 10);
//		a1.FillRandom(1, 10);
//		a2.FillRandom(1, 10);
//		a3.FillRandom(1, 10);
//		a4.FillRandom(1, 10);
//		System.out.println("Arrays: ");
//		a.print();
//		System.out.println();
//		a1.print();
//		System.out.println();
//		a2.print();
//		System.out.println();
//		a3.print();
//		System.out.println();
//		a4.print();
//		System.out.println();
//		System.out.println("Arrays after sort: ");
//		a.BubbleSort();
//		a1.ShakerSort();
//		a2.InsertSort();
//		a3.ChoiseSort();
//		a4.ShellSort();
//		a.print();
//		System.out.println();
//		a1.print();
//		System.out.println();
//		a2.print();
//		System.out.println();
//		a3.print();
//		System.out.println();
//		a4.print();
//		System.out.println();
		
		a.negativeAfterPositive();
		
		a.print();
	}

}
