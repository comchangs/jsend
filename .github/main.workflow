workflow "build on push" {
  on = "push"
  resolves = ["Maven"]
}

action "Maven" {
  uses = "comchangs/action-maven-deploy"
  args = "clean install compile package"
  secrets = ["MAVEN_SETTINGS"]
}
