import java.util.*;

public class Puzzle{
    private int[][] puz;

    public Puzzle(){
        puz = new int[][]{
                {2, 8, 3},
                {1, 6, 4},
                {7, 0, 5}
        };
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
    public void printPuzzle(){
        for(int[] row : puz){
            System.out.println(Arrays.toString(row));
        }
    }
    public void printNeighbours(){
        List<int[]> neighbours = findNeighbours();
        System.out.println("neighbour size: " + neighbours.size());
        for (int[] neigh : neighbours) {
            int row = neigh[0];
            int col = neigh[1];
            System.out.println("neighbour: " + puz[row][col]);
        }
    }

    public static void main(String[] args) {
        Puzzle puz = new Puzzle();
        puz.printPuzzle();
        puz.findNeighbours();
        puz.printNeighbours();
    }
}

