import java.util.*;

public class Puzzle implements Comparable<Puzzle>{
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

    /** internal structure of class */
    @Override
    public int compareTo(Puzzle other){ // for comparable function
        return Integer.compare(this.fn, other.fn); // comparing fn
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Puzzle)) return false;
        Puzzle other = (Puzzle) o;
        return Arrays.deepEquals(this.puz, other.puz); // checking that both the puzzle grids are equal
    }

    @Override
    public int hashCode(){
        return Arrays.deepHashCode(puz);
    }
    
    /** Getters and Setters */
    public int[][] puz(){return puz;}
    public int[][] goalPuz(){return goalPuz;}
    public int hn(){ return hn;}
    public int gn(){ return gn;}
    public int fn(){ return fn;}

    /** Print methods */
    public void printPuzzle(){
        System.out.println("state:");
        for(int[] row : puz){
            System.out.println(Arrays.toString(row));
        }
        System.out.println("fn for this state: " + fn);
        System.out.println("gn for this state: " + gn);
        System.out.println("hn for this state: " + hn);
        System.out.println(" ");
    }

    public void printStart(){
        for(int[] row : puz){
            System.out.println(Arrays.toString(row));
        }
        System.out.println(" ");
    }

    public void printNeighbours(){
        List<int[]> neighbours = findNeighbours();
        System.out.println("number of neighbours: " + neighbours.size());
        for (int[] neigh : neighbours) {
            int row = neigh[0];
            int col = neigh[1];
            System.out.println("neighbour: " + puz[row][col]);
        }
    }

    /** Neighbour search and puzzle movement */
    public Puzzle move(int neighRow, int neighCol, int neighbour){
        int[][] newGrid = new int[3][3];
        for(int i = 0; i < 3; i++) // deep copy of the current puzzle
            newGrid[i] = Arrays.copyOf(puz[i], puz[i].length);

        int row = findZeroRow();
        int col = findZeroCol();
        newGrid[row][col] = neighbour;
        newGrid[neighRow][neighCol] = 0;

        int newGn = gn + 1; // adding incremented gn to new state
        Puzzle newPuz = new Puzzle(newGrid, newGn, 0);
        newPuz.fn = newPuz.calcFn();
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
    /** creates puzzle objects for the neighbours */
    public List<Puzzle> createNeighbours() {
        List<int[]> neighbours = findNeighbours();
        List<Puzzle> nPuzzles = new ArrayList<>();
        for(int[] pair : neighbours){
            int row = pair[0];
            int col = pair[1];
            Puzzle p = move(pair[0], pair[1], puz[row][col]);
            nPuzzles.add(p);
        }
        return nPuzzles;
    }
    /** Evaluation function for A star */
    public int calcHn(){
        int tempHn = 0;
        // calculate misplaced tiles between current puzzle and goal
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if( (goalPuz[row][col] != puz[row][col]) && (puz[row][col] != 0)){
                    tempHn++;
                }
            }
        }
        // hn = tempHn;
        return tempHn;
    }

    public int calcFn(){
        this.hn = calcHn();       // recalculate hn fresh
        this.fn = this.hn + this.gn;
        return fn;
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
                if((goal[row][col] != start[row][col]) && (start[row][col] != 0)) tempHn++;
            }
        }
        return tempHn;
    }
}

