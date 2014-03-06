import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.specs2.runner.JUnitRunner
import play.api.libs.json._
import models._
import play.Logger

@RunWith(classOf[JUnitRunner])
class UserSuite extends FunSuite {

  test("json basics") {
    Logger.info("log message")

    val user = new User(1,"John")
    assert(user.id == 1)
    assert(user.name == "John")

    val json = Json.toJson(user)
    val jsonString = Json.stringify(json)

    assert("""{"id":1,"name":"John"}""" == jsonString)

    val user1 = Json.fromJson[User](Json.parse(jsonString)).get

    assert(user1.id == 1)
    assert(user1.name == "John")
  }

}
