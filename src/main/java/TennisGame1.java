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

        if (m_score1==m_score2)
        {
            return whenEqualScores(score);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            return whenScoresGreaterThan4(score);
        }

        return lessThan4(score);
    }

    public String whenEqualScores(String score){
        switch (this.m_score1)
        {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    public String whenScoresGreaterThan4(String score){
        int minusResult = m_score1-m_score2;
        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    public String lessThan4(String score){
        int tempScore = 0;
        for (int i=1; i<3; i++)
        {
            if (i==1) tempScore = m_score1;
            else { score+="-"; tempScore = m_score2;}
            score= concatScore(tempScore, score);
        }
        return score;
    }

    public String concatScore(int tempScore, String score){
        switch(tempScore)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
        return  score;
    }
}
