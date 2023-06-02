import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		System.out.println("Welcome to Student Mangement App ");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println();
			System.out.println("Press 1 to ADD student");
			System.out.println("Press 2 to DELETE student");
			System.out.println("Press 3 to DISPLAY students");
			System.out.println("Press 4 to UPDATE student");
			System.out.println("Press 5 to EXIT app");
			
			int choice = Integer.parseInt(br.readLine());
			
			if(choice==1) {
				// Add student
				
				System.out.println("Enter user name :");
				String name = br.readLine();
				
				
				System.out.println("Enter user phone :");
				String phone = br.readLine();
				
				
				System.out.println("Enter user city :");
				String city = br.readLine();
				
				// *Creating student object 
				
				Student student = new Student(name, phone, city);
				
				boolean check = StudentDao.insertStudentToDB(student);
				
				if(check) System.out.println("Student added successfully");
				else System.out.println("Something went wrong!");
				
				
			}
			else if(choice==2) {
				// Delete Student
				System.out.println("Enter student id to delte :");
				int sid = Integer.parseInt(br.readLine());
				
				boolean check = StudentDao.delteStudent(sid);
				
				if(check) System.out.println("Student deleted successfully");
				else System.out.println("Something went wrong!");
			}
			else if(choice==3) {
				// Display Students
				StudentDao.showAllStudents();
				
			}
			else if(choice==4) {
				// Update name 
				System.out.println("Enter student id");
				int id = Integer.parseInt(br.readLine());
				
				System.out.println("Enter student name to update ");
				
				String name = br.readLine();
				
				boolean check = StudentDao.updateStudent(name, id);
				
				if(check) System.out.println("Student updated successfully");
				else System.out.println("Something went wrong!");
			}
			else if(choice==5) {
				// Exit
				break;
			}
			else {
				System.out.println("Wrong Input!");
				System.out.println("Choose from below options");
			}
			System.out.println("____________________________________");
		}
		System.out.println("Thanks for using this App!");
		
		

	}

}
