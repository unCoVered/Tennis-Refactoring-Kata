package tennis


class TennisGame3(val player1Name: String, val player2Name: String) extends TennisGame {

    var points1: Int = 0
    var points2: Int = 0

    def calculateScore(): String = {
        if (points1 < 4 && points2 < 4 && !isDeuce(points1, points2)) {
            val pointsStrings = Array("Love", "Fifteen", "Thirty", "Forty")

            if (points1 == points2) pointsStrings(points1) + "-All"
            else pointsStrings(points1) + "-" + pointsStrings(points2)
        }
        else {
            if (points1 == points2) "Deuce"
            else {
                val ahead_player = if (points1 > points2) player1Name else player2Name
                if (pointsDiference(points1, points2) == 1) "Advantage " + ahead_player
                else "Win for " + ahead_player
            }
        }
    }

    def wonPoint(playerName: String) {
        if (playerName == "player1") this.points1 += 1
        else this.points2 += 1
    }

    def isDeuce(points1: Int, points2: Int): Boolean = {
        points1 + points2 == 6
    }

    def pointsDiference(points1: Int, points2: Int): Int = {
        (points1 - points2).abs
    }
}