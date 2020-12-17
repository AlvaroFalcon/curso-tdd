import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

	@Test
	public void return_list_with_100_elements() {
		List<String> fizzbuzzList = new FizzBuzzKata().execute();
		int listSize = fizzbuzzList.size();

		assertEquals(100, listSize);
	}

	@Test
	public void if_not_fizz_or_buzz_return_self() {
		List<String> fizzbuzzList = new FizzBuzzKata().execute();
		String element = fizzbuzzList.get(0);

		assertEquals("1", element);
	}

	@Test
	public void if_divisible_by_3_return_fizz() {
		List<String> fizzbuzzList = new FizzBuzzKata().execute();
		String element = fizzbuzzList.get(2);
		String containsCase = fizzbuzzList.get(12);

		assertEquals("Fizz", element);
		assertEquals("Fizz", containsCase);


	}

	@Test
	public void if_divisible_by_5_return_buzz() {
		List<String> fizzbuzzList = new FizzBuzzKata().execute();
		String element = fizzbuzzList.get(4);
		String containsCase = fizzbuzzList.get(51);

		assertEquals("Buzz", element);
		assertEquals("Buzz", containsCase);
	}

	@Test
	public void if_divisible_by_3_and_5_return_fizzbuzz() {
		List<String> fizzbuzzList = new FizzBuzzKata().execute();
		String element = fizzbuzzList.get(14);
		String containsCase = fizzbuzzList.get(52);

		assertEquals("FizzBuzz", element);
		assertEquals("FizzBuzz", containsCase);
	}

}
