name := "ims-scala"

version := "0.1"

scalaVersion := "2.13.4"


libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "org.mockito" % "mockito-core" % "2.7.22" % Test,
  "org.reactivemongo" %% "play2-reactivemongo" % "0.20.3-play27",
  "org.scalatest" %% "scalatest" % "3.0.8" % Test,
  "mysql" % "mysql-connector-java" % "6.0.6",
  "org.scalatest" %% "scalatest-funsuite" % "3.2.2" % Test,
  "org.slf4j" % "slf4j-nop" % "1.6.4",
  "com.typesafe.slick" %% "slick" % "3.3.3"
)

idePackagePrefix := Some("me.lukasz")