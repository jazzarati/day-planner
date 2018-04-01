# Day Planner
Little CLI tool I built to learn a bit of java

It allows you to plan out the tasks for your day.

# Usage
- `java -jar planner.jar [planFile]`

Then type `?` to see the list of available commands.

- `l` List activities
- `13 30 Eat lunch` Add an activity to eat lunch at 13:30
- `m 1 9 15` Move activity at index 1 to 9:15
- `d 1` Remove an activity at index 1
- `q` Save plan to file and quit

# Development
## Build
- `./build.sh`

## Tests
- Currently run through intelliJ
