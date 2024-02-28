import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Please enter your name: ");
		Scanner uName = new Scanner(System.in);
		
		String userName = uName.nextLine();
		System.out.println("Hello " + userName);

	}

}
