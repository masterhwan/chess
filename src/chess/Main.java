package chess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board.print());
		String message = "start";
		Scanner scanner = new Scanner(System.in);
		while (message.equals("start")) {
			System.out.println("명령어를 입력하세요: start or end.");
			message = scanner.nextLine();
		}
		scanner.close();
	}

}
