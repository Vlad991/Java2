package student;

public class Program {

	public static void main(String[] args) {
		StudentList studentlist = new StudentList();
		studentlist.Add(new Student(01, "Jyll", "Jake", "Dads", 1999, "main1 str.", 0503332211, "ITF", 1, 2));
		studentlist.Add(new Student(02, "Byll", "Mike", "Moms", 1993, "main2 str.", 0503332211, "IEE", 2, 3));
		studentlist.Add(new Student(03, "Jyll", "Sam", "Moms", 1995, "main3 str.", 0503332211, "FEA", 4, 1));
		studentlist.Add(new Student(04, "Dyll", "John", "Moms", 1996, "main4 str.", 0503332211, "IEE", 2, 5));
		studentlist.Add(new Student(05, "Jyll", "Will", "Dads", 1997, "main5 str.", 0503332211, "FTI", 2, 2));
		studentlist.Add(new Student(06, "Myll", "Kate", "Dads", 1995, "main6 str.", 0503332211, "TEF", 5, 6));
		
		StudentList studentsTEF = studentlist.GetStudentsByFaculty("TEF");
		
		StudentList studentsIEE2 = studentlist.GetStudentsByFacultyAndYear("IEE", 2);
		
		StudentList studentsOlder1995 = studentlist.GetStudentsByDateOfBirth(1995);
		
		StudentList studentsGroup1 = studentlist.GetStudentsByGroup(1);
		
		studentsTEF.print();
		studentsIEE2.print();
		studentsOlder1995.print();
		studentsGroup1.print();
		
	}

}
