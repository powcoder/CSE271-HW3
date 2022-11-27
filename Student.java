https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package E;

import java.io.RandomAccessFile;
import java.security.InvalidParameterException;

public class Student {
	
	//==================================== Properties
	private String name, gender;
	private double overallAverage;
	
	//==================================== Constructors
	//...... Empty
	public Student() {
		this("", "");
	}
	
	//...... Partial
	public Student(String name, String gender) {
		this(name, gender, 0.0);
	}
	
	//...... Workhorse
	public Student(String name, String gender, double overallAverage) {
		setName(name);
		setGender(gender);
		setOverallAverage(overallAverage);
	}
	
	//...... Copy
	public Student(Student student) {
		this(student.name, student.gender, student.overallAverage);
	}
	
	//...... Special Cases
	public Student(String[] parts) {
		this(parts[0], parts[1], Double.parseDouble(parts[2]));
	}
	
	public Student(RandomAccessFile raf) throws Exception {
		this(raf.readLine().split("\t"));
	}
	
	//==================================== Methods
	@Override
	public Student clone() {
		return new Student(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Student)) return false;
		Student s = (Student)obj;
		return	overallAverage == s.overallAverage &&
				name.equals(s.name) &&
				gender.equals(s.gender);
	}
	
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", overallAverage=" + overallAverage + "]";
	}

	//==================================== Getters / Setters
	public String getName() 				{	return name;			}
	public void setName(String name) 		{	this.name = name;		}
	public String getGender() 				{	return gender;			}
	public void setGender(String gender)	{	this.gender = gender;	}
	public double getOverallAverage() 		{	return overallAverage;	}
	public void setOverallAverage(double overallAverage) {
		if(overallAverage < 0 || overallAverage > 100)
			throw new InvalidParameterException("overallAverage out of range");
		this.overallAverage = overallAverage;
	}
	
	
}
