
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    int difficulty = 3;
    ComputerPlayer computerPlayer = new ComputerPlayer(difficulty);

    computerPlayer.saveHumanMove("R");
    computerPlayer.saveHumanMove("P");
    computerPlayer.saveHumanMove("R");
    computerPlayer.saveHumanMove("P");
    computerPlayer.saveHumanMove("S");
    computerPlayer.saveHumanMove("S");
    computerPlayer.saveHumanMove("S");
  }

}
