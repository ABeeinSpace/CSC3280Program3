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

	}

	public static void mocsHop(Scanner in) {

	}
}
