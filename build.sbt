import com.github.sbt.jacoco.JacocoPlugin.autoImport.jacocoIncludes
import sbt.Keys.publishTo

lazy val commonSettings = Seq(
  organization := "net.paulgray",
  version := "1.0.0-SNAPSHOT",
  crossPaths := false,
  autoScalaLibrary := false,
  publishMavenStyle := true,
  testOptions in Test := Seq(Tests.Argument(TestFrameworks.JUnit, "-a")),
  jacocoExcludes in Test := Seq("*Builder*"),
  publishTo := {
    val v = version.value
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT"))
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases" at nexus + "service/local/staging/deploy/maven2")
  }
)

publishArtifact := false

lazy val core = (project in file("core"))
  .settings(
    commonSettings,
    name := "lti",
    crossPaths := false,
    description := "A library for implementing LTI",
    libraryDependencies ++= Seq(
      "commons-io" % "commons-io" % "2.4",
      "org.apache.commons" % "commons-lang3" % "3.1",
      "com.googlecode.json-simple" % "json-simple" % "1.1",
      "net.oauth.core" % "oauth-provider" % "20100527",
      "org.apache.httpcomponents" % "httpclient" % "4.0.1",
      "oauth.signpost" % "signpost-core" % "1.2.1.2",
      "oauth.signpost" % "signpost-commonshttp4" % "1.2.1.2",
      "com.fasterxml.jackson.core" % "jackson-core" % "2.8.6",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.8.6",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.6",
      "com.fasterxml.jackson.datatype" % "jackson-datatype-jdk8" % "2.8.6",
      "junit" % "junit" % "4.11" % Test,
      "com.novocode" % "junit-interface" % "0.11" % Test,
      "javax.servlet" % "javax.servlet-api" % "3.1.0",
      "org.powermock" % "powermock-module-junit4" % "1.5.5",
      "org.powermock" % "powermock-api-mockito" % "1.5.5",
      "org.inferred" % "freebuilder" % "1.14.8"
    )
  )

lazy val spring = (project in file("spring"))
  .dependsOn(core)
  .settings(
    commonSettings,
    name := "lti-spring",
    description := "A library for implementing LTI with the Spring framework",
    libraryDependencies ++= Seq(
      "org.aspectj" % "aspectjweaver" % "1.7.4",
    )
  )

enablePlugins(GitBookPlugin)

sourceDirectory in GitBook := baseDirectory.value / "gitbook"

publishMavenStyle := true

// don't attempt to publish an artifact for the root project (since there is none)
skip in publish := true

// jacocoReportSettings := JacocoReportSettings(...)
