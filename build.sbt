name := """business-environment-task"""
organization := "lol.lolpany"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.google.inject" % "guice" % "4.2.3",
  "org.mybatis" % "mybatis" % "3.5.4",
  jdbc,
  evolutions,
  "com.h2database" % "h2" % "1.4.200"
)