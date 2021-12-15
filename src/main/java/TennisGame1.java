import java.util.Objects;

public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            this.m_score1 += 1;
        else
            this.m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        
        if (isScore1EqualToScore2())
        {
            score= whenEqualScores();
        }
        else if (isScore1OrScore2GreatterThan4())
        {
            score= whenScoresGreaterThan4(score);
        }
        else
        {
            score = lessThan4(score);
        }
        
        return score;
    }

    private boolean isScore1OrScore2GreatterThan4() {
        return m_score1>=4 || m_score2>=4;
    }

    private boolean isScore1EqualToScore2() {
        return m_score1==m_score2;
    }

    public String whenEqualScores(){
        switch (this.m_score1)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    public String whenScoresGreaterThan4(String score){
        int minusResult = m_score1-m_score2;
        if (isMinusResultEqualTo1(minusResult)) score ="Advantage player1";
        else if (isMinusResultEqualToNegative1(minusResult)) score ="Advantage player2";
        else if (isMinusResultEqualOrGreaterThan2(minusResult)) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean isMinusResultEqualOrGreaterThan2(int minusResult) {
        return minusResult>=2;
    }

    private boolean isMinusResultEqualToNegative1(int minusResult) {
        return minusResult ==-1;
    }

    private boolean isMinusResultEqualTo1(int minusResult) {
        return minusResult==1;
    }

    public String lessThan4(String score){
        int tempScore = 0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
            score+= concatScore(tempScore, score);
        }
        return score;
    }

    public String concatScore(int tempScore, String score){
        switch(tempScore)
        {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default: 
                return score;
        }
    }
}
