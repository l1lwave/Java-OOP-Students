package lesson3firstex;

public class Student extends Human{
	private int id;
	private String groupName;
	
	public Student(String name, String lastName, Gender gender, int id, String groupName) {
		super(name, lastName, gender);
		this.id = id;
		this.groupName = groupName;
	}
	
	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String proupName) {
		this.groupName = proupName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName=" + groupName + " " + super.toString() + "]";
	}	
	
}
