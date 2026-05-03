data class User(val id: Int) {
    val relations = mutableMapOf<User, RelationType>()

    fun addRelation(otherUser: User, type: RelationType) {
        this.relations[otherUser] = type
    }

    fun removeRelation(otherUser: User) {
        this.relations.remove(otherUser)
    }
}

enum class RelationType {
    Friends,
    Family,
    Work,
    Follower
}

class Post(val user: User, val content: String){
    val blockeds = mutableSetOf<User>()
    val comments = mutableListOf<Comment>()

    fun block(user: User){
        blockeds.add(user)
    }

    fun comment(user: User, content: String){
        if(blockeds.contains(user)) {
            println("You can't comment this post")
        }   else    {
            comments.add(Comment(user, content))
        }
    }

    fun showPost(){
        println("Post: $content")
        if(comments.isEmpty()){
            println("No comments")
        }   else    {
            for(comment in comments){
                if(user.relations.containsKey(comment.user)){
                    println("Comment from ${comment.user.id}, ${user.relations[comment.user]} : ${comment.content}")
                }   else    {
                        println("Comment from ${comment.user.id} : ${comment.content}")
                }
            }
        }
    }
}

data class Comment(val user: User, val content: String)

fun main(){
    val user1 = User(1)
    val user2 = User(2)
    val user3 = User(3)
    val user4 = User(4)


    user1.addRelation(user2, RelationType.Friends)
    user1.addRelation(user3, RelationType.Family)

    val post1 = Post(user1, "Hello World")
    post1.comment(user2, "Nice post")
    post1.comment(user3, "I love it")
    post1.comment(user4, "I hate it")
    post1.block(user4)

    post1.showPost()



}

