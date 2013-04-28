
public class ComputerPlayer {
  int difficulty;
  ProbabilityTable probabilityTable;
  String lookback = "";
  
  public ComputerPlayer(int difficulty) {
    this.difficulty = difficulty;
    probabilityTable = new ProbabilityTable(difficulty);
  }

  //public enum getNextMove() {
  //}

  public void saveHumanMove(String move) {
    lookback = lookback.concat(move);

    if (lookback.length() == difficulty) {
      probabilityTable.incrementProbabilityTable(lookback);
    } else if (lookback.length() > difficulty){
      probabilityTable
          .incrementProbabilityTable(lookback.substring(lookback.length() - difficulty));
    }
  }
}
