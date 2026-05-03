fun main(){
    var Rupak = Player("Rupak", "Maiti")
    var Deep = Player("Deep", "Maiti")
    Rupak.updateScore(5, 150)
    Rupak.profile()
    Rupak.updateScore(7, 15)
    Rupak.profile()
}

class Player(val firstname : String, val lastname : String){
    var bestScore : BestScore = BestScore(0, 0)
    var CurrentLevel : Score = Score(0, 0)

    fun fullName() : String {
        println("Full name : $firstname $lastname")
        return "$firstname $lastname"
    }

    fun updateScore(level : Int, levelScore : Int) : Score {
        if(levelScore >= bestScore.levelScore){
            bestScore = BestScore(level, levelScore)
        }
        CurrentLevel = Score(level, levelScore)
        return CurrentLevel
    }

    fun profile(){
        println("Full Name : " + this.fullName())
        println("Best Score : " + this.bestScore.levelScore + " at Level " + this.bestScore.level)
        println("Current Level : " + this.CurrentLevel.level + " Level Score " + this.CurrentLevel.levelScore)
    }
}

class Score(var level : Int, var levelScore : Int)

class BestScore(var level : Int, var levelScore : Int)