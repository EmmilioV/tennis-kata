
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;
        if (isP1AndP2LessThan4() && !isP1PlusP2EqualTo6()) {
            s = getScoreAccordingToP1();
            return s;
        }
        if (isP1EqualToP2())
            return "Deuce";
        
        s = scoreIfP1GreaterThanP2();
        return thereIsAnAdventageOrWinner(s);
    }

    private String thereIsAnAdventageOrWinner(String s) {
        return isP1MinusP2SquaredEquals1() ? "Advantage " + s : "Win for " + s;
    }

    private boolean isP1MinusP2SquaredEquals1() {
        return (p1-p2)*(p1-p2) == 1;
    }

    private String scoreIfP1GreaterThanP2() {
        String s;
        s = p1 > p2 ? p1N : p2N;
        return s;
    }

    private boolean isP1EqualToP2() {
        return p1 == p2;
    }

    private String getScoreAccordingToP1() {
        String s;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        s = p[p1];
        s = scoreWhenP1EqualToP2(s, p);
        return s;
    }

    private String scoreWhenP1EqualToP2(String s, String[] p) {
        return (isP1EqualToP2()) ? s + "-All" : s + "-" + p[p2];
    }

    private boolean isP1AndP2LessThan4() {
        return p1 < 4 && p2 < 4;
    }

    private boolean isP1PlusP2EqualTo6() {
        return p1 + p2 == 6;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
