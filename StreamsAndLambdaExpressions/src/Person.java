public class Person
	{
		private String firstName, lastName;
		
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

		public int getAge() {
			return Age;
		}

		public void setAge(int age) {
			Age = age;
		}

		private int Age;
		
		//blank constructor
		public Person() {}
		
		//constructor with parameters
		public Person(String fName, String lName, int a)
		{
			firstName = fName;
			lastName = lName;
			Age = a;
		}
		
		@Override
		public String toString(){
			return "Person{"+"firstname = "+firstName+", lastname = "+lastName+", age = "+Age+"}";			
		}		
	}