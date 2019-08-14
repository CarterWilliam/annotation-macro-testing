organization := "carter"

name := "annotation-macro-testing"

version := "0.0.1"

scalaVersion := "2.11.12"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "org.scala-lang"  % "scala-library" % scalaVersion.value,
  "org.scala-lang"  % "scala-reflect" % scalaVersion.value,

  "org.scalatest"   %% "scalatest"    % "2.2.6"   % "test",
  "org.scala-lang"  % "scala-reflect" % scalaVersion.value   % "test",
  "org.scalamacros" % s"paradise_${scalaVersion.value}"  % "2.1.1" % "test"
)
