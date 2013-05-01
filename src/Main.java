import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int difficulty = 1;
    ComputerPlayer computerPlayer = new ComputerPlayer(difficulty);
    RPSScoreKeeper scorekeeper = new RPSScoreKeeper(0, 0);
    
    while (true) {
      System.out.print("Enter your move: ");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String humanMove = null;
      
      try {
        humanMove = br.readLine();
      } catch (IOException ioe) {
        System.out.println("IO error trying to read your move.");
        System.exit(1);
      }
      
      scorekeeper.determineWinner(humanMove, computerPlayer.getNextMove());
      scorekeeper.printScores();
      //System.out.println("Human: " + humanMove + " -- Computer: " + computerPlayer.getNextMove());
      computerPlayer.saveHumanMove(humanMove);
    }
    /*
    computerPlayer.saveHumanMove("R");
    System.out.println("Human: R, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("P");
    System.out.println("Human: P, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("R");
    System.out.println("Human: R, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("P");
    System.out.println("Human: P, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("S");
    System.out.println("Human: S, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("S");
    System.out.println("Human: S, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("S");
    System.out.println("Human: S, Computer: " + computerPlayer.getNextMove());

    computerPlayer.saveHumanMove("S");
    System.out.println("Human: S, Computer: " + computerPlayer.getNextMove());
    
    computerPlayer.saveHumanMove("R");
    System.out.println("Human: R, Computer: " + computerPlayer.getNextMove());
    
    computerPlayer.saveHumanMove("P");
    System.out.println("Human: P, Computer: " + computerPlayer.getNextMove());
    
    computerPlayer.saveHumanMove("R");
    System.out.println("Human: R, Computer: " + computerPlayer.getNextMove());
    
    computerPlayer.saveHumanMove("P");
    System.out.println("Human: P, Computer: " + computerPlayer.getNextMove());
    */
  }

}
