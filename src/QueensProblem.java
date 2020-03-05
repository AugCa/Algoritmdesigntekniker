import java.util.ArrayList;

public class QueensProblem {

    private int[] queens = new int[8];
    private ArrayList<String> solutions = new ArrayList<>();

    public void run(){
        placeQueens(0);
        for(String solution : solutions){
            System.out.print(solution);
        }
    }


    public void placeQueens(int rowIndex){
        for(int column = 0; column < 8; column++){
            if(canPlace(column, rowIndex )) {
                queens[rowIndex] = column;
                if (rowIndex == 7) //Alla drottningar är utplacerade
                    solutions.add(buildSolution(queens)); //Lägg till lösning
                else
                    placeQueens(rowIndex + 1);
            }
        }
    }



    public boolean canPlace(int column, int rowIndex){
        int tried = 0;
        while(tried < rowIndex){
            if(queens[tried] == column) return false; //Finns dam på samma kolumn
            if((tried - rowIndex) == (queens[tried] - column)) return false; //Finns dam på samma rad
            if((tried - rowIndex) == (column - queens[tried])) return false; //Finns dam diagonalt
            tried++;
        }
        return true;
    }



    public String buildSolution(int[] queens){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                builder.append((queens[i] == j) ? " ♕ " :  " - ");
            }
            builder.append("\n");
        }
        builder.append("\n");
        return builder.toString();
    }


}
