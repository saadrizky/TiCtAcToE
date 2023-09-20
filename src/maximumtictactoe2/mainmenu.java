package maximumtictactoe2;

import java.util.Scanner;
import java.io.IOException;
import javax.sound.sampled.*;
import java.io.File;

public class mainmenu {

      static logic logika = new logic();
      static mainmenu mainmenu = new mainmenu(); // untuk mengakses tictactoe
      static File file2 = new File("tictactoe.wav");
      static File file3 = new File("winrate.txt");

      // MAIN METHOD
      public static void main(String[] args)
                  throws UnsupportedAudioFileException, IOException, LineUnavailableException {

            javax.sound.sampled.AudioInputStream audio = AudioSystem.getAudioInputStream(file2);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            showMenu();
      }

      public static void showMenu() throws IOException {
            file3.delete();
            System.out.println();
            System.out.println();
            System.out.println("   SELAMAT BERMAIN !!!  ");
            System.out.println("+----------------------+");
            System.out.println("|    Tictactoe Games   |");
            System.out.println("+----------------------+");
            System.out.println("|1. Play               |");
            System.out.println("|2. Instructions       |");
            System.out.println("|3. History            |");
            System.out.println("|4. Exit               |");
            System.out.println("+----------------------+");
            System.out.println();

            System.out.print("+---------------------+\n| Choose the option : | ");

            boolean checkoption = false;
            while (checkoption == false) {
                  try {

                        Scanner scannerbaru1 = new Scanner(System.in);
                        int option = scannerbaru1.nextInt();
                        System.out.println("| You have chosen " + option + "   |");
                        System.out.println("+---------------------+");
                        System.out.println();

                        if (option > 0 || option < 5) {
                              checkoption = true;
                        }

                        switch (option) {
                              case 1:
                                    logika.playGame();
                                    break;
                              case 2:
                                    logika.instructGame();
                                    break;
                              case 3:
                                    logika.history();
                                    break;
                              case 4:
                                    logika.exit();
                                    break;
                              default:
                                    System.out.println("Incorrect menu option");
                                    showMenu();
                                    break;
                        }
                  } catch (Exception e) {
                        System.out.println("please enter a number");
                  }
            }
            System.out.println();
      }

}
