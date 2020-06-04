package tennis


class TennisGame2(val player1Name: String, val player2Name: String) extends TennisGame {

    var p1Point = 0
    var p2Point = 0

    def calculateScore(): String = {
        var score = ""
        if (p1Point == p2Point) {
            score = p1Point match {
                case 0 => "Love-All"
                case 1 => "Fifteen-All"
                case 2 => "Thirty-All"
                case _ => "Deuce"
            }
        }

        if (p1Point >= 4 && p2Point >= 0 && (p1Point - p2Point) >= 2) score = "Win for player1"
        else if (p1Point > p2Point) {
            score = (p1Point,p2Point) match {
                case (1,0) => "Fifteen-Love"
                case (2,0) => "Thirty-Love"
                case (3,0) => "Forty-Love"
                case (2,1) => "Thirty-Fifteen"
                case (3,1) => "Forty-Fifteen"
                case (3,2) => "Forty-Thirty"
                case (_,_) if p2Point >= 3 => "Advantage player1"
            }
        }

        if (p2Point >= 4 && p1Point >= 0 && (p2Point - p1Point) >= 2) score = "Win for player2"
        else if (p2Point > p1Point) {
            score = (p1Point,p2Point) match {
                case (0,1) => "Love-Fifteen"
                case (0,2) => "Love-Thirty"
                case (0,3) => "Love-Forty"
                case (1,2) => "Fifteen-Thirty"
                case (1,3) => "Fifteen-Forty"
                case (2,3) => "Thirty-Forty"
                case (_,_) if p1Point >= 3 => "Advantage player2"
            }
        }

        score
    }

    def wonPoint(player: String) {
        if (player == "player1")
            p1Score()
        else
            p2Score()
    }

    def p1Score() {
        p1Point += 1
    }

    def p2Score() {
        p2Point += 1
    }
}