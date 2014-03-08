name := "playscala"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "org.scalatest" % "scalatest_2.10" % "2.1.0" % "test",
  "org.xerial" % "sqlite-jdbc" % "3.7.2"
)     

play.Project.playScalaSettings
