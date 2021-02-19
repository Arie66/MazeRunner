import java.util.Scanner;

public class MazeRunner {

	static Scanner scanner = new Scanner(System.in);
	static Maze myMap = new Maze();

	public static void main(String[] args) {
		System.out.println(intro());
		myMap.printMap();
		userMove();
	}

	public static String intro() {
		String txt;
		txt = "Welcome to Maze Runner!\nHere is your current position:";
		return txt;
	}

	public static void userMove() {
		boolean moveDir = false;
		String input;
		System.out.println("Where would you like to move? (R, L, U, D)");
		// input = userDir(scanner.next());
		input = userNextMove(userDir(scanner.next()));
		System.out.println(input);
	}

	public static String userDir(String move) {
		String input = move;
		while (!input.equals("R") && !input.equals("L") && !input.equals("U") && !input.equals("D")) {
			System.out.println("Please select a valid move - (R, L, U, D)");
			input = scanner.next();
		}
		return input;
	}

	public static String userNextMove(String move) {
		boolean moveDir = false;
		String input = move;
		String txt = "";
		int numOfMoves = 0;

		while (input.equals("R") || input.equals("L") || input.equals("U") || input.equals("D")) {

			numOfMoves++;
			switch (input) {
			case "R":
				System.out.println("User has chosen to move Right.");
				if (myMap.isThereAPit(input)) {
					navigatePit(input);

					if (scanner.next().startsWith("Y")) {
						myMap.jumpOverPit(input);
						myMap.printMap();
					} else {
						System.out.println("Please change direction.");
					}
				}
				// moveDir = myMap.canIMoveRight();
				else if (myMap.canIMoveRight()) {
					myMap.moveRight();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			case "L":
				System.out.println("User has chosen to move Left.");
				if (myMap.isThereAPit(input)) {
					navigatePit(input);
					if (scanner.next().startsWith("Y")) {
						myMap.jumpOverPit(input);
						myMap.printMap();
					} else {
						System.out.println("Please change direction.");
					}
				} else if (myMap.canIMoveLeft()) {
					myMap.moveLeft();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			case "U":
				System.out.println("User has chosen to move Upward.");
				if (myMap.isThereAPit(input)) {
					navigatePit(input);
					if (scanner.next().startsWith("Y")) {
						myMap.jumpOverPit(input);
						myMap.printMap();
					} else {
						System.out.println("Please change direction.");
					}
				} else if (myMap.canIMoveUp()) {
					myMap.moveUp();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			case "D":
				System.out.println("User has chosen to move a Downward.");
				if (myMap.isThereAPit(input)) {
					navigatePit(input);
					if (scanner.next().startsWith("Y")) {
						myMap.jumpOverPit(input);
						myMap.printMap();
					} else {
						System.out.println("Please change direction.");
					}
				} else if (myMap.canIMoveDown()) {
					myMap.moveDown();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;
			}

			if (myMap.didIWin()) {
				txt = "Hallelujah. You made it out alive!\nyou've won and u did it in " + numOfMoves + " moves.";
				break;
			} else if (numOfMoves < 100) {
				System.out.println(movesMessage(numOfMoves));
				System.out.println("which way would u go now ?");
				input = userDir(scanner.next());
			} else {
				txt = movesMessage(numOfMoves) + " \nSorry, but you didn't escape in time - you lose!";
				break;
			}
		}
		scanner.close();
		return txt;
	}

	public static String movesMessage(int numOfMoves) {
		String txt = "";
		if (numOfMoves == 50) {
			txt = "Warning: You have made 50 moves, you have 50 remaining before the maze exit closes";
		} else if (numOfMoves == 70) {
			txt = "Alert! You have made 75 moves, you only have 25 moves left to escape.";
		} else if (numOfMoves == 90) {
			txt = "DANGER! You have made 90 moves, you only have 10 moves left to escape!!";
		} else if (numOfMoves == 100) {
			txt = "Oh no! You took too long to escape, and now the maze exit is closed FOREVER.";
		}
		return txt;
	}

	private static void navigatePit(String input) {

		if (myMap.isThereAPit(input)) {
			System.out.println("Watch out! There's a pit ahead, jump it?");
		} else {
			System.out.println("Please change direction.");
		}
	}

}
