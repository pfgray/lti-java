
# LTI Java  
  
A library that helps you write LTI applications for the JVM.

[Documentation](http://pfgray.github.io/lti-java)


LTI is a web application standard published by  [IMS Global](http://www.imsglobal.org/)  that enables learning tools to integrate with other systems.

This library provides mechanisms supporting a few different frameworks such as the Java Servlet API, and the Spring framework. The dependencies provided via this framework are:

You can include these libraries in your  `pom.xml`  like so:

```
<dependency>
  <groupId>net.paulgray</groupId>
  <artifactId>lti</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
<dependency>
  <groupId>net.paulgray</groupId>
  <artifactId>lti-spring</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

If you're using SBT you can include them in your  `build.sbt`  like so:

```
libraryDependencies ++= Seq(
  "net.paulgray" % "lti" % "1.0.0-SNAPSHOT",
  "net.paulgray" % "lti-spring" % "1.0.0-SNAPSHOT"
)
```
  
Pull requests are welcome and very much appreciated.
