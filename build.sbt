name := """business-environment-task"""
organization := "lol.lolpany"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.13.1"

libraryDependencies ++= Seq(
  "com.google" % "guice" % "3.5.4",
  "org.mybatis"    % "mybatis" % "5.4.10.Final",
  jdbc,
  evolutions,
  "com.h2database" % "h2" % "1.4.200"
)