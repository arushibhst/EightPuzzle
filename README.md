# EightPuzzle
## How to run:
* Compile: javac AStar.java
* Run: java AStar
* The program allows the path to be calculated with the Misplaced Tiles heuristic or the Manhattan Distance heuristic in the evaluation function. It will ask you if you want the path to be found with the misplaced tiles heuristic.
* You need to enter yes/y or no/n. If you enter yes, it will use the Misplaced Tiles heuristic in the evaluation function. If you enter no, it will use the Manhattan distance heuristic in the evaluation function. 

## Program Output
### Output using Misplaced Tiles Heuristic in Evaluation function:
Welcome to the eight puzzle problem! In this puzzle you slide a number tile to the blank space (represented by 0). 
Would you like the path to be calculated with the Misplaced Tiles heuristic? If not, the Manhattan Distance heuristic will be used. (yes/no)?:
y <br>
Using Misplaced Tiles Heuristics <br>
We want to reach from this initial state: <br>
[2, 8, 3] <br>
[1, 6, 4] <br>
[7, 0, 5]

To this goal state: <br>
[1, 2, 3] <br>
[8, 0, 4] <br>
[7, 6, 5]

Below you will see the path from the initial state to the goal. The state and the result of the evaluation function is displayed at each step. <br>
state: <br>
[2, 8, 3] <br>
[1, 6, 4] <br>
[7, 0, 5] <br>

f for this state: 4 <br>
g for this state: 0 <br>
h for this state: 4

state: <br>
[2, 8, 3] <br>
[1, 0, 4] <br>
[7, 6, 5] <br>
f for this state: 4 <br>
g for this state: 1 <br>
h for this state: 3 

state: <br>
[2, 0, 3] <br>
[1, 8, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 2 <br>
h for this state: 3 

state: <br>
[0, 2, 3] <br>
[1, 8, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 3 <br>
h for this state: 2 

state: <br>
[1, 2, 3] <br>
[0, 8, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 4 <br>
h for this state: 1 

state: <br>
[1, 2, 3] <br>
[8, 0, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 5 <br>
h for this state: 0 

### Output using Manhattan Heuristic in Evaluation function:
Welcome to the eight puzzle problem! In this puzzle you slide a number tile to the blank space (represented by 0). <br>
Would you like the path to be calculated with the Misplaced Tiles heuristic? If not, the Manhattan Distance heuristic will be used. (yes/no)?:
n
Using Manhattan Distance Heuristics <br>
We want to reach from this initial state: <br>
[2, 8, 3] <br>
[1, 6, 4] <br>
[7, 0, 5] 

To this goal state: <br>
[1, 2, 3] <br>
[8, 0, 4] <br>
[7, 6, 5] 

Below you will see the path from the initial state to the goal. The state and the result of the evaluation function is displayed at each step. <br>
state: <br>
[2, 8, 3] <br>
[1, 6, 4] <br>
[7, 0, 5] <br>
f for this state: 5 <br>
g for this state: 0 <br>
h for this state: 5

state: <br>
[2, 8, 3] <br>
[1, 0, 4] <br>
[7, 6, 5] <br>
f for this state: 4 <br>
g for this state: 1 <br>
h for this state: 3

state:
[2, 0, 3] <br>
[1, 8, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 2 <br>
h for this state: 3

state: <br>
[0, 2, 3] <br>
[1, 8, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 3 <br>
h for this state: 2

state: <br>
[1, 2, 3] <br>
[0, 8, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 4 <br>
h for this state: 1 

state: <br>
[1, 2, 3] <br>
[8, 0, 4] <br>
[7, 6, 5] <br>
f for this state: 5 <br>
g for this state: 5 <br>
h for this state: 0

