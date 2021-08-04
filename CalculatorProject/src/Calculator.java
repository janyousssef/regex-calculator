
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	static Integer add(int firstNum, int secondNum) {
		return firstNum + secondNum;
	}

	static Integer sub(int firstNum, int secondNum) {
		return firstNum - secondNum;
	}

	static Integer mtp(int firstNum, int secondNum) {
		return firstNum * secondNum;
	}

//division function is the only function which contains some logic
	static Integer div(int numerator, int denominator) throws ArithmeticException {
		if (denominator == 0)
			throw new ArithmeticException("illegal division by 0");
		return (numerator / denominator);
	}
}

class CalculatorDemo {
	public static void main(String args[])  {
		Scanner sc = new Scanner(System.in);
		String INPUT;
		Pattern mtp = Pattern.compile("\\d+\\s*\\*\\s*\\d+");
		Pattern div = Pattern.compile("\\d+\\s*\\/\\s*\\d+");
		Pattern add = Pattern.compile("\\d+\\s*\\+\\s*\\d+");
		Pattern minus = Pattern.compile("\\d+\\s*\\-\\s*\\d+");
		try {
			System.out.println("Welcome to Calculator Demo!\n___________________________\n");
			INPUT = sc.nextLine();
			Matcher mtpMatcher = mtp.matcher(INPUT);
			while (mtpMatcher.find()) {
				int index = mtpMatcher.start();
				int index2 = mtpMatcher.end() - 1;
				int firstNum = 0;
				int secondNum = 0;
				int weight = 1;
				while (Character.isDigit(INPUT.charAt(index))) {
					firstNum = firstNum * 10 + Character.digit(INPUT.charAt(index), 10);
					index++;
				}
				while (Character.isDigit(INPUT.charAt(index2))) {
					secondNum = secondNum + Character.digit(INPUT.charAt(index2), 10) * weight;
					weight *= 10;
					index2--;
				}
				INPUT = INPUT.replace(mtpMatcher.group(), Calculator.mtp(firstNum, secondNum).toString());
				mtpMatcher = mtp.matcher(INPUT);

			}
			Matcher divMatcher = div.matcher(INPUT);
			while (divMatcher.find()) {
				int weight = 1;
				int index = divMatcher.start();
				int weight2 = 1;
				int index2 = divMatcher.end() - 1;
				int firstNum = 0;
				int secondNum = 0;
				while (Character.isDigit(INPUT.charAt(index))) {
					firstNum = firstNum * 10 + Character.digit(INPUT.charAt(index), 10);
					weight *= 10;
					index++;
				}
				while (Character.isDigit(INPUT.charAt(index2)) && index2 < INPUT.length()) {
					secondNum = secondNum + Character.digit(INPUT.charAt(index2), 10) * weight2;
					weight *= 10;
					index2--;
				}
				INPUT = INPUT.replace(divMatcher.group(), Calculator.div(firstNum, secondNum).toString());
				divMatcher = div.matcher(INPUT);

			}
			Matcher addMatcher = add.matcher(INPUT);
			while (addMatcher.find()) {
				int weight = 1;
				int index = addMatcher.start();
				int weight2 = 1;
				int index2 = addMatcher.end() - 1;
				int firstNum = 0;
				int secondNum = 0;
				while (Character.isDigit(INPUT.charAt(index))) {
					firstNum = firstNum * 10 + Character.digit(INPUT.charAt(index), 10);
					weight *= 10;
					index++;
				}
				while (Character.isDigit(INPUT.charAt(index2)) && index2 < INPUT.length()) {
					secondNum = secondNum + Character.digit(INPUT.charAt(index2), 10) * weight2;
					weight *= 10;
					index2--;
				}
				INPUT = INPUT.replace(addMatcher.group(), Calculator.add(firstNum, secondNum).toString());
				addMatcher = add.matcher(INPUT);

			}
			Matcher minusMatcher = minus.matcher(INPUT);
			while (minusMatcher.find()) {
				int weight = 1;
				int index = minusMatcher.start();
				int weight2 = 1;
				int index2 = minusMatcher.end() - 1;
				int firstNum = 0;
				int secondNum = 0;
				while (Character.isDigit(INPUT.charAt(index))) {
					firstNum = firstNum * 10 + Character.digit(INPUT.charAt(index), 10);
					weight *= 10;
					index++;
				}
				while (Character.isDigit(INPUT.charAt(index2)) && index2 < INPUT.length()) {
					secondNum = secondNum + Character.digit(INPUT.charAt(index2), 10) * weight2;
					weight *= 10;
					index2--;
				}
				INPUT = INPUT.replace(minusMatcher.group(), Calculator.sub(firstNum, secondNum).toString());
				minusMatcher = minus.matcher(INPUT);

			}
			System.out.println(INPUT);

		} catch (InputMismatchException e) {
			System.out.println("Invalid Character entered\n" + e);
		} catch (ArithmeticException e) {
			System.out.println(e);
		} finally {
			System.out.println("Thank you for using this calculator. \n");
			sc.close();
		}
	}

}
