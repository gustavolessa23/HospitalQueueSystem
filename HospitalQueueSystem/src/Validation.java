

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains methods used to validate user input such as  
 * int, int with defined range and yes/no.
 * @author Gustavo Lessa
 * @author Rafael Barros
 */
public class Validation {
    

    
    /**
     * This method checks if the input is a integer.
     * @param input (boolean)
     * @return -1 if the input is not a integer
     */
    public int checkForInt(Scanner input){
        try{
        	return input.nextInt();
        } catch(InputMismatchException e){
            input.next();
            View.displayError(("\n*** Input is not a integer. Please try again. ***\n"));
            return checkForInt(input);
        }
    }
 
    /**
     * This method checks for a positive answer from user.
     * @param input (Scanner)
     * @return true if the input is 'Y' or 'y' and false otherwise
     */
    public boolean checkForYes(Scanner input){
        String answer = "";
        try{
            while(answer.isEmpty()){
                answer = input.nextLine();
            }
            if(answer.startsWith("y") || answer.startsWith("Y")){
                return true;
            } else {
                return false;
            }
            } catch(InputMismatchException e){
            System.out.println("\n*** Input is not a integer. Please try again. ***\n");
            return checkForYes(input);
        }
    }
    
    /**
     * This method checks for a integer input between a specific boundary.
     * @param input (Scanner)
     * @param lowerBoundary (int)
     * @param upperBoundary (int)
     * @return A validated integer between the specified boundary.
     */
    public int checkForInt(Scanner input, int lowerBoundary, int upperBoundary){
        int typedInt = 0;
        try{
            while(typedInt == 0){
                typedInt = input.nextInt();
            }
            if(typedInt>=lowerBoundary && typedInt<=upperBoundary){
                return typedInt;
            }else{
                System.out.println("\n*** The option should be and integer between "+
                        lowerBoundary+" and "+upperBoundary+". ***\n");
                System.out.println("Please try again:");
                return checkForInt(input, lowerBoundary,upperBoundary);
            }
        } catch(InputMismatchException e){
            System.out.println("\n*** Input is not an integer. ***\nPlease try again.\n");
            input.nextLine();
            return checkForInt(input, lowerBoundary,upperBoundary);
        }
    }
    

}