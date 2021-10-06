import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int numCommands = in.nextInt();
		int numCommandsExecuted = 0;

		do {
			switch (in.next()) {
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
		int userNum = in.nextInt();

        System.out.println(recurringMocsMath(userNum));
	}

	public static double recurringMocsMath(int userNum) {
        if (userNum == 0) {
            return 1;
        } else {
            return recurringMocsMath(userNum - 1) * recurringMocsMath(userNum - 2);
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
