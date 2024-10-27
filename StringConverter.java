package lesson3firstex;

public interface StringConverter {
	public String toStringRepresentation (Student student);
	public Student fromStringRepresentation (String str);
	
	public StringBuilder printCSV(Student[] students);	
	public void fromCSV(StringBuilder students, Group group);
}
