package models

import play.api.libs.json._

case class User(id: Int, name: String)

object User {
  implicit val userFormat = Json.format[User]
}

//  def this() = this(0, "")
//
//  implicit object UserFormat extends Format[User] {
//
//    def reads(json: JsValue) = User(
//      (json \ "id").as[Int],
//      (json \ "name").as[String]
//    )
//
//    def writes(user: User) = JsObject(Seq(
//      "id" -> JsNumber(user.id),
//      "name" -> JsString(user.name)
//    ))
//  }
//}

