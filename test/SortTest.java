import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class SortTest {

	List<Fruit> fruits = new ArrayList<>();

	@Test
	public void sort() throws Exception {
		fruits.add(new Fruit("apple", 1, 1000));
		fruits.add(new Fruit("banana", 2, 500));
		fruits.add(new Fruit("orange", 3, 3000));
		fruits.add(new Fruit("pineapple", 4, 5000));
		fruits.add(new Fruit("grape", 5, 2500));

		Collections.sort(fruits, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				if (o1.getNo() > o2.getNo()) {
					return -1;
				} else if (o1.getNo() < o2.getNo()) {
					return 1;
				}
				return 0;
			}

		});

		System.out.println(fruits.get(0));
	}
}
