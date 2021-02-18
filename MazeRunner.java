import java.util.Scanner;

public class MazeRunner {

	static Scanner scanner = new Scanner(System.in);
	static Maze myMap = new Maze();

	public static void main(String[] args) {
		System.out.println(intro());
		myMap.printMap();
		userMove();

		// scanner.close();
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
		// myMap.printMap();
		// myMap.didIWin()
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
		// input = userDir(input);

		while (input.equals("R") || input.equals("L") || input.equals("U") || input.equals("D")) {

			switch (input) {
			case "R":
				System.out.println("User has chosen to move Right.");
				moveDir = myMap.canIMoveRight();
				if (moveDir) {
					myMap.moveRight();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			case "L":
				System.out.println("User has chosen to move Left.");
				moveDir = myMap.canIMoveLeft();
				if (moveDir) {
					myMap.moveLeft();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			case "U":
				System.out.println("User has chosen to move Upward.");
				moveDir = myMap.canIMoveUp();
				if (moveDir) {
					myMap.moveUp();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			case "D":
				System.out.println("User has chosen to move a Downward.");
				moveDir = myMap.canIMoveDown();
				if (moveDir) {
					myMap.moveDown();
					myMap.printMap();
				} else {
					System.out.println("Sorry... u've bumped into a wall.\nPlease change direction.");
				}
				break;

			// default:
			// break;
			}

			if (myMap.didIWin()) {
				txt = "Hallelujah";
				break;
			} else {
				// System.out.println(myMap.didIWin());
				System.out.println("which way would u go now ?");
				input = userDir(scanner.next());
			}
		}
		scanner.close();
		return txt;

	}
}
