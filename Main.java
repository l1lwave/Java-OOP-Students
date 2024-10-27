package lesson3firstex;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Group group = new Group();
		group.setGroupName("IP-22-4");
		try {
			group.addStudent(new Student("Alex", "Petrov", Gender.MAN, 1, group.getGroupName()));
			group.addStudent(new Student("Max", "Ivanov", Gender.MAN, 2, group.getGroupName()));
			group.addStudent(new Student("Anna", "Smirno", Gender.WOMAN, 3, group.getGroupName()));
			group.addStudent(new Student("Olya", "Krot", Gender.WOMAN, 4, group.getGroupName()));
			group.addStudent(new Student("katya", "Kashalot", Gender.WOMAN, 5, group.getGroupName()));
			group.addStudent(new Student("Alex", "Novikov", Gender.MAN, 6, group.getGroupName()));
			group.addStudent(new Student("Max", "Azarov", Gender.MAN, 7, group.getGroupName()));
			group.addStudent(new Student("Anna", "Puchkova", Gender.WOMAN, 8, group.getGroupName()));
			group.addStudent(new Student("Olya", "Masya", Gender.WOMAN, 9, group.getGroupName()));
			group.addStudent(new Student("katya", "Kilipa", Gender.WOMAN, 10, group.getGroupName()));
		} catch(GroupOverflowException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		System.out.println();
		
		System.out.println("____________Save to CSV_________");
		GroupFileStorage fileStorage = new GroupFileStorage();
		fileStorage.saveGroupToCSV(group);
		
		System.out.println();
		
		System.out.println("____________Load from CSV_________");
		System.out.println("Input file way: ");
		String fileWay = sc.nextLine();
		File file = new File(fileWay);
		if (!file.exists()) {
			System.out.println("File don`t exist");
		} else {
			try {
			    Group group2 = fileStorage.loadGroupFromCSV(file);
			    group2.setGroupName(file.getName().replace(".csv", ""));
			    System.out.println(group2);
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		
		System.out.println("____________Find by Droup Name_________");
		System.out.println("Input folder way: ");
    	String folderWay = sc.nextLine();
    	File folderGroup = new File(folderWay);
    	System.out.println("Input group name: ");
    	String groupName = sc.nextLine();
    	try {
    		File result = fileStorage.findFileByGroupName(groupName, folderGroup);
	    	if(result != null) {
	    		System.out.println("File exist:");
	    		System.out.println(result.toString());
	    	} else {
	    		System.out.println("No file");
	    	}
    	} catch(NullPointerException e){
			System.out.println(e.getMessage());

		}
    	
	}

}
