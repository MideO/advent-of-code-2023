ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "advent-of-code-2023",
    libraryDependencies ++= Seq("org.reflections" % "reflections" % "0.10.2",
      "org.slf4j" % "slf4j-simple" % "2.0.9",
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
    )
  )
