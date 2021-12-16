
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (isP1LessThan4AndEqualToP2point())
        {
            score = evaluateP1Point(score);
            score += "-All";
        }
        if (isP1PointGreaterThanOrEqualTo3AndEqualToP2point())
            score = "Deuce";

        score = genericValidations(score);

        score = isThereAnyPlayerWithAnAdventaje(score);

        score = isThereaWinner(score);

        return score;
    }

    private String genericValidations(String score) {
        if (isP1pointgreaterThan0AndP2PointEqualTo0())
        {
            score = evaluateScoreAccordingP1point();
        }
        if (isP2pointGreaterThan0AndP1pointEqualTo0())
        {
            score = evaluateScoreAccordingToP2point();
        }

        if (isP1pointGreaterThanP2pointAndLessThan4())
        {
            score = scoreAccordingToP1pointAndP2point();
        }
        if (isP2pointGreaterThanP1pointAndLessThan4())
        {
            score = scoreAccordingToP2pointAndP1point();
        }
        return score;
    }

    private boolean isP2pointGreaterThanP1pointAndLessThan4() {
        return P2point>P1point && P2point < 4;
    }

    private boolean isP1pointGreaterThanP2pointAndLessThan4() {
        return P1point>P2point && P1point < 4;
    }

    private boolean isP2pointGreaterThan0AndP1pointEqualTo0() {
        return P2point > 0 && P1point==0;
    }

    private boolean isP1pointgreaterThan0AndP2PointEqualTo0() {
        return P1point > 0 && P2point==0;
    }

    private String isThereaWinner(String score) {
        score = player1IsWinner(score);
        score = player2IsWinner(score);
        return score;
    }

    private String player2IsWinner(String score) {
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String player1IsWinner(String score) {
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        return score;
    }

    private String isThereAnyPlayerWithAnAdventaje(String score) {
        score = hasAdventagePlayer1(score);
        score = hasAdventagePlayer2(score);
        return score;
    }

    private String hasAdventagePlayer2(String score) {
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        return score;
    }

    private String hasAdventagePlayer1(String score) {
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        return score;
    }

    private String scoreAccordingToP2pointAndP1point() {
        valueOfP2resInCaseP2pointBe2or3();
        valueOfP1resInCaseP1pointBe1or2();
        return P1res + "-" + P2res;
    }

    private void valueOfP1resInCaseP1pointBe1or2() {
        switch (P1point){
            case 1: P1res = "Fifteen";
                break;
            case 2: P1res = "Thirty";
                break;
        }
    }

    private void valueOfP2resInCaseP2pointBe2or3() {
        switch (P2point){
            case 2: P2res = "Thirty";
                break;
            case 3: P2res = "Forty";
                break;
        }
    }

    private String scoreAccordingToP1pointAndP2point() {
        valueOfP1resInCaseP1pointBe2or3();
        valueOfP2resInCaseP2pointBe1or2();
        return P1res + "-" + P2res;
    }

    private void valueOfP2resInCaseP2pointBe1or2() {
        switch (P2point){
            case 1: P2res = "Fifteen";
                break;
            case 2: P2res = "Thirty";
                break;
        }
    }

    private void valueOfP1resInCaseP1pointBe2or3() {
        switch (P1point){
            case 2: P1res = "Thirty";
                break;
            case 3: P1res = "Forty";
                break;
        }
    }

    private String evaluateScoreAccordingToP2point() {

        switch (this.P2point){
            case 1: P2res = "Fifteen";
                break;
            case 2: P2res = "Thirty";
                break;
            case 3: P2res = "Forty";
                break;
        }

        P1res = "Love";
        return P1res + "-" + P2res;
    }

    private String evaluateScoreAccordingP1point() {

        switch (this.P1point){
            case 1: P1res = "Fifteen";
                break;
            case 2: P1res = "Thirty";
                break;
            case 3: P1res = "Forty";
                break;
        }

        P2res = "Love";
        return P1res + "-" + P2res;
    }

    private boolean isP1PointGreaterThanOrEqualTo3AndEqualToP2point() {
        return P1point==P2point && P1point>=3;
    }

    private boolean isP1LessThan4AndEqualToP2point() {
        return P1point == P2point && P1point < 4;
    }

    private String evaluateP1Point(String score) {
        switch (this.P1point){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return score;
        }
    }

    public void SetP1Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P1point++;
        }
            
    }
    
    public void SetP2Score(int number){
        
        for (int i = 0; i < number; i++)
        {
            P2point++;
        }
            
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
    }
}