import java.util.HashMap;


public class ProbabilityTable {
  HashMap<String, Integer> moveCount;

  public ProbabilityTable(int difficulty) {
    moveCount = new HashMap<String, Integer>();
    initializeMoveCount(moveCount, difficulty);
  }

  public void incrementProbabilityTable(String lookback) {
    int count = moveCount.get(lookback);
    moveCount.put(lookback, count + 1);
  }

  //public String getOptimalNextMove(String lookback) {
  //}

  private void initializeMoveCount(HashMap moveCount, int difficulty) {
    String possibleMoves = "RPS";
    
    permutateMoves(moveCount, difficulty, possibleMoves, "");
  }

  private void permutateMoves(HashMap moveCounts, int difficulty, String possibleMoves, String permutation) {
    // Base case.
    if (permutation.length() == difficulty) {
      moveCounts.put(permutation, 1);
    } else {
      for(int i = 0; i < possibleMoves.length(); i++) {
        String nextPermutation = permutation.concat(possibleMoves.substring(i, i+1));

        permutateMoves(moveCounts, difficulty, possibleMoves, nextPermutation);
      }
    }
  }
}
