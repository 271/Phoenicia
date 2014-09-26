package models

import java.util.UUID
import play.api.libs.json._

case class Graph(uid: String, category: String)

sealed trait Category { def value: String }
case object music extends Category { val value = "music" }

object JsonFormats {
  implicit val graphFormat = Json.format[Graph]
}