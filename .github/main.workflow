workflow "build test" {
  resolves = ["comchangs/action-maven-deploy"]
  on = "push"
}

action "comchangs/action-maven-deploy" {
  uses = "comchangs/action-maven-deploy@v0.2-beta"
  args = "clean compile test"
}

workflow "release" {
  on = "release"
  resolves = ["comchangs/action-maven-deploy@v0.2-beta"]
}

action "comchangs/action-maven-deploy@v0.2-beta" {
  uses = "comchangs/action-maven-deploy@v0.2-beta"
  args = "clean deploy"
}
