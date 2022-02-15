/*
 Aidan Border
 10/14/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
 https://www.youtube.com/watch?v=dQw4w9WgXcQ
*/

import java.util.Scanner;

public class Main {

	/* main()
	 * Parameters: String[] args
	 * Returns: Void
	 * Description: Method invoked by the Java runtime when we run the project or run Main.java directly. */
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

	/* mocsMath()
	 * Parameters: Scanner in
	 * Returns: Void
	 * Description: Wrapper method for recurringMocsMath. This method's job is to start the recursion going and to
	 * print the result.*/
	public static void mocsMath(Scanner in) {
		int userNum = in.nextInt();

		System.out.printf("MocsMath:  %d\n\n", recurringMocsMath(userNum));
	}

	/* recurringMocsMath()
	 * Parameters: int userNum
	 * Returns: long
	 * Description: Method to compute the sums of the factorial of a given number.
	 * Special: Method utilizes recursion.*/
	public static long recurringMocsMath(int userNum) {
		if (userNum == 0) {
			return 1;
		} else {
			long factorial = factorial(userNum);
			return factorial + recurringMocsMath(userNum - 1);
		}
	}

	/* factorial()
	 * Parameters: long userNum
	 * Returns: long
	 * Description: Supporting method for recurringMocsMath.
	 * Special: Method utilizes recursion.*/
	public static long factorial(long userNum) {
		if (userNum == 0) {
			return 1;
		} else {
			return userNum * factorial(userNum - 1);
		}
	}

	/* mocsShape()
	 * Parameters: Scanner in
	 * Returns: void
	 * Description: Wrapper method for mocsShapeForward and mocsShapeBackward. */
	public static void mocsShape(Scanner in) {
		int lowerBound = in.nextInt();
		int upperBound = in.nextInt();

		mocsShapeForward(lowerBound, upperBound);
		mocsShapeBackward(lowerBound, upperBound);
	}

	/* mocsShapeForward()
	 * Parameters: int lowerBound, int upperBound
	 * Returns: void
	 * Description: This method prints the first half of the mocsShape command
	 * Special: Method utilized recursion */
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

	/* mocsShapeBackward()
	 * Parameters: int lowerBound, int upperBound
	 * Returns: void
	 * Description: This method prints the second half of the mocsShape command
	 * Special: Method utilized recursion */
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

	/* mocsGame()
	 * Parameters: Scanner in
	 * Returns: Void
	 * Description: Wrapper method for the recursiveMocsGame method.*/
	public static void mocsGame(Scanner in) {
		int startingDollars = in.nextInt();

		boolean isLandoNorrisTheBestInF1 = recursiveMocsGame(startingDollars); // Oops, sorry fingers slipped on the
		// keyboard on that variable name. Jeez, no idea how I managed that :P

		if (isLandoNorrisTheBestInF1) {
			System.out.println("MocsGame:  Solvable\n");
		} else {
			System.out.println("MocsGame:  Not Solvable\n");
		}
	}

	/* recursiveMocsGame()
	 * Parameters: int remainingDollars
	 * Returns: boolean
	 * Description: Method to run the mocsGame command.
	 * Special: Method utilizes recursion.*/
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
			if (dollarsGivenBack != 0) { // Mitigation to prevent going into an unexpected state when the product is
				// 0 where we give no dollars back and get stuck in an infinite loop until the stack overflows.
				return recursiveMocsGame(remainingDollars - dollarsGivenBack);
			}
		}
		return false;
	}

	/* mocsHop()
	 * Parameters: Scanner in
	 * Returns: void
	 * Description: Hopscotch with Mocsie!
	 * Special: N/A*/
	public static void mocsHop(Scanner in) {
		int initPosition = in.nextInt();
		int size = in.nextInt();
		int[] gameBoard = new int[size];

		for (int i = 0; i < size; i++) {
			gameBoard[i] = in.nextInt();
		}

		boolean result = recursiveMocsHop(gameBoard, initPosition, 0);

		if (result) {
			System.out.println("MocsHop:  Solvable");
		} else {
			System.out.println("MocsHop:  Not Solvable");
		}
		System.out.println();
	}

	/* recursiveMocHop()
	 * Parameters: int[] squares, int myIndex, int moveCounter
	 * Returns: boolean
	 * Description: Actually computing mocsHop
	 * Special: Method utilizes recursion.*/
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
