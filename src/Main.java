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
					mocsShape(in);
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

        System.out.println(recurringMocsMath(userNum));
	}

	public static int recurringMocsMath(int userNum) {
        if (userNum == 0) {
            return 1;
        } else {
			int factorial = factorial(userNum);
            return factorial + recurringMocsMath(userNum - 1);
        }
	}

	public static int factorial(int userNum) {
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
	}

	public static boolean recursiveMocsGame(int remainingDollars) {
		if (remainingDollars == 42) {
			return true; // return true (which will result in an output of "solvable") because we've just made bank!
		} else if (remainingDollars < 42) {
			return false; // Return false here because we've gone under 42 dollars, which means the player's lost the
			// game.
		}

		if (remainingDollars % 3 == 0 || remainingDollars % 4 == 0) {
			int firstMultiple = remainingDollars % 10;
			int secondMultiple = remainingDollars % 10;
			int dollarsGivenBack = firstMultiple * secondMultiple;

			return recursiveMocsGame(remainingDollars - dollarsGivenBack);
		} if (remainingDollars % 5 == 0) {
			return recursiveMocsGame(remainingDollars - 42); // In this case, we give back 42 dollars because our
			// dollar amount was divisible by 5.
		} else if (remainingDollars % 2 == 0) {
			return recursiveMocsGame(remainingDollars / 2);
		}
		return recursiveMocsGame(remainingDollars);
	}

	public static void mocsHop(Scanner in) {
		int initPosition = in.nextInt();
		int size = in.nextInt();
		int[] gameBoard = new int[size];

		for (int i = 0; i < size; i++) {
			gameBoard[i] = in.nextInt();
		}

		boolean result = recursiveMocsHop(gameBoard, initPosition);

		System.out.println(result);
	}

	public static boolean recursiveMocsHop(int[] squares, int myIndex) {
		if (squares.length > squares[myIndex] || squares[myIndex] < 0 ) {
			return false;
		} else if (squares[myIndex] == 0) {
			return true;
		} else {
			return (recursiveMocsHop(squares, myIndex + squares[myIndex]) || recursiveMocsHop(squares, myIndex - squares[myIndex]));
		}
	}
}
