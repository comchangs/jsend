workflow "build test" {
  resolves = ["comchangs/action-maven-deploy"]
  on = "push"
}

action "comchangs/action-maven-deploy" {
  uses = "comchangs/action-maven-deploy@master"
  args = "clean install compile package"
}
