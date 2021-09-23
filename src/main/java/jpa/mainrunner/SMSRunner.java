package jpa.mainrunner;

import java.util.List;
import java.util.Scanner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class SMSRunner {

	public static void main(String[] args) {
		System.out.print("Are you a(n)\n" + "1. Student\n" + "2. Quit\n");
		System.out.print("Enter Your Choice: ");
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			StudentRegister();
			break;
		case 2:
			System.out.println("\n--Quit Program. Bye :)--");
			break;
		default:
			System.out.println("\n--Invalid Input--");
		}
		scan.close();
	}

	public static void StudentRegister() {
		// TODO Auto-generated method stub
		StudentService ss = new StudentService();
		CourseService cs = new CourseService();

		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter Your Email: ");
		String email = scan.nextLine();
		System.out.print("Enter Your Password: ");
		String password = scan.nextLine();

		Student curStu = ss.getStudentByEmail(email);
		if (curStu != null && curStu.getsPass().equals(password)) {
			System.out.println("\n<"+ curStu.getsName() + ">" + "\nWelcome to the Student Register Portal.");

			System.out.println("\nMy Classes:");
			printCourses(curStu.getsCourses());
			boolean stuMenu = true;
			while (stuMenu) {
				System.out.print("\n1. Register to Class\n"  + "2. Logout\n");
				System.out.print("Enter Your Choice: ");
				int choice = scan.nextInt();
				switch (choice) {
				case 1:
					System.out.println("\nAll Courses:");
					printCourses(cs.getAllCourses());
					System.out.println("\nWhich Course?");
					int course_id = scan.nextInt();
					if (course_id >= 1 && course_id <= 10) {
						ss.registerStudentToCourse(email, course_id);
						System.out.println("\nMy Classes:");
						printCourses(curStu.getsCourses());
					} else
						System.out.println("\n--Invalid Course ID--");
					break;
					
				case 2:
					System.out.println("\n--You have been signed out. Bye :)--");
					stuMenu = false;
					break;

				default:
					System.out.println("\n--Invalid Input--");
				}
			}
		} else
			System.out.println("\n--Invalid Student Account. Please double check your email and password.--");
		scan.close();

	}


	public static void printCourses(List<Course> courses) {
		System.out.printf("%-5s %-30s %-30s\n", "ID", "COURSE NAME", "INSTRUCTOR NAME");
		for (Course c : courses) {
			System.out.printf("%-5d %-30s %-30s\n", c.getcId(), c.getcName(), c.getcInstructorName());
		}

	}

}
