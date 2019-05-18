package HW.XOgame;



public class XOgame {
    public static void main(String[] args) {


        //Select game mode;
        System.out.println("Please select game mode: ");
        System.out.println("Player vs. Player: Press 1");
        System.out.println("Player vs. Computer: Press 2");
        System.out.println("Computer vs. Computer: Press 3");

        int userGameModeChoice = XOgameMethods.validateInputMenu(1,3);

        //Create new game depending on the mode
        switch (userGameModeChoice){
            case 1:{
                XOgameMods.playerVsPlayer();
                break;
            }
            case 2:{
                System.out.println("Please select difficulty");
                System.out.println("Easy: Press 1");
                System.out.println("Hard: Press 2");
                int gameDifficulty = XOgameMethods.validateInputMenu(1,2);
                XOgameMods.playerVsComputer(gameDifficulty);
                break;
            }
            case 3: {
                XOgameMods.computerVsComputer();
                break;
            }
        }
    }
}
