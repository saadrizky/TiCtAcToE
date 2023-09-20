package maximumtictactoe2;
import java.util.Scanner;

public class playername extends tictactoe {
       playername(String player1, String player2){
         super(player1, player2);
       }

       static Scanner scanner = new Scanner(System.in);

           protected static void displayplayername(String player1,String player2){
             
         
                    System.out.println();
                    System.out.println("Player 1 input your name");
                    String username1 = scanner.nextLine();
                    player1 = username1;
                    setPlayer1(player1);
                    
                    if(player1 != null && player1 != ""){
                       System.out.println();
                       System.out.println("Player 2 input your name");
                       String username2 = scanner.nextLine();
                       player2 = username2;
                       setPlayer2(player2);
                   
                    }
          }

           //overloaded method
         protected static void displayplayername(String Player1){
             
                System.out.println();
                System.out.println("Player 1 input your name");
                String username1 = scanner.nextLine();
                player1 = username1;
                setPlayer1(player1);
                
        }
      
}


