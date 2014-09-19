package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json, Json.{stringify, toJson}
import reactivemongo.api.Cursor
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection

object HelloWorld extends Controller with MongoController {
  import models.User
  import models.JsonFormats.userFormat

  def collection: JSONCollection = db.collection[JSONCollection]("users")

  def findByLastName(lastName: String) = Action.async { request =>
    collection
      .find(Json.obj("lastName" -> lastName))
      .sort(Json.obj("created" -> -1))
      .cursor[User]
      .collect[List]()
      .map { persons =>
      Ok(stringify(toJson(persons)))
    }
  }
}