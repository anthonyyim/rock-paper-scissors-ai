import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  public static void main(String[] args) {
    int difficulty = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Ask user for difficulty level. Keep asking while input is invalid.
    while (true) {
      try {
        System.out.print("Please enter the difficulty level. 0 (easy) --> 2 (hard): ");
        difficulty = Integer.parseInt(br.readLine());
        
        // Input validation.
        if (difficulty >= 0 && difficulty <= 2) {
          break; // Stop asking for difficulty level given valid input.
        } else {
          System.out.println("An invalid difficulty level was entered.");
        }
        
      } catch (IOException ioe) {
        System.out.println("IO error trying to read difficulty level.");
        System.exit(1);
      } catch (NumberFormatException nfe) {
        System.out.println("An invalid difficulty level was entered.");
      }
    }

    // Start game.
    ComputerPlayer computerPlayer = new ComputerPlayer(difficulty);
    RPSScoreKeeper scorekeeper = new RPSScoreKeeper(0, 0);

    // Repeatedly read human player moves.
    while (true) {
      String humanMove = null;

      while (true) {
        try {
          System.out.print("Enter your move (\"R\"-Rock; \"P\"-Paper; \"S\"-Scissors): ");
          humanMove = br.readLine();

          // Input validation.
          if (humanMove.equals("R") || humanMove.equals("P") || humanMove.equals("S")) {
            break; // Proceed to play given valid move input by human player.
          } else {
            System.out.println("An invalid move was entered.");
          }

        } catch (IOException ioe) {
          System.out.println("IO error trying to read your move.");
          System.exit(1);
        }
      }

      scorekeeper.determineWinner(humanMove, computerPlayer.getNextMove());
      scorekeeper.printScores();

      // Save human player's actual move to refine the prediction hypothesis.
      computerPlayer.saveHumanMove(humanMove);
    }
  }
}
