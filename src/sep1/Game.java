package sep1;

public class Game {
	public StringBuffer board;
	public final int NOMOVE = -1;

	public Game(String s) {
		board = new StringBuffer(s);
	}

	public Game(StringBuffer s, int position, char player) {
		board = new StringBuffer();
		board.append(s);
		board.setCharAt(position, player);
	}

//	public int move(char player) {
//		int defaultMove = NOMOVE;
//		for (int move = 0; move < 9; move++) {
//			if (isFieldEmpty(move)) {
//				defaultMove = move;
//				Game game = play(move, player);
//				if (game.winner() == player) {
//					return move;
//				}
//			}
//		}
//
//		return defaultMove;
//	}

	public int move(char player) {
		int defaultMove = NOMOVE;
		for (int move = 0; move < 9; move++) {
			if (isFieldEmpty(move)) {
				defaultMove = move;
				Game game = play(move, player);
				if (game.winner() == player) {
					defaultMove = move;
				}
				return defaultMove;
			}
		}

		return defaultMove;
	}

	public Game play(int move, char player) {
		return new Game(this.board, move, player);
	}

	public char winner() {
		char result = '-';
		for (int zeile = 0; zeile <= 6; zeile += 3) {
			if (board.charAt(zeile) != '-' && board.charAt(zeile) == board.charAt(zeile + 1)
					&& board.charAt(zeile + 1) == board.charAt(zeile + 2)) {
				result = board.charAt(zeile);
			}
		}
		return result;
	}

	public boolean isFieldEmpty(int pos) {
		return (board.charAt(pos) == '-');
	}
}
