package models

import play.api.Play.current
import play.api.db._
import anorm._

/**
 * Created by madamowski on 02/03/2014.
 */
object MyDatabase {

  def init = {
    DB.withConnection { conn =>
      val stm = conn.createStatement()
      //stm.execute("CREATE TABLE User(id int not null, name varchar(255) not null)")
      stm.execute("INSERT INTO User(id, name) VALUES (1,'John')")
    }
  }

  def getUsers: List[User] = {
    DB.withConnection { implicit conn =>
      val result = SQL("SELECT id, name from User")().map{
        case Row(id: Integer, name:String) => new User(id,name)
      }
      return result.map(row=>new User(row.id,row.name)).toList
    }
  }

  def getUser(id: Int): User = {
    DB.withConnection { implicit conn =>
      val result = SQL("SELECT id, name from User WHERE id="+id)().map{
        case Row(id: Integer, name:String) => new User(id,name)
      }.head
      return new User(result.id,result.name)
    }
  }

  def addUser(user:User) ={
    DB.withConnection { conn =>
      val stm = conn.createStatement()
      stm.execute("INSERT INTO (id, name) VALUES ("+user.id+","+user.name+")")
    }
  }

  def deleteUser = {

  }
}
