workflow "New workflow" {
  on = "push"
  resolves = ["comchangs/action-maven-deploy"]
}

action "comchangs/action-maven-deploy" {
  uses = "comchangs/action-maven-deploy@master"
  args = "clean install compile package"
}
