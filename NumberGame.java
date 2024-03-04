import java.util.*;

class NumberGame
 {
    static ArrayList<Integer> S = new ArrayList<Integer>();

    public static void main(String[] V) {
        N A = new N();
        A.M(S);
    }

    public void M(ArrayList<Integer> S) {
        N A = new N();
        Scanner I = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("1) Play the Game");
        System.out.println("2) View Scoreboard");
        System.out.println("3) Exit");
        System.out.println("-------------------------------");
        try {
            System.out.print("What would you like to do? ");
            int o = I.nextInt();
            switch (o) {
                case 1:
                    System.out.print("\nEnter the upper limit of the number range: ");
                    int R = I.nextInt();
                    int X = A.N(R);
                    A.G(X);
                    break;
                case 2:
                    A.D();
                    break;
                case 3:
                    System.out.println("\nThank you for playing! Goodbye!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid input. Please try again.");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            M(S);
        }
    }

    public int N(int R) {
        Random I = new Random();
        int G = I.nextInt(R) + 1;
        return G;
    }

    public void G(int G) {
        Scanner I = new Scanner(System.in);
        int G1;
        int G2 = 0;
        do {
            System.out.print("Guess the number: ");
            G1 = I.nextInt();
            G2++;
            if (G1 > G) {
                System.out.println("Too high! Try a lower number.");
            } else if (G1 < G) {
                System.out.println("Too low! Try a higher number.");
            }
        } while (G != G1);
        System.out.println(" ");
        if (G2 == 1) {
            System.out.println("You guessed the number right in " + G2 + " attempt!");
        } else {
            System.out.println("You guessed the number right in " + G2 + " attempts!");
        }
        S.add(G2);
        System.out.println(" ");
        M(S);
    }

    public void D() {
        System.out.println("-------------------------------");
        System.out.println("Scoreboard");
        System.out.println("-------------------------------");
        System.out.println("Your best attempts today:");
        Collections.sort(S);
        for (Integer X : S) {
            System.out.println("Attempts: " + X);
        }
        System.out.println(" ");
        M(S);
    }
}
