package com.academy.cic;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "STUDENT")
@NamedQuery(name = "Student.findByNameSurname", query = "SELECT s FROM Student s WHERE s.firstName = :name AND s.lastName = :surname")
public class Student {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private int id;

	    @Column(name = "first_name", nullable = false, length = 32)
	    private String firstName;

	    @Column(name = "last_name", nullable = false, length = 32)
	    private String lastName;

	    @Column(name = "age")
	    private int age;

	    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<Registration> registrations;

		public Student() {}

		public Student(int id, String firstName, String lastName, int age, List<Registration> registrations) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.registrations = registrations;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public List<Registration> getRegistrations() {
			return registrations;
		}

		public void setRegistrations(List<Registration> registrations) {
			this.registrations = registrations;
		}

		@Override
		public String toString() {
		    return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + id;
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((registrations == null) ? 0 : registrations.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			if (age != other.age)
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (registrations == null) {
				if (other.registrations != null)
					return false;
			} else if (!registrations.equals(other.registrations))
				return false;
			return true;
		}

		
	    
	    
}
