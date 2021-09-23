package unittest;

import java.util.List;

import org.junit.jupiter.api.*;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

public class ServiceTests {
	private static StudentService ssTest;
	private static CourseService csTest;

	@BeforeAll
	public static void init() {
		 ssTest = new StudentService();
		 csTest = new CourseService();
		 System.out.println("Init Success");
	}

	@Test
	public void getAllStudentsTest() {
		List<Student> actualStu = ssTest.getAllStudents();
		Assertions.assertTrue(!actualStu.isEmpty());
		
	}
	
	@Test
	public void getAllStudentsSizeTest() {
		int expectedSize = 10;
		int actualSize = ssTest.getAllStudents().size();
		Assertions.assertEquals(expectedSize, actualSize);
	}
	
	@Test
	public void getStudentByEmailTest() {
		Student expected = new Student("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j");
		Student actual = ssTest.getStudentByEmail("aiannitti7@is.gd");
		Assertions.assertEquals(expected.getsEmail(), actual.getsEmail());
		Assertions.assertEquals(expected.getsName(), actual.getsName());
		Assertions.assertEquals(expected.getsPass(), actual.getsPass());
	}
	
	@Test
	public void validateStudentTest() {
		Student unexpected = new Student("aiannitti7@is.gd", "Alexandra Iannitti","Ahjffsk");
		Student actual = ssTest.getStudentByEmail("aiannitti7@is.gd");
		Assertions.assertNotEquals(unexpected.getsPass(), actual.getsPass());
	}
	
	@Test
	public void getAllCoursesTest() {
		List<Course> actualC = csTest.getAllCourses();
		Assertions.assertTrue(!actualC.isEmpty());
	}
	
	@Test
	public void getAllCoursesSizeTest() {
		int expectedSize = 10;
		int actualSize = csTest.getAllCourses().size();
		Assertions.assertEquals(expectedSize, actualSize);
	}
	
}



  

 