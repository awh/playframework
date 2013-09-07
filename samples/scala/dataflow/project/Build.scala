import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "dataflow"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "com.typesafe.akka" %% "akka-dataflow" % "2.1.0"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    autoCompilerPlugins := true,
    libraryDependencies <+= scalaVersion { v =>
      compilerPlugin("org.scala-lang.plugins" % "continuations" % v) },
    scalacOptions += "-P:continuations:enable"  )

}
