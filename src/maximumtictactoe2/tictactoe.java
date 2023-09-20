package maximumtictactoe2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;
import java.io.FileWriter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class tictactoe extends printpapan {
   int haha;

   private static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
   private static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
   protected static String player1;
   protected static String player2;

   // Constructor
   public tictactoe(ArrayList<Integer> playerPost, ArrayList<Integer> cpuPost) {
      playerPosition = playerPost;
      cpuPosition = cpuPost; // tictactoe. sama kaya this. cuman versi static

   }

   // Overloaded Constructor
   public tictactoe(String player1, String player2) {
      tictactoe.player1 = player1;
      tictactoe.player2 = player2;
   }

   // getter array list
   public static ArrayList<Integer> getplayerPosition() {
      return playerPosition;
   }

   public static ArrayList<Integer> getcpuPosition() {
      return cpuPosition;
   }

   // getter player name
   public static String getPlayer1() {
      return player1;
   }

   public static String getPlayer2() {
      return player2;
   }

   // set playername
   public static void setPlayer1(String player1) {
      tictactoe.player1 = player1;
   }

   public static void setPlayer2(String player2) {
      tictactoe.player2 = player2;
   }

   // LOGIKA INTI
   public static void TICTACTOE() throws IOException {
      setPlayer1(null);
      setPlayer2(null);
      char[][] papanpermainan = { { ' ', '|', ' ', '|', ' ' },
            { '-', '+', '-', '+', '-' },
            { ' ', '|', ' ', '|', ' ' },
            { '-', '+', '-', '+', '-' },
            { ' ', '|', ' ', '|', ' ' } };

      System.out.println("Lawan CPU atau player? \n(0 for CPU and 1 for player)");

      boolean checkenemy = false;
      while (checkenemy == false) {

         try {

            Scanner scan = new Scanner(System.in);
            int musuh = scan.nextInt();

            boolean currentPlayer = Math.random() <= 0.5; // menentukan giliran pertama
            // ini bila ada player yang
            if (musuh == 1) {
               playername.displayplayername(getPlayer1(), getPlayer2());
            } else {
               playername.displayplayername(getPlayer1());
            }
            printpapanpermainan(papanpermainan);

            while (true) {
               if (musuh != 0 || musuh != 1) {
                  checkenemy = true;
               }
               if (currentPlayer) {
                  // 'Scanner' = to convert bytes from input stream into characters
                  Scanner scan2 = new Scanner(System.in);
                  System.out.println(player1 + " pilih posisi (1-9) : ");

                  try {
                     int playerPos = scan2.nextInt();
                     while (playerPos > 9 || playerPos < 1) {
                        System.out.println("posisi salah, masukkan posisi 1-9 :");
                        playerPos = scan2.nextInt();
                     }
                     while (playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)) {
                        System.out.println("posisi telah diambil, masukkan posisi baru !");
                        playerPos = scan2.nextInt();
                     }

                     placepiece.PLACEPIECE(papanpermainan, playerPos, "player");
                     playerPosition.add(playerPos);
                     System.out.println();
                     printpapan.printpapanpermainan(papanpermainan);
                     CEKPEMENANG(papanpermainan, playerPosition, cpuPosition);
                     currentPlayer = !currentPlayer;

                  } catch (InputMismatchException e) {
                     System.out.println("anda memasukkan input yang kurang tepat!, coba lagi");
                  }

               } else if (musuh == 0) { // kalau nilai cirrent player tidak mereturn true, dan nilai scan "musuh" == 0

                  System.out.println(" giliran CPU !");
                  System.out.println();
                  Random rand = new Random();
                  int CPUpos = rand.nextInt(9) + 1;

                  while (playerPosition.contains(CPUpos) || cpuPosition.contains(CPUpos)) {
                     CPUpos = rand.nextInt(9) + 1;
                  }

                  maximumtictactoe2.placepiece.PLACEPIECE(papanpermainan, CPUpos, "CPU");
                  cpuPosition.add(CPUpos);
                  System.out.println();
                  printpapan.printpapanpermainan(papanpermainan);
                  CEKPEMENANG(papanpermainan, playerPosition, cpuPosition);
                  currentPlayer = !currentPlayer;

               } else {
                  Scanner scan3 = new Scanner(System.in);
                  System.out.println(player2 + " pilih posisi (1-9): ");

                  try {
                     int player2pos = scan3.nextInt();

                     while (player2pos > 9 || player2pos < 1) {
                        System.out.println("posisi salah, masukkan posisi 1-9");
                        player2pos = scan3.nextInt();
                     }

                     while (playerPosition.contains(player2pos) || cpuPosition.contains(player2pos)) {
                        System.out.println("posisi telah diambil, masukkan posisi baru !");
                        player2pos = scan3.nextInt();
                     }

                     placepiece.PLACEPIECE(papanpermainan, player2pos, "CPU");
                     cpuPosition.add(player2pos);
                     System.out.println();
                     printpapan.printpapanpermainan(papanpermainan);
                     CEKPEMENANG(papanpermainan, playerPosition, cpuPosition);
                     currentPlayer = !currentPlayer;

                  } catch (InputMismatchException e) {
                     System.out.println("input yang anda masukkan salah!");
                  }

               }

            }

         } catch (InputMismatchException e) {
            System.out.println("input yang anda masukkan salah!");
         }
      }
   }

   // cek winner
   public static void CEKPEMENANG(char[][] papanpermainan, ArrayList<Integer> playerPosition,
         ArrayList<Integer> cpuPosition) throws IOException {
      BufferedWriter filewriter = new BufferedWriter(new FileWriter("Recordwin.txt", true));

      List<Integer> topRow = Arrays.asList(1, 2, 3); // kalau ArrayList playerPosition() nya berisi 1,2,3 maka akan
                                                     // menang
      List<Integer> midRow = Arrays.asList(4, 5, 6);
      List<Integer> botRow = Arrays.asList(7, 8, 9);
      List<Integer> leftCol = Arrays.asList(1, 4, 7);
      List<Integer> midCol = Arrays.asList(2, 5, 8);
      List<Integer> rightCol = Arrays.asList(3, 6, 9);
      List<Integer> cross1 = Arrays.asList(1, 5, 9);
      List<Integer> cross2 = Arrays.asList(7, 5, 3);

      List<List<Integer>> kondisimenang = Arrays.asList(topRow, midRow, botRow,
            leftCol, midCol, rightCol,
            cross1, cross2);

      // declare untuk input tanggal
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      String formattedDate = now.format(formatter);

      // check who win
      for (List<Integer> list : kondisimenang) {

         if (playerPosition.containsAll(list)) {
            System.out.println("SELAMAT " + player1 + " MENANGG !!");
            filewriter.write("X win" + "         " + formattedDate);
            filewriter.newLine();
            filewriter.close();
            mainlagi.MAINLAGI();

         } else if (cpuPosition.containsAll(list)) {
            System.out.println("SELAMAT " + player2 + " MENANGG !!");
            filewriter.write("O win" + "         " + formattedDate);
            filewriter.newLine();
            filewriter.close();
            mainlagi.MAINLAGI();
         }
      }
      if (playerPosition.size() + cpuPosition.size() == 9) {
         System.out.println("RONDE SERI !!");
         filewriter.write("TIE game" + "      " + formattedDate);
         filewriter.newLine();
         filewriter.close();
         mainlagi.MAINLAGI();
      }
      filewriter.close();
   }
}