import java.util.*;


public class Astar{
    private PriorityQueue<Puzzle> fringe;
    private Map<Puzzle, Puzzle> visited;
    private Puzzle startPuz;
    private Puzzle goalPuz;
    private boolean isManhat;

    public Astar(boolean manhat){
        fringe = new PriorityQueue<>();
        // map of key: state, value: prev state
        visited = new HashMap<>();
        isManhat = manhat;
        int[][] startArray = new int[][]{
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };
        int[][] goalArray = new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };
        startPuz = new Puzzle(startArray, 0, 0);
        startPuz.setManhat(manhat);
        startPuz.calcFn();
        goalPuz = new Puzzle(goalArray, 0, 0);
    }
    public PriorityQueue<Puzzle> fringe(){return fringe;}

    public List<Puzzle> constructPath(Puzzle goal){
        List<Puzzle> path = new ArrayList<>();
        // when we find goal we call this method, this is why the current puzzle is the goal
        Puzzle current = goal;

        while(current != null){
            path.add(current);
            current = visited.get(current);  // get parent, which is a value
            // eventually the parent will be null when we reach the starting state
        }
        // we reverse list because the loop above was tracing from goal to start
        Collections.reverse(path);  // flip from goal→start to start→goal
        for(Puzzle p : path){
            p.printPuzzle();
        }
        return path;
    }

    public void aStar(){
        fringe.offer(startPuz);
        visited.put(startPuz, null);
        while(!fringe.isEmpty()){
            if(fringe.isEmpty()){throw new IllegalArgumentException(); }
            Puzzle curPuzz = fringe.poll();
            if( curPuzz.equals(goalPuz)  ){
                constructPath(curPuzz);
                break;
            }
            List<Puzzle> neighbours = curPuzz.createNeighbours();
            for(Puzzle n : neighbours){
                if(!visited.containsKey(n)){
                    fringe.offer(n);
                    visited.put(n, curPuzz);
                }
            }
        }
    }

    public void printInfo(){
        System.out.println("We want to reach from this initial state: ");
        startPuz.printStart();
        System.out.println("To this goal state: ");
        goalPuz.printStart();
        System.out.println("Below you will see the path from the initial state to the goal. The state and " +
                "the result of the evaluation function is displayed at each step.");
    }

    public static void main(String[] args) {
        // System.in tells it to listen to the keyboard/console for input
        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Welcome to the eight puzzle problem! " +
                "In this puzzle you slide a number tile to the blank space (represented by 0).");
        System.out.println("Would you like the path to be calculated with the Misplaced Tiles heuristic (yes/no)?: ");
        String input = scan.nextLine().trim().toLowerCase();
        if (input.equals("yes") || input.equals("y") || input.equals("true")) {
            Astar a = new Astar(false);
            a.printInfo();
            a.aStar();
        } else if (input.equals("no") || input.equals("n") || input.equals("false")) {
            System.out.println("Using Manhattan Distance Heuristics");
            Astar a = new Astar(true);
            a.printInfo();
            a.aStar();
        } else {
            System.out.println("Invalid input!");
        }

    }

}



