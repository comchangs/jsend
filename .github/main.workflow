workflow "New workflow" {
  on = "push"
  resolves = ["comchangs/action-maven-deploy"]
}

action "comchangs/action-maven-deploy" {
  uses = "comchangs/action-maven-deploy@765e218a50f02a12a7596dc9e7321fc385888a27"
  args = "clean install compile package"
}
