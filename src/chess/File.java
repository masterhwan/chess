package chess;

import java.util.ArrayList;
import java.util.List;

public class File {

	List<Rank> files = new ArrayList<Rank>(8);

	public File(int i) {
		createFiles(i);
	}

	private void createFiles(int i) {
		int result = i - 1;
		while (result >= 0) {
			if (result == 7) {
				files.add(new Rank().createSpecialBlackPieces());
			} else if (result == 6) {
				files.add(new Rank().createBlackPawn());

			} else if (result == 0) {
				files.add(new Rank().createWhitePawn());

			} else if (result == 1) {
				files.add(new Rank().createSpecialWhitePieces());

			} else {
				files.add(new Rank().createBlank());

			}
			result--;
		}
	}

	public File() {
	}

	public int size() {
		return files.size();
	}

	public String show() {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < files.size(); i++) {
			bf.append(files.get(i).show());
		}
		return bf.toString();
	}

}
