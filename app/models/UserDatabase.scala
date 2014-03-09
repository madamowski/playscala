package models

import play.api.Play.current
import play.api.db._
import anorm._

/**
 * Created by madamowski on 02/03/2014.
 */
object UserDatabase {

  def getUsers: List[User] = {
    DB.withConnection { implicit conn =>
      val result = SQL("SELECT id, name from Users")().map{row=>
        new User(row[Int]("id"),row[String]("name"))
      }
      return result.toList
    }
  }

  def getUser(id:Int): User = {
    DB.withConnection { implicit conn =>
      val result = SQL("SELECT id, name from Users WHERE id="+id)().map{row=>
        new User(row[Int]("id"),row[String]("name"))
      }
      return result.toList(0)
    }
  }

  def insertUser(user:User) = {
    DB.withConnection { implicit conn =>
      val result = SQL("INSERT INTO Users(id,name) VALUES("+user.id+",'"+user.name+"')").execute()
    }
  }

  def deleteUser(id:Int) = {
    DB.withConnection { implicit conn =>
      val result = SQL("DELETE FROM Users WHERE id="+id).execute()
    }
  }
}
