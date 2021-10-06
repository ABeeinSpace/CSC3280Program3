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
		} while (numCommandsExecuted <= numCommands);
	}

	public static void mocsMath(Scanner in) {
		System.out.println("mocsmaf");
		int userNum = in.nextInt();

        System.out.println(recurringMocsMath(userNum));
	}

	public static double recurringMocsMath(int userNum) {
        if (userNum == 0) {
            return 1;
        } else {
            return recurringMocsMath(factorial(userNum - 1)) + userNum;
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

	}

	public static void mocsGame(Scanner in) {

	}

	public static void mocsHop(Scanner in) {

	}
}
