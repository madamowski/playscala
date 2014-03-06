package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json._
import models._

/**
 * Created by madamowski on 02/03/2014.
 */
object UserController extends Controller {

  def getUsers = Action{
    val list = MyDatabase.getUsers.toList
    Ok(Json.toJson(list))
  }

  def getUser() = Action{
    val user = MyDatabase.getUser(1)
    Ok(Json.toJson(user))

    //    Ok(JsObject(
    //      "id" -> JsNumber(user.id) ::
    //      "name" -> JsString(user.name) ::
    //        Nil))
  }

//  public static Result getUsers()
//  {
//    List<User> users = Database.getUsers();
//    return ok(Json.toJson(users));
//  }
//
//  public static Result getUser(Long id)
//  {
//    User user = Database.getUser(id);
//    return user == null ? notFound() : ok(Json.toJson(user));
//  }
//
  def createUser = Action { request =>
    //val newUser = Json.fromJson(request.body,User.class)
    Ok("created")
  }

//  public static Result createUser()
//  {
//    User newUser = Json.fromJson(request().body().asJson(), User.class);
//    User inserted = Database.addUser(newUser);
//    return created(Json.toJson(inserted));
//  }
//
//  public static Result updateUser(Long id)
//  {
//    User user = Json.fromJson(request().body().asJson(), User.class);
//    User updated = Database.updateUser(id, user);
//    return ok(Json.toJson(updated));
//  }
//
//  public static Result deleteUser(Long id)
//  {
//    Database.deleteUser(id);
//    return noContent(); // http://stackoverflow.com/a/2342589/1415732
//  }

}
