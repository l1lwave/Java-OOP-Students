package lesson3firstex;

public class CSVStringConverter implements StringConverter {
    @Override
    public String toStringRepresentation(Student student) {
        return student.getName() + "," + student.getLastName() + "," + student.getGender() + "," + student.getId() + "," + student.getGroupName();
    }

    @Override
    public Student fromStringRepresentation(String str) {
    		String[] fields = str.split(",");
            
            if (fields.length != 5) {
                throw new IllegalArgumentException("Invalid CSV string format");
            }

            String name = fields[0];
            String lastName = fields[1];
            Gender gender = null;
            if(fields[2].equals("MAN")) {
            	gender = Gender.MAN;
            } else if(fields[2].equals("WOMAN")){
            	gender = Gender.WOMAN;
            } else {
            	gender = null;
            }
            int id = Integer.parseInt(fields[3]);
            String groupName = fields[4];

            return new Student(name, lastName, gender, id, groupName);	  
    }
    
    @Override
    public StringBuilder printCSV(Student[] students) {
		StringBuilder csvRepresentation = new StringBuilder();
		
		System.out.println("CSV Representation: ");
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				String csvRow = toStringRepresentation(students[i]);
				csvRepresentation.append(csvRow).append("\n");
			}
		}
		
		return csvRepresentation;
    }
    
    @Override
    public void fromCSV(StringBuilder students, Group group) {
    	String[] lines = students.toString().split("\n");
		
    	for (String line : lines) {
    		try {
				group.addStudent(fromStringRepresentation(line));
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
    	}
    }
}

