package lesson3firstex;

import java.util.Scanner;

public class InputStudents{
	Scanner sc = new Scanner(System.in);	
	
	public Student InputStudent() {
		System.out.println("Input student's name: ");
		String name = sc.nextLine();
				
		System.out.println("Input student's last name: ");
		String lastName = sc.nextLine();
		
		System.out.println("Input student's gender: ");
		System.out.println("1) Man");
		System.out.println("2) Woman");
		Gender gender = null;
		int i = sc.nextInt();
		if(i == 1) {
			gender = Gender.MAN;
		} else if(i == 2) {
			gender = Gender.WOMAN;
		} else {
			System.out.println("Wrong input");
		}

		System.out.println("Input student's id: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Input student's group: ");
		String groupName = sc.nextLine();
		
		return new Student(name, lastName, gender, id, groupName);
	}
}
