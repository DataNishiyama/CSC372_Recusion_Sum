//Import Scanner and Mismatch Exception
import java.util.Scanner;
import java.util.InputMismatchException;

public class RPGGoldKeeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Prompt User For Input
        System.out.println("Vault Keeper: Welcome, adventurer! How much gold would you like to deposit in our vault?" +
                "Please mind we may only accept x5 deposits each day!");

        try {

            int sum = calculateGoldSum(1, 0, scanner);


            System.out.println("Vault Keeper: Thank you, adventurer! The total gold in our vault is now: " + sum);
        } catch (InputMismatchException e) {

            //Input Mismatch
            System.out.println("Vault Keeper: Invalid input. Please enter a valid number of gold coins.");
        } finally {

            //Scanner Close
            scanner.close();
        }
    }

    //Base Case
    private static int calculateGoldSum(int count, int currentSum, Scanner scanner) {
        if (count > 5) {
            return currentSum;
        }

        //User Prompt
        System.out.print("Vault Keeper: Enter the amount of gold coins for deposit number " + count + ": ");
        int goldAmount;

        try {
            goldAmount = scanner.nextInt();
        } catch (InputMismatchException e) {


            //Throw Exception
            scanner.nextLine();
            throw e;
        }


        System.out.println("Vault Keeper: Gold coins accepted! Thank you, adventurer.");

        //Recursive Call
        return calculateGoldSum(count + 1, currentSum + goldAmount, scanner);
    }
}
