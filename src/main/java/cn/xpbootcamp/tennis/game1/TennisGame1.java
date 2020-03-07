package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName == player1.getName()) {
            player1.win();
        } else {
            player2.win();
        }
    }

    public String getScore() {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();

        if (isDeuce(player1Score, player2Score)) {
            return getScoreWhenDeuce(player1Score);
        }
        if (isAdvantageAndWin(player1Score, player2Score)) {
            return getScoreWhenAdvantageAndWin(player1Score, player2Score);
        }

        return getScoreWhenNormal(player1Score, player2Score);
    }

    private boolean isDeuce(int score1, int score2) {
        return score1 == score2;
    }

    private boolean isAdvantageAndWin(int score1, int score2) {
        return score1 >= 4 || score2 >= 4;
    }

    private String getScoreWhenNormal(int score1, int score2) {
        String[] scoreStringMap = {"Love", "Fifteen", "Thirty", "Forty"};

        return scoreStringMap[score1] + "-" + scoreStringMap[score2];
    }

    private String getScoreWhenAdvantageAndWin(int score1, int score2) {
        int minusResult = score1 - score2;

        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getScoreWhenDeuce(int score) {
        switch (score) {
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
}