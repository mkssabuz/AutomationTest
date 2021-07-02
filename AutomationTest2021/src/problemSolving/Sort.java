package problemSolving;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Sort {
	private static Scanner in;

	public static void main(String[] args){
	      in = new Scanner(System.in);
	      int testCases = Integer.parseInt(in.nextLine());
	      
	      List<problemSolving> studentList = new ArrayList<problemSolving>();
	      while(testCases>0){
	         int id = in.nextInt();
	         String fname = in.next();
	         double cgpa = in.nextDouble();
	         
	         problemSolving st = new problemSolving(id, fname, cgpa);
	         studentList.add(st);
	         
	         testCases--;
	      }
	       Collections.sort(studentList, new Comparator<problemSolving>() {
	              @Override
	               public int compare(problemSolving s1, problemSolving s2) {
	                    if(s2.getCgpa()>s1.getCgpa()){
	                        return 1;
	                    }else if(s2.getCgpa()<s1.getCgpa()){
	                        return -1;
	                    }
	                    return s1.getFname().compareTo(s2.getFname());
	                }
	        });
	      
	         for(problemSolving st: studentList){
	         System.out.println(st.getFname());
	      }
	   }
}
