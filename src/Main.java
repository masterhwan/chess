
import java.util.Scanner;

import Exception.InvalidMovePositionException;
import chess.ChessGame;
import chess.ChessView;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("체스 게임을 시작합니다.");
		System.out.println("게임 시작 : start");
		System.out.println("게임 종료 : end");
		System.out.println("게임 이동 : move source위치 target위치 - 예. move b2 b3");

		ChessGame chessGame = new ChessGame();
		ChessView chessView = new ChessView();
		while (true) {
			String message = scanner.nextLine();
			if (message.equals("start")) {
				chessGame.initialize();
				System.out.println(chessView.view(chessGame.getBoard()));
			} else if (message.startsWith("move")) {
				String[] values = message.split(" ");

				try {
					chessGame.move(values[1], values[2]);
				} catch (InvalidMovePositionException e) {
					System.out.println(e.getMessage());
				}
				System.out.println(chessView.view(chessGame.getBoard()));
			} else if (message.equals("end")) {
				break;
			} else {
				System.out.println(message + "는 지원하지 않는 명령어입니다.");
			}
		}
		scanner.close();
	}

}
