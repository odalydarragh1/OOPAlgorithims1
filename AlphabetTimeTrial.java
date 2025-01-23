import static java.lang.Character.*;
import java.util.Scanner;

public class AlphabetTimeTrial {
    private final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public AlphabetTimeTrial() {
        beginTrial(getDirection());
    }

    public void beginTrial(boolean backwards) {
        Scanner in = new Scanner(System.in);
        char input;

        int i = 0; if (backwards) {i=25;}
        int incriment = 1; if (backwards) {incriment = -1;}

        System.out.println("First letter: " + alphabet[i]);
        long timer = System.nanoTime(); // timer starts right before the time trial begins to assure accurate timing
        while (i <= 25 && i >= 0) {
            input = toUpperCase(in.next().charAt(0)); // uppercase for stability

            if (input == alphabet[i]) {
                System.out.print("Correct!");
                i += incriment;
            } else {
                System.out.print("Incorrect!");
            }
            
            if (i!=-1 && i!=26){ // keep incrimentation within array bounds
                System.out.print("\tNext letter: " + alphabet[i] + "\n");
            }
        }
        timer = (System.nanoTime() - timer)/1000000000; // nanoseconds to seconds
        System.out.println("\tTime taken: " + timer + "s");
    }

    public boolean getDirection() {
        boolean valid = false;
        char direction;
        boolean backwards = false;
        Scanner input = new Scanner(System.in);

        while (!valid) {
            System.out.println("Enter the direction: F/B");
            direction = toUpperCase(input.next().charAt(0));

            if (direction == 'B') {
                valid = true;
                backwards = true;
            }

            else if (direction == 'F') {
                valid = true;
            }

            else {
                System.out.println("Invalid direction");
            }
        }
        return backwards;
    }
}
