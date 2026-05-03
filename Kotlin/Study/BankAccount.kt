class BankAccountUser(val name: String, val id: Int) {
    var money: Int = 0

    fun checkBalance() {
        println("You have $$money in your account")
    }

    fun deposit() {
        print("How much do you want to Deposit: ")
        try {
            val amount = readln().toInt()
            if (amount > 0) {
                money += amount
                println("You have $$money in your account now")
            } else {
                println("Amount must be positive.")
            }
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter a number.")
        }
    }


    fun withdraw() {
        print("How much do you want to Withdraw: ")
        try {
            val amount = readln().toInt()
            if (amount <= money) {
                money -= amount
                println("You have $$money in your account now")
            } else {
                println("Insufficient Balance!! You only have $$money.")
            }
        } catch (e: NumberFormatException) {
            println("Invalid input. Please enter a number.")
        }
    }

    fun showMenu() {
        println("\nWelcome to your banking system, $name!!")

        var isRunning = true

        while (isRunning) {
            println("\nWhat type of feature would you like to access?")
            println("1. Check Balance")
            println("2. Deposit Money")
            println("3. Withdraw Money")
            println("4. Exit")
            print("Choose option (1-4): ")

            try {
                val option = readln().toInt()
                println("Your selected option: $option")

                when (option) {
                    1 -> checkBalance()
                    2 -> deposit()
                    3 -> withdraw()
                    4 -> {
                        println("Thank you for banking with us!")
                        isRunning = false
                    }
                    else -> println("Wrong option Chosen. Please try again.")
                }
            } catch (e: NumberFormatException) {
                println("Please enter a valid number.")
            }
        }
    }
}

fun main() {
    val user1 = BankAccountUser("Rupak", 100)
    user1.showMenu()
}
