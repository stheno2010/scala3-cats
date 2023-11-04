val scala3Version = "3.3.1"

autoCompilerPlugins := true

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-cats",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-effect" % "3.5.2",
      "org.typelevel" %% "munit-cats-effect-3" % "1.0.6" % Test
    ),
  )
