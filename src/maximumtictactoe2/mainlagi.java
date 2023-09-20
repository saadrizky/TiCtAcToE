package maximumtictactoe2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;  




public class mainlagi extends tictactoe {
         //construct
         public mainlagi(ArrayList<Integer> playerPosition,ArrayList<Integer> cpuPosition){
               super(playerPosition,cpuPosition);
         }
 
         public static void MAINLAGI()throws IOException{
              System.out.println("Apakah anda ingin bermain lagi (y/n) ?");
              Scanner ans = new Scanner(System.in);
              String answer = ans.nextLine().toLowerCase();
         
              if(answer.contains("y")){

                  getplayerPosition().clear();
                  getcpuPosition().clear();
                  tictactoe.TICTACTOE();

              }else if(answer.contains("n")){

                  System.out.println();
                  getplayerPosition().clear();
                  getcpuPosition().clear();   
                  mainmenu.showMenu();

              } else {
                     System.out.println("your input is wrong"); 

                     while(true){
                     System.out.println("please input y/n !");
                     answer = ans.nextLine().toLowerCase();
                         if(answer.equals("y") || answer.equals("n")){
                             break;
                         }
                     }
                        if(answer.contains("y")){

                        getplayerPosition().clear();
                        getcpuPosition().clear(); 
                        tictactoe.TICTACTOE();

                         } else if(answer.contains("n")){

                            System.out.println();
                            getplayerPosition().clear();
                            getcpuPosition().clear();   
                            mainmenu.showMenu();
                         }
              }
          }
}
