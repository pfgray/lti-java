# LTI Java

LTI is a web application standard published by [IMS Global](http://www.imsglobal.org/) that enables learning tools to integrate with other systems.

Typically, this involves a Learning Management System (LMS) such as Blackboard, Canvas, etc. being extended by a tool that provides additional functionality. This additional functionality could be anything, and ranges from providing reading material for a student, to teaching materials for instructors, to even analytics interfaces for administrators.

In LTI, there are two entities, a Consumer and a Provider. The Consumer is the environment that is being extended, and the Provider is the tool providing the additional capabilities. To facilitate this, the consumer implements a set of APIs that the provider uses to interact with.

This library provides mechanisms supporting a few different frameworks such as the Java Servlet API, and the Spring framework. The dependencies provided via this framework are:

You can include these libraries in your `pom.xml` like so:
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

If you're using SBT you can include them in your `build.sbt` like so:

```
libraryDependencies ++= Seq(
  "net.paulgray" % "lti" % "1.0.0-SNAPSHOT",
  "net.paulgray" % "lti-spring" % "1.0.0-SNAPSHOT"
)
```


