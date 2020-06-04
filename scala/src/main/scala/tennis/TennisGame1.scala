package tennis


class TennisGame1(val player1Name: String, val player2Name: String) extends TennisGame {
    val scoresString = Map(0 -> "Love", 1 -> "Fifteen", 2 -> "Thirty", 3 -> "Forty")

    var score1: Int = 0
    var score2: Int = 0

    def wonPoint(playerName: String) {
        if (playerName == "player1") score1 += 1
        else score2 += 1
    }

    def calculateScore(): String = {
        val score: String = ""

        score match {
            case _ if score1 == score2 => handleDraw(score1)
            case _ if score1 >= 4 || score2 >= 4 => handleAdvantage(score1 - score2)
            case _ => getScoreString(score1) + "-" + getScoreString(score2)
        }
    }

    def handleDraw(score: Int): String = {
        score match {
            case 0 => "Love-All"
            case 1 => "Fifteen-All"
            case 2 => "Thirty-All"
            case _ => "Deuce"
        }
    }

    def handleAdvantage(difference: Int): String = {
        difference match {
            case -1 => "Advantage player2"
            case 1 => "Advantage player1"
            case _ if difference >= 2 => "Win for player1"
            case _ => "Win for player2"
        }
    }

    def getScoreString(score: Int): String = {
        score match {
            case 0 => "Love"
            case 1 => "Fifteen"
            case 2 => "Thirty"
            case 3 => "Forty"
        }
    }
}