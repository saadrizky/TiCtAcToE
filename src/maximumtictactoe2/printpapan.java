package maximumtictactoe2;

public class printpapan {
   
        protected static void printpapanpermainan(char[][] papanpermainan){
             for(char[] row : papanpermainan) {		
             System.out.print("\t");
             for(char col : row) {		
             System.out.print(col);    
             }
         System.out.println();    
        } 
      System.out.println("\n--------------------");
    }
}
