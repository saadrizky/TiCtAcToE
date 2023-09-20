package maximumtictactoe2;

public class placepiece {
    public static void PLACEPIECE(char[][] papanpermainan, int playerpos, String user){

        char turn = ' ';


        if(user.equals("player")){
            turn = 'X';
        } else if(user.equals("CPU")){
            turn = 'O'; 
        }

        switch(playerpos) {
			case 1: 
					papanpermainan[0][0] = turn;
				break;
			case 2: 
                    papanpermainan[0][2] = turn;
				break;
			case 3:  
                    papanpermainan[0][4] = turn;
				break;
			case 4:  
                    papanpermainan[2][0] = turn;
				break;
			case 5:  
                    papanpermainan[2][2] = turn;
				break;
			case 6:  
                    papanpermainan[2][4] = turn;
				break;
			case 7:   
                    papanpermainan[4][0] = turn;
				break;
			case 8:   
                    papanpermainan[4][2] = turn;
				break;
			case 9:  
                    papanpermainan[4][4] = turn;
				break;
		}
    }
}
