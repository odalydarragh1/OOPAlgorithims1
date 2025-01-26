import static java.lang.Character.*;
import java.util.Scanner;

public class AlphabetTimeTrial {
    static final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public AlphabetTimeTrial() {
        Scanner in = new Scanner(System.in); // use the same scanner for both methods for efficiency
        beginTrial(getDirection(in), in);
    }

    public void beginTrial(boolean backwards, Scanner in) {
        char input;

        int i = 0; if (backwards) {i=25;}
        int increment = 1; if (backwards) {increment = -1;} // having a variable increment and index initialisation allows for less repeated code

        System.out.println("First letter: " + alphabet[i]);
        long timer = System.nanoTime(); // timer starts right before the time trial begins to assure accurate timing
        while (i <= 25 && i >= 0) {
            
            try {
                input = toUpperCase(in.next().charAt(0)); // uppercase for input predictability
            } catch (Exception e) { // Catch any errors from unexpected input
                System.out.println("Invalid input. Try again.");
                continue;
            }
            
            if (input == alphabet[i]) {
                System.out.print("Correct!");
                i += increment;
            } else {
                System.out.print("Incorrect!");
            }
            
            if (i!=-1 && i!=26){ // keep incrementation within array bounds
                System.out.print("\tNext letter: " + alphabet[i] + "\n");
            }
        }
        timer = (System.nanoTime() - timer)/1000000000; // nanoseconds to seconds
        System.out.println("\tTime taken: " + timer + "s");
    }

    public boolean getDirection(Scanner in) {
        char direction;
        
        while (true) {
            System.out.println("Enter the direction: F/B");
            direction = toUpperCase(in.next().charAt(0)); // uppercase for input predictability

            if (direction == 'B') {return true;} // quickly return to avoid wasting resources checking the next if statment

            else if (direction == 'F') {return false;}

            System.out.println("Invalid direction");
            
        }
    }
}
