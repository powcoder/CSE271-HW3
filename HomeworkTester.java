https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
https://powcoder.com
代写代考加微信 powcoder
Assignment Project Exam Help
Add WeChat powcoder
package E;

import java.awt.Point;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;

public class HomeworkTester {

	public static void main(String[] args) {


		Student s1 = new Student("Tom", "Male", 66.99);
		Student s2 = new Student(s1);
		Student s3 = s2.clone();
		
		System.out.println(s1.equals(s2));
		
		System.exit(0);
		
		ArrayList<Student> students = new ArrayList<>();
		String[] parts = null;
		int ma, mb, mc, md, mf, wa, wb, wc, wd, wf;
		int men = 0, women = 0;
		double menGrades = 0, womenGrades = 0;
		RandomAccessFile raf = null;
		
		ma = mb = mc = md = mf = wa = wb = wc = wd = wf = 0;
		
		try {
			raf = new RandomAccessFile("HW-02_Student-Average-Gender.txt","r");
			raf.readLine();
			while(raf.getFilePointer() < raf.length()) 
				students.add(new Student(raf));
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(Arrays.toString(parts));
		} finally {
			try { raf.close(); } catch(Exception e) {}
		}
		
		//===== Process file and print
		for(Student s : students) {
			if(s.getGender().equals("Male")) {
				men++;
				menGrades += s.getOverallAverage();
				if(s.getOverallAverage() > 89) ma++;
				else if(s.getOverallAverage() > 79) mb++;
				else if(s.getOverallAverage() > 69) mc++;
				else if(s.getOverallAverage() > 59) md++;
				else mf++;
			} else {
				women++;
				womenGrades += s.getOverallAverage();
				if(s.getOverallAverage() > 89) wa++;
				else if(s.getOverallAverage() > 79) wb++;
				else if(s.getOverallAverage() > 69) wc++;
				else if(s.getOverallAverage() > 59) wd++;
				else wf++;
			}
		}
	
		/* 
		    ------ 	    ---      -----	
			A            22        405
			B             3         90
			C           100        145
			D           300         20
			F            64          5
			
			Average:   67.2       85.6
		*/
		System.out.println("Grade       Men	     Women");
		System.out.println("------ 	    ---      -----");
		System.out.printf("A %13d %10d\n", ma, wa);
		System.out.printf("B %13d %10d\n", mb, wb);
		System.out.printf("C %13d %10d\n", mc, wc);
		System.out.printf("D %13d %10d\n", md, wd);
		System.out.printf("F %13d %10d\n\n", mf, wf);
		System.out.printf("Average: %6.1f %10.1f", menGrades/men, womenGrades/women);
	}	
}
