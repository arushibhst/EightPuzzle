import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Astar{
    private PriorityQueue<Puzzle> fringe;
    private Map<Puzzle, Puzzle> visited;
    private Puzzle startPuz;

    public Astar(){
        fringe = new PriorityQueue<>();
        visited = new HashMap<>();
        int[][] startArray = new int[][]{
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };
        startPuz = new Puzzle(startArray, 0, Puzzle.calcHnStart());
    }
    public PriorityQueue<Puzzle> fringe(){return fringe;}
    public Map<Puzzle, Puzzle> visited(){return visited;}
    public Puzzle startPuz(){return startPuz;}


    public void aStar(){
        fringe.offer(startPuz);
        while(!fringe.isEmpty()){
            if(fringe.isEmpty()){throw new IllegalArgumentException(); }
            Puzzle curPuzz = fringe.poll();
            if( (curPuzz.puz()).equals(curPuzz.goalPuz())  ){
                visited();
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };
        Puzzle puz = new Puzzle(grid, 0, Puzzle.calcHnStart());
        puz.calcFn();

    }

}



