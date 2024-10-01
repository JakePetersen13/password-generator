import java.util.*;

public class PasswordGenerator {

	public static int getNextInput(Scanner scanner) {
		int input = 0;
		boolean inputAccepted = false;
		while (!inputAccepted) {
			try {
				input = scanner.nextInt();
				inputAccepted = true;
			} catch (InputMismatchException e) {
				System.out.println("> Invalid input. Please enter a number.");
				scanner.next();
			}
		}
		return input;
	}

	public static void main(String[] args) {

		final int MAX_PASSWORDS = 10;
		final int MAX_LENGTH = 50;

		Scanner scnr = new Scanner(System.in);
		boolean inputAccepted = false;
		int numberOfPasswords;
		int lengthOfPassowrds;

		System.out.println("----------PASSWORD GENERATOR----------");
		System.out.println("> Enter number of passwords to generate. (MAX: 10)");
		numberOfPasswords = getNextInput(scnr);
		if (numberOfPasswords > MAX_PASSWORDS) {
			System.out.println("> Input over max amount. Autocorrecting input to 10.");
			numberOfPasswords = MAX_PASSWORDS;
		}

		System.out.println("> Enter length of password(s). (MAX: 50)");
		lengthOfPassowrds = getNextInput(scnr);
		if (lengthOfPassowrds > MAX_LENGTH) {
			System.out.println("> Input over max amount. Autocorrecting input to 50.");
			lengthOfPassowrds = MAX_LENGTH;
		}

		System.out.println(
				"> INPUTS: # OF PASSWORDS = " + numberOfPasswords + " | LENGTH OF PASSWORDS = " + lengthOfPassowrds);

		generatePasswords(numberOfPasswords, lengthOfPassowrds);

		System.out.println("\n > All passwords generated.");

	}

	public static void generatePasswords(int number, int length) {
		System.out.println("> GENERATING PASSWORDS...\n");
		Random rand = new Random();
		int max = 126;
		int min = 33;

		for (int i = 1; i <= number; i++) {
			String password = "";
			for (int j = 0; j < length; j++) {
				int randomNum = rand.nextInt(max - min + 1) + min;
				char passChar = (char) randomNum;
				password += passChar;
			}

			System.out.println("> Password " + i + ": " + password);
		}
	}

}
