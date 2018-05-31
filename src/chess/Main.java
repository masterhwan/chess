package chess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		// System.out.println(board.draw());
		String message = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("명령어를 입력하세요: start or end.");
		do {
			message = scanner.nextLine();
			System.out.println(board.print());
		} while (message.equals("start"));
		scanner.close();
	}

}
