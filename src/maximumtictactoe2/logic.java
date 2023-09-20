package maximumtictactoe2;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;

public class logic extends logicabstract {

        static File winrate = new File("winrate.txt");
	    static File file4 = new File("Recordwin.txt");
		
	    public void playGame() throws IOException {

		if (!file4.exists()){
	    
		BufferedWriter filewriter = new BufferedWriter(new FileWriter("Recordwin.txt", true));
		file4.createNewFile();
		filewriter.write("---------------------------------");
		filewriter.newLine();
		filewriter.append("  Result             History     ");
		filewriter.newLine();
		filewriter.append("---------------------------------");  
		filewriter.newLine(); 
		filewriter.close();
		} 
		tictactoe.TICTACTOE(); //game logic
    }

  @Override
    public void instructGame()throws IOException{
	      System.out.println("\t INSTRUCTIONS");
	      System.out.println("------------------------------");
	      System.out.println();
	      char[][] papanpermainan = 
          {{'1','|','2','|','3'}, 
	       {'-','+','-','+','-'}, 
	       {'4','|','5','|','6'}, 
	       {'-','+','-','+','-'}, 
	       {'7','|','8','|','9'},};
   

          for(char[] row : papanpermainan) {		
	         System.out.print("\t");
	         for (char col : row) {		
		        System.out.print(col);
	         }
		     System.out.println();
          }

					
	        System.out.println();
	        System.out.println("1. There is 9 location to input your main symbol, its either 'X' or 'O' ");
	        System.out.println("2. each location can only store 1 symbol, so make sure didn't choose the same box numerous time");
	        System.out.println("3. if you can make 3 input in the box SIDE BY SIDE or CROSS EACH OTHER, then you win, you can see the example below : ");
	        System.out.println();
	        System.out.println("------------------------------");
	        System.out.println();
	        
			char[][] papanwin1 = 
            {{'X','|','X','|','X'}, 
	         {'-','+','-','+','-'}, 
	         {' ','|',' ','|',' '}, 
	         {'-','+','-','+','-'}, 
	         {' ','|',' ','|',' '}};
   
	        for(char[] row1 : papanwin1) {		
		       System.out.print("\t");
		       for(char col : row1) {		
			      System.out.print(col);
				}
		        System.out.println();
			}

	         System.out.println();
	         System.out.print("\tPlayer X is Win !");
	         System.out.println();
	         System.out.println("------------------------------");
	         System.out.println();

	         char[][] papanwin2 = 
	        {{'O','|',' ','|',' '}, 
	         {'-','+','-','+','-'},  
	         {' ','|','O','|',' '}, 
	         {'-','+','-','+','-'}, 
	         {' ','|',' ','|','O'}};

	        for(char[] row2 : papanwin2) {		
		       System.out.print("\t");
		       for(char col : row2) {		
			       System.out.print(col);
				}
		       System.out.println();
			}

	        System.out.println();
	        System.out.print("\tPlayer O is Win !");
	        System.out.println();
            System.out.println("------------------------------");

	        Scanner scanhoy = new Scanner(System.in);
		    System.out.println("press number 1 to return to the menu");
		    int input = scanhoy.nextInt();

		       while(!(input == 1)){
			        System.out.println("your input is invalid, press 1 for return to the menu");
			        input = scanhoy.nextInt();
		       }

	
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();
	    System.out.println();

        mainmenu.showMenu();
    }





