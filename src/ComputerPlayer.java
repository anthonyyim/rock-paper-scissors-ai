
public class ComputerPlayer {
  int difficulty;
  ProbabilityTable probabilityTable;
  String lookback = "";
  
  public ComputerPlayer(int difficulty) {
    this.difficulty = difficulty;
    probabilityTable = new ProbabilityTable(difficulty);
  }

  public String getNextMove() {
    return probabilityTable.getOptimalNextMove(lookback);
  }

  public void saveHumanMove(String move) {
    if (lookback.length() == difficulty) {
      probabilityTable.incrementProbabilityTable(lookback, move);
    } else if (lookback.length() > difficulty){
      probabilityTable
          .incrementProbabilityTable(lookback.substring(lookback.length() - difficulty), move);
    }

    lookback = lookback.concat(move);
  }
}
