name := "ims-scala"

version := "0.1"

scalaVersion := "2.13.4"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"
libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.6.4"
libraryDependencies += "mysql" % "mysql-connector-java" % "6.0.6"

idePackagePrefix := Some("me.lukasz")