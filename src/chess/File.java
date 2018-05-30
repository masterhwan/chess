package chess;

import java.util.ArrayList;
import java.util.List;

public class File {

	List<Rank> ranks = new ArrayList<>(8);

	public File(int i) {
		if ((7 - i) == 7) {
		} else if (7 - i == 6) {

		} else if ((7 - i) == 1) {

		} else if ((7 - i) == 0) {

		} else {

		}

	}

	public int getCount() {
		return 8;
	}

}
