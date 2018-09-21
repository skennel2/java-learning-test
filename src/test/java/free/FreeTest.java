package free;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import org.junit.Test;

public class FreeTest {
	@Test
	public void test() {
		List<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(getMaxNumber(list));

		Optional<String> optionalString = Optional.of("abc");
	}

	public OptionalInt getMaxNumber(List<Integer> list) {
		return list.stream().mapToInt(Integer::intValue).max();
	}

	@Test
	public void optionalTest() {
		Optional<String> optionalString = Optional.ofNullable(null);
		String value = optionalString.orElse("aaa");

		assertEquals("aaa", value);
	}
	
	@Test
	public void test2() {
		String str1 = new String("1234");
		String str2 = new String("1234");
		
		String str3 = new String("12345");
		String str4 = new String("12345");
		
		List<String> list1 = new ArrayList<>();
		list1.add(str1);
		list1.add(str3);
		
		List<String> list2 = new ArrayList<>();
		list2.add(str3);
		list2.add(str1);
		
		if(list1 == list2) {
			System.out.println("==");
		}
		
		if(list1.equals(list2)) {
			System.out.println("equals");
		}
	}

	static class Employee {
		private int employeeCode;

		public int getEmployeeCode() {
			return employeeCode;
		}

		public void setEmployeeCode(int employeeCode) {
			this.employeeCode = employeeCode;
		}
	}
}
