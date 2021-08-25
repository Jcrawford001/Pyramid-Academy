import java.util.Scanner;
public class GuessTheNumbers
{
    public static void main(String args[])
    {
        int attempts = 1;
        int NumbersGuessed = 0;
        int secretNumber = (int) (Math.random() * 70 + 1000);
        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to my project of Guess the Number \n Please take your time and be patient");
        do {
            System.out.print("Enter a guess number between 1 to 1000\n");
            if(userInput.hasNextInt()) {
                NumbersGuessed = userInput.nextInt();
                if (NumbersGuessed == secretNumber)
                {
                    System.out.println("Yay!, Your The Number you guessed was correct ");
                    break;
                }
                else if ( NumbersGuessed< secretNumber)
                    System.out.println("Your so close but the number is Less than that.");
                else if (NumbersGuessed > secretNumber)
                    System.out.println("Your Guess Number is more than that, Good Luck though .");
                if(attempts == 5) {
                    System.out.println("You Dont have any more chances");
                    break;
                }
                attempts++;
            }else {
                System.out.println("Enter Numbers Only");
                break;
            }
        } while ( NumbersGuessed!= secretNumber);
    }
}
