package chess;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Board board = new Board();
		board.initialize();
		ChessView chessView = new ChessView(board.getRanks());
		String message = "start";
		Scanner scanner = new Scanner(System.in);
		while (!message.equals("end")) {
			System.out.println(chessView.view());
			System.out.println("명령어를 입력하세요: start, end or move a2 a3.");
			message = scanner.nextLine();
			String[] command = message.split(" ");
			if (command[0].equals("move")) {
				board.move(command[1], command[2]);
			}
		}
		scanner.close();
	}

}
