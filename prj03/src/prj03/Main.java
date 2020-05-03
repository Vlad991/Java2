package prj03;

public class Main {

	public static void main(String[] args) {
		int [] mas = {9, -43, 2, -34, 4, -2, -39, 5};
		int ibeg = 0, iend = mas.length - 1;
		for (; ibeg < iend; ibeg++) {
			if(mas[ibeg] < 0)
			for (; iend > ibeg; iend--) {
				if (mas[iend] > 0) {
					int buf = mas[ibeg];
					mas[ibeg] = mas[iend];
					mas[iend] = buf;
				break;
				}
			}
		} 
		
		for (int i : mas) {
			System.out.print(i + " ");
		}
	}

}
