package ohtu;

public class TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")) {
            player1.addOnePoint();
        } else if (playerName.equals("player2")) {
            player2.addOnePoint();
        }
    }

    public String getScore() {

        if (player1.getScore() == player2.getScore()) {
            return countScoreWhenTie();
        } else if (player1.getScore() >= 4 || player2.getScore() >= 4) {
            return countScoreWhenOver4Points();
        } else {
            return countNormalScore();
        }

    }

    public String countNormalScore() {
        int tempScore = 0;
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1.getScore();
            } else {
                score += "-";
                tempScore = player2.getScore();
            }
            switch (tempScore) {
                case 0:
                    score += "Love";
                    break;
                case 1:
                    score += "Fifteen";
                    break;
                case 2:
                    score += "Thirty";
                    break;
                case 3:
                    score += "Forty";
                    break;
            }
        }

        return score;

    }

    public String countScoreWhenTie() {
        String score = "";
        switch (player1.getScore()) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            case 3:
                score = "Forty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }

    public String countScoreWhenOver4Points() {
        String score = "";
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
}
