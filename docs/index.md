# jsend
A library used for generating Json String of JSend

## Setting
### Maven
```xml
<dependency>
  <groupId>work.jeong.murry.jsend</groupId>
  <artifactId>jsend</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```
### Gradle
```
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
