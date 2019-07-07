workflow "build test" {
  resolves = ["comchangs/action-maven"]
  on = "push"
}

action "comchangs/action-maven" {
  uses = "comchangs/action-maven@v0.4-beta"
  args = "clean compile test"
}
