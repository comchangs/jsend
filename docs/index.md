# jsend
A library used for generating Json String of JSend

[![Maven Central](https://img.shields.io/maven-central/v/work.jeong.murry.jsend/jsend.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22work.jeong.murry.jsend%22%20AND%20a:%22jsend%22)

## Setting
### Maven
```xml
<dependency>
  <groupId>work.jeong.murry.jsend</groupId>
  <artifactId>jsend</artifactId>
  <version>1.0</version>
</dependency>
```
### Gradle
```groovy
dependencies {
    implementation("work.jeong.murry.jsend", "jsend", "{latest_version}")
}
```

## Usage
### sucess
```java
    JSend success = JSend.success();
```
or
```java
    Pet pet = new Pet("moon");
    JSend success = JSend.success(pet);
```
### error
```java
    JSend error = JSend.error("It has been occurred an error.");
```
or
```java
    Pet pet = new Pet("moon");
    JSend error = JSend.error(500, "It has been occurred an error.", pet);
```
### fail
```java
    Pet pet = new Pet("moon");
    JSend fail = JSend.fail(pet);
```
