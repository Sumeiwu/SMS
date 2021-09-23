package jpa.entitymodels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "Student")
public class Student {
	public Student() {
		
	}
	
	public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourses = sCourses;
	}

	public Student(String sEmail, String sName, String sPass) {
		super();
		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "email")
    private String sEmail;
	
	@Column(name = "name")
    private String sName;
	
	@Column(name = "password")
    private String sPass;
	
	@ManyToMany
	@JoinTable(
			name = "Student_Course",
			joinColumns = @JoinColumn(name = "studentEmail"),
			inverseJoinColumns = @JoinColumn(name = "courseId")
			)
	private List<Course> sCourses = new ArrayList<Course>();

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourses() {
		return sCourses;
	}

	public void setsCourses(List<Course> sCourses) {
		this.sCourses = sCourses;
	}


	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
