import java.util.*;

public class Puzzle{
    private int[][] puz;
    private int[][] goalPuz;
    int gn;
    int hn;
    int fn;

    public Puzzle(int[][] grid, int gn, int hn){
        this.goalPuz = new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };
        this.puz = grid;
        this.gn = gn;
        this.hn = hn;
        this.fn = gn + hn;
    }
    
    /** Getters and Setters */
    public int[][] puz(){return puz;}
    public int[][] goalPuz(){return goalPuz;}
    public int hn(){ return hn;}
    public int gn(){ return gn;}
    public int fn(){ return fn;}
    public void printPuzzle(){
        for(int[] row : puz){
            System.out.println(Arrays.toString(row));
        }
    }

    /** Print methods */
    public void printNeighbours(){
        List<int[]> neighbours = findNeighbours();
        System.out.println("neighbour size: " + neighbours.size());
        for (int[] neigh : neighbours) {
            int row = neigh[0];
            int col = neigh[1];
            System.out.println("neighbour: " + puz[row][col]);
        }
    }

    /** Neighbour search and puzzle movement */
    public Puzzle move(int neighRow, int neighCol, int neighbour){
        int row = findZeroRow();
        int col = findZeroCol();
        Puzzle newPuz = new Puzzle(puz, 0, 0);
        int[][] currPuz = newPuz.puz();
        currPuz[row][col] = neighbour;
        currPuz[neighRow][neighCol] = 0;
        calcGn();
        return newPuz;
    }
    public int findZeroRow(){
        if(puz == null || puz.length == 0){throw new IllegalArgumentException();}
        int found = 10;
        first: for(int row = 0; row<puz.length; row++){
            found = row;
            second: for(int col = 0; col<puz[row].length; col++){
                if(puz[row][col] == 0){ break first;}
            }
        }
        return found;
    }
    public int findZeroCol(){
        if(puz == null || puz.length == 0){throw new IllegalArgumentException();}
        int found = 10;
        first: for(int[] row : puz){
            second: for(int col = 0; col<row.length; col++){
                if(row[col] == 0){ found = col; break first;}
            }
        }
        return found;
    }
    /** returns the position of the neighbours in the puzzle */
    public List<int[]> findNeighbours() {
        List<int[]> neighbours = new ArrayList<>();
        int row = findZeroRow();
        int col = findZeroCol();
        if (row > 2 || col > 2) { throw new IllegalArgumentException(); }
        if (row - 1 >= 0) neighbours.add(new int[]{row - 1, col});   // up
        if (col + 1 < 3)  neighbours.add(new int[]{row, col + 1});   // right
        if (row + 1 < 3)  neighbours.add(new int[]{row + 1, col});   // down
        if (col - 1 >= 0) neighbours.add(new int[]{row, col - 1});   // left
        return neighbours;
    }
    /** Evaluation function for A star */
    public int calcGn(){
        gn++;
        return gn;
    }
    public int calcHn(){
        int tempHn = 0;
        // calculate misplaced tiles between current puzzle and goal
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(goalPuz[row][col] == puz[row][col]) tempHn++;
            }
        }
        return tempHn;
    }

    public int calcFn(){
        System.out.println("gn: " + gn);
        System.out.println("hn: " + hn);
        System.out.println("fn: " + fn);
        return hn + gn;
    }

    public static int calcHnStart(){
        int tempHn = 0;
        int[][] start = new int[][]{
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };
        int[][] goal = new int[][]{
                {1, 2, 3},
                {8, 0, 4},
                {7, 6, 5}
        };
        // calculate misplaced tiles between current puzzle and goal
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(goal[row][col] != start[row][col]) tempHn++;
            }
        }
        return tempHn;
    }
}

