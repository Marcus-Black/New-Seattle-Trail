package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Printable {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String name = "Fred";
		String profession = "Barber";
		int age = 25;
		int hunger;
		int thirst;
		int energy;
		int temp;
		
		enum Gender{
			MALE,FEMALE
		}
		enum Profession{
			BARISTA,UNEMPLOYED,CRYPTO,CHEF,SOFTWARE_ENGINEER,STUDENT,MECHANIC,RETIRED,BUS_DRIVER,JUDGE,FARMER,POLICE,TEACHER
		}
		
	}

	@Test
	void test() {
		String result = String.format(name + "%10s",profession+
					"%10d",this.age + "%10s \n",this.gender, this.hunger + "\n" + this.thirst + "\n" + this.energy +"    "+ this.temp + "     " + this.perceptiveness);

	}

}
