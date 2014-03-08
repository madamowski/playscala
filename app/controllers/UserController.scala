package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models._

/**
 * Created by madamowski on 02/03/2014.
 */
object UserController extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def user = Action {
    Ok(views.html.user("User Database"))
  }

  def getUser(id:Int) = Action {
    Ok(Json.toJson(UserDatabase.getUser(id)))
  }

  def getUsers = Action {
    Ok(Json.toJson(UserDatabase.getUsers))
  }

  def insertUser = Action { request =>
    var json = request.body.asJson.get
    var user = Json.fromJson[User](json).get
    UserDatabase.insertUser(user)
    //var newUser = Json.fromJson[User](Json.parse(request.body))
    Ok("ok")
  }

  def deleteUser(id:Int) = Action {
    UserDatabase.deleteUser(id)
    Ok("ok")
  }

}
