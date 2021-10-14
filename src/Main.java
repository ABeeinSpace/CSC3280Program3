import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numCommands = in.nextInt();
		int numCommandsExecuted = 0;

		do {
			String userInput = in.next();
			switch (userInput) {
				case "MocsMath":
					mocsMath(in);
					numCommandsExecuted++;
					break;
				case "MocsShape":
					System.out.println("MocsShape:");
					mocsShape(in);
					System.out.println();
					numCommandsExecuted++;
					break;
				case "MocsGame":
					mocsGame(in);
					numCommandsExecuted++;
					break;
				case "MocsHop":
					mocsHop(in);
					numCommandsExecuted++;
					break;
			}
		} while (numCommandsExecuted < numCommands);
	}

	public static void mocsMath(Scanner in) {
		int userNum = in.nextInt();

		System.out.printf("MocsMath:  %d\n\n", recurringMocsMath(userNum));
	}

	public static long recurringMocsMath(int userNum) {
		if (userNum == 0) {
			return 1;
		} else {
			long factorial = factorial(userNum);
			return factorial + recurringMocsMath(userNum - 1);
		}
	}

	public static long factorial(long userNum) {
		if (userNum == 0) {
			return 1;
		} else {
			return userNum * factorial(userNum - 1);
		}
	}

	public static void mocsShape(Scanner in) {
		int lowerBound = in.nextInt();
		int upperBound = in.nextInt();

		mocsShapeForward(lowerBound, upperBound);
		mocsShapeBackward(lowerBound, upperBound);
	}

	private static void mocsShapeForward(int lowerBound, int upperBound) {
		if (lowerBound > upperBound) {
			return;
		}

		for (int i = 1; i <= lowerBound; i++) {
			System.out.print("* ");
		}
		System.out.println();
		mocsShapeForward(lowerBound + 1, upperBound);
	}

	private static void mocsShapeBackward(int lowerBound, int upperBound) {
		if (upperBound < lowerBound) {
			return;
		}

		for (int i = upperBound; i >= 1; i--) {
			System.out.print("* ");
		}
		System.out.println();
		mocsShapeBackward(lowerBound, upperBound - 1);
	}

	public static void mocsGame(Scanner in) {
		int startingDollars = in.nextInt();

		boolean isLandoNorrisTheBestInF1 = recursiveMocsGame(startingDollars); // Oops, sorry fingers slipped on the
		// keyboard on that variable name. Jeez, no idea how I managed that :P

		System.out.println(isLandoNorrisTheBestInF1);
	}

	public static boolean recursiveMocsGame(int remainingDollars) {
		if (remainingDollars < 42) {
			return false; // Return false here because we've gone under 42 dollars, which means the player's lost the
			// game.
		} if (remainingDollars == 42) {
			return true; // return true (which will result in an output of "solvable") because we've just made bank!
		}
		if (remainingDollars % 5 == 0 && recursiveMocsGame(remainingDollars - 42)) {
			return true;
		} if (remainingDollars % 2 == 0 && recursiveMocsGame(remainingDollars / 2)) {
			return true;
		} if (remainingDollars % 4 == 0 || remainingDollars % 3 == 0) {
			int firstMultiple = remainingDollars % 10;
			int secondMultiple = (remainingDollars % 100) / 10;
			int dollarsGivenBack = firstMultiple * secondMultiple;

			return recursiveMocsGame(remainingDollars - dollarsGivenBack);
		}
		return false; // fuck you java. Piece of shit.
	}

	public static void mocsHop(Scanner in) {
		int initPosition = in.nextInt();
		int size = in.nextInt();
		int[] gameBoard = new int[size];

		for (int i = 0; i < size; i++) {
			gameBoard[i] = in.nextInt();
		}

		boolean result = recursiveMocsHop(gameBoard, initPosition, 0);

		System.out.println(result);
	}

	public static boolean recursiveMocsHop(int[] squares, int myIndex, int moveCounter) {
		if ( moveCounter > squares.length || myIndex < 0 || myIndex >= squares.length) {
			return false;
		} if (squares[myIndex] == 0) {
			return true;
		} else {
			return (recursiveMocsHop(squares, myIndex - squares[myIndex], moveCounter + 1) || recursiveMocsHop(squares,
					myIndex + squares[myIndex], moveCounter + 1));
		}
	}
}
