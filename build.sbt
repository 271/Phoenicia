import play.Project._

name := "Phoenicia"

version := "1.0.0-SNAPSHOT"

playScalaSettings

libraryDependencies ++= Seq(
  // ReactiveMongo dependencies
  "org.reactivemongo" %% "reactivemongo" % "0.10.0",
  // ReactiveMongo Play plugin dependencies
  "org.reactivemongo" %% "play2-reactivemongo" % "0.10.2"
)