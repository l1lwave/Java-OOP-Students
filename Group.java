package lesson3firstex;

import java.util.Arrays;
import java.util.Comparator;


public class Group {
	private String groupName;
    private	Student[] students = new Student[10];
    
    public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}
    
    public Group() {
		super();
	}
    
    public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException{
    	for (int i = 0; i < students.length; i++) {
			if(students[i] == null) {
				students[i] = student;
				System.out.println("Student " + student.getLastName() + " is added.");
				return;
			}
		}
    	throw new GroupOverflowException("The group already has 10 students.");
    }
    
    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
    	for(int i = 0; i < students.length; i++) {
    		if(students[i] != null) {
    			if(students[i].getLastName().equals(lastName)) {
    				return students[i];
    			}
    		}
    	}
    	throw new StudentNotFoundException("Don't found this student.");
    }
    
    public boolean removeStudentByID(int id) {
    	for (int i = 0; i < students.length; i++) { 
    		if(students[i] != null) {
    			if (students[i].getId() == id) {
    				students[i] = null; 
                    return true;
    			}
    		}
    	}
        return false;
    }
    
    public void sortStudentsByLastName() {
    	Arrays.sort(students, Comparator.nullsFirst(new sortStudentsByLastName()));
    }
    
	@Override
	public String toString(){
		this.sortStudentsByLastName();
		String result = "Group " + groupName + System.lineSeparator();
		for (int i = 0; i < students.length; i++) {
			if(students[i] != null) {
				result += students[i] + System.lineSeparator();
			}
		}
		return result;	
	}
}
