package lesson3firstex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Group {
	private String groupName;
    private	ArrayList<Student> students = new ArrayList<>();
    
    public Group(String groupName, ArrayList<Student> students) {
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

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) throws GroupOverflowException{
    	if(students.size() < 10) {
    		students.add(student);
    	} else {
    		throw new GroupOverflowException("The group already has 10 students.");
    	}
    }
    
    public Student searchStudentByLastName(String lastName) throws StudentNotFoundException{
    	for (Student student : students) {
    		if(student.getLastName().equals(lastName)) {
    			return student;
    		}
		}
    	throw new StudentNotFoundException("Don't found this student.");
    }
    
    public boolean removeStudentByID(int id) {
    	if(!students.isEmpty()) {
	    	students.remove(id);
	    	return true;
    	}
    	return false;
    }
    
    public void sortStudentsByLastName() {
    	Collections.sort(students, new SortStudentsByLastName());
    }
    
	@Override
	public String toString(){
		this.sortStudentsByLastName();
		String result = "Group " + groupName + System.lineSeparator();
		for (Student student : students) {
			result += student + System.lineSeparator();
		}
		return result;	
	}

	public boolean isDuplicateStudent() {
	    for (int i = 0; i < students.size(); i++) {
	        for (int j = i + 1; j < students.size(); j++) {
	            if (students.get(i).equals(students.get(j))) {
	                return true;
	            }
	        }
	    }
	    return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}
	
		
	
}