 @Override
      public void history()throws IOException{
 
	  int data;
	  FileReader reader = null;

	   try {
		     reader = new FileReader("Recordwin.txt");
		     while ((data = reader.read()) != -1) {
			 System.out.print((char) data);
		     }
	   } catch (FileNotFoundException e) {

		     System.out.println();
		     System.out.println("History is empty, play a game to make one!");

	   } catch (IOException e) {
		     e.printStackTrace();

	   } finally {
	         if(reader!=null){
		     reader.close();
	         }
	   }
      
              boolean checkhistory = false;
              while(checkhistory==false){
	          try{
	                Scanner scank = new Scanner(System.in);
		            System.out.println("---------------------------------");
		            System.out.println("press 1 for check the WINRATE \npress 2 for back to Main Menu \npress 3 for DELETE history");
		            int x = scank.nextInt(); scank.nextLine();
					if(x > 0 || x < 5){
						checkhistory= true;
					}
					
		                  switch(x){
			                   case 1 : 
				                        while(!file4.exists()){
					                    System.out.println("There are no records yet, please enter other menu");
					                    System.out.println();
					                    System.out.println();
					                    history();
				                        }
				                        winrate();				  				
			                   break;
			                   case 2 :
				                        System.out.println();
				                        System.out.println();
				                        mainmenu.showMenu();
			                   break ;
			                   case 3:
			                            file4.delete();				 
			                   break;
			                   default :
			                            System.out.println("out of range");
			                            System.out.println();
			                            System.out.println();
			                            System.out.println();
			                            mainmenu.showMenu();
		                   }	
	                      System.out.println();
	                      System.out.println();
	                      System.out.println();

	                      mainmenu.showMenu();

                } catch(Exception e){
                      System.out.println("your input is wrong");
	              }
			  }
     }


	
 @Override
     public void winrate()throws IOException{
	     //menjadikan kata sebagai key dan value sebagai angka
	      Map<String, Integer> wordCounts = new HashMap<>();
	      BufferedReader br = null;
              
		     
	          try {
		            br = new BufferedReader(new FileReader(file4));
		            String line;

		            while ((line = br.readLine()) != null) {//read setiap line
			               String[] words = line.split(" ");//memisah kalimat berdasarkan "regex", karena "regex" yang kita input adalah " "(spasi) maka setiap ada spasi, maka kalimat akan di pisah (bisa baca di split)
			               for(String word : words) {
			               wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);//memilih words yang udah di split menjadi "key" dan value nya menjadi "jumlah karakter"
			               } //menaruh di words setiap kata yg di ambil lalu di store di hashmap dengan format, 1 kata dan jumlah karakterperkata, untuk value waktu di anggap 1 sekaligus
		            }	

					//setiap line yang dipisah menjadi regex masing2 akan di read dan ditulis satu persatu, lalu kalimat tersebut akan di set sebagai key, dan value nya adalah jumlah satupersatu kalimat key dibaca, yg mana valuenya pun akan bertambah +1 setiap kali key tersebut muncul/terdeteksi dalam Recordwin.txt setiap barisnya 

	            }catch (Exception e) {
		              e.printStackTrace();
	            }finally{
		                 if(br!=null){
		                 br.close();
	                     }
	            }
			
				
	 
	

	          //writer 
	          int xCount = 0;
	          int oCount = 0;
	          int tieCount = 0;
	
	          for (String word : wordCounts.keySet()) { 
		      int count = wordCounts.get(word); 
			       

		           if (word.equals("X")) {
		               xCount += count;
		           } else if (word.equals("O")) {
			           oCount += count;
		           } else if (word.equals("TIE")) {
			           tieCount += count;
		           }
	           }

	           int totalWin = xCount + oCount + tieCount;
	           double winRateX = ((double)xCount / totalWin) * 100;
	           double winRateO = ((double)oCount / totalWin) * 100;
	           int hasil1 = (int) Math.round(winRateX);
	           int hasil2 = (int) Math.round(winRateO);

	           //untuk menulis nilai win rate
	           BufferedWriter winratewrite = new BufferedWriter(new FileWriter("winrate.txt",true));
               winratewrite.newLine();
	           winratewrite.write("------------------------------");
	           winratewrite.newLine();
	           winratewrite.write("winrate X player = "+hasil1);
	           winratewrite.newLine();
	           winratewrite.write("winrate O player = "+hasil2);
	           winratewrite.newLine();
	           winratewrite.write("------------------------------");
	           winratewrite.newLine();
	           winratewrite.close();
	
	           int data2;
	           FileReader winrateread = null;
               try {
	                 winrateread = new FileReader("winrate.txt");
	                 while ((data2 = winrateread.read()) != -1) {
		                    System.out.print((char) data2);
	                 }
               }catch (FileNotFoundException k) {
	                  System.out.println("History is empty, play a game to make one!");
               } catch (IOException k) {
	                  k.printStackTrace();
               } finally {
                          if(winrate!=null){
	                      winrateread.close();
                          }
               }
                

			    boolean checkwinrate = false;
				while (checkwinrate == false){
				      try {
	        	           Scanner scanlul = new Scanner(System.in);
		                   System.out.println("Press 1 for return to main menu");
		                   int back = scanlul.nextInt();
                      
					  if(back > 0 || back < 5){
						 checkwinrate = true;
					   } 

		                switch (back) {
			                   case 1:
				                  mainmenu.showMenu();
				          break;
			                   default:
				                  System.out.println("your input is out of range!!"); 
								  winrate();
				          break;
		                }

					  }catch(Exception e){
                             System.out.println("your input is invalid");
					  }
			    }
	}

		
  @Override
     public void exit(){
	   System.exit(0);
     }	
}


	
	

