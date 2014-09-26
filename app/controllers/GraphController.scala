package controllers

import play.api.Logger
import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.libs.json.Json
import play.modules.reactivemongo.MongoController
import play.modules.reactivemongo.json.collection.JSONCollection
import scala.concurrent.Future

object GraphController extends Controller with MongoController {
  import models._
  import models.JsonFormats._

  def collection: JSONCollection = db.collection[JSONCollection]("graph")

  def subscribe = Action.async(parse.anyContent) { request =>
    request.body.asJson.map(_.as[Graph]).map {
      case Graph(uid, category) if category == music.value =>
        val json = Json.obj(
          "uid" -> uid,
          "category" -> category
        )
        collection.insert(json).map { lastError =>
          Logger.debug(s"Subscription complete: result $lastError")
          Created
        }
      case category => Future.successful(BadRequest(s"Encountered unknown category = $category"))
    }.getOrElse(Future.successful(BadRequest(s"Received invalid payload for request: $request")))
  }
}