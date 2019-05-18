package HW.XOgame;


public class XOgameMods {

    //Player vs Player game mode
    public static void playerVsPlayer (){
        char [] [] arr = new char [3][3];

        //Fill array with empty spaces
        System.out.println("Let's play a game: ");
        XOgameMethods.createEmptyArray(arr);
        XOgameMethods.printTheArray(arr);

        //Assign marks for Players
        System.out.println("Player 1 has mark X");
        System.out.println("Player 2 has mark 0");
        char firstUserMark = 'X';
        char secondUserMark = '0';
        int i = 1;
        while(true) {
            //Check for draw
            if (XOgameMethods.drawCondition(arr)){
                System.out.println("Draw!");
                break;
            }

            //Ask user to provide place for his mark
            System.out.println("Player " + i + ": ");

            //Ask user to provide row
            System.out.println("Please select ROW from 1 to 3: ");
            int rowUserChoice = XOgameMethods.validateUserInput();

            //Ask user to provide column
            System.out.println("Please select COLUMN from 1 to 3: ");
            int columnUser1Choice = XOgameMethods.validateUserInput();

            //Assign user mark to chosen location in the matrix. Print out the matrix
            if (arr[rowUserChoice][columnUser1Choice] == '_' && i == 1) {
                arr[rowUserChoice][columnUser1Choice] = firstUserMark;
                XOgameMethods.printTheArray(arr);
                i = 2;
            } else if (arr[rowUserChoice][columnUser1Choice] == '_' && i == 2) {
                arr[rowUserChoice][columnUser1Choice] = secondUserMark;
                XOgameMethods.printTheArray(arr);
                i = 1;
            } else {
                System.out.println("It is already a mark at that place. Please choose another one");
            }

            //Check for win condition
            if (XOgameMethods.winCondition(arr) && i == 1) {
                System.out.println("Player 2 won! Grats!");
                break;
            }
            if (XOgameMethods.winCondition(arr) && i == 2) {
                System.out.println("Player 1 won! Grats!");
                break;
            }

        }
    }

    //Player vs. Computer game mode
    public static void playerVsComputer (int difficulty){

        char [] [] arr = new char [3][3];

        //Fill array with empty spaces
        System.out.println("Let's play a game: ");
        XOgameMethods.createEmptyArray(arr);
        XOgameMethods.printTheArray(arr);

        //If game mode is easy
        if (difficulty == 1) {

            //Assign marks for Player and Computer
            System.out.println("Player has mark X");
            System.out.println("Computer has mark 0");
            char userMark = 'X';
            char computerMark = '0';

            int i = 1;
            while (true) {
                if (i==1){
                    //Check for draw
                    if (XOgameMethods.drawCondition(arr)){
                        System.out.println("Draw!");
                        break;
                    }

                    //Ask user to provide column to chose the place for his mark
                    System.out.println("Player: ");
                    System.out.println("Please select ROW from 1 to 3: ");
                    int rowUserChoice = XOgameMethods.validateUserInput();

                    //Ask user to provide column to chose the place for his mark
                    System.out.println("Please select COLUMN from 1 to 3: ");
                    int columnUserChoice = XOgameMethods.validateUserInput();

                    //Assign user mark to chosen location in the matrix. Print out the matrix
                    if (arr[rowUserChoice][columnUserChoice] != '_') {
                        System.out.println("It is already a mark at that place. Please choose another one");
                    } else {
                        arr[rowUserChoice][columnUserChoice] = userMark;
                        XOgameMethods.printTheArray(arr);
                        i = 2;
                    }

                    //Check for win condition for Player
                    if (XOgameMethods.winCondition(arr)) {
                        System.out.println("Player won! Grats!");
                        break;
                    }
                }

                if (i==2){
                    //Check for draw
                    if (XOgameMethods.drawCondition(arr)){
                        System.out.println("Draw!");
                        break;
                    }

                    //Choose place for computer mark
                    int rowComputerMark = XOgameMethods.gererateCopmuterChoiceRow(3, 0);
                    int columnComputerMark = XOgameMethods.gererateCopmuterChoiceColumn(3, 0);
                    if (arr[rowComputerMark][columnComputerMark] != '_') {
                        rowComputerMark = XOgameMethods.gererateCopmuterChoiceRow(3, 0);
                        columnComputerMark = XOgameMethods.gererateCopmuterChoiceColumn(3, 0);
                    }
                    else {
                        System.out.println("It's a computer turn:");
                        arr[rowComputerMark][columnComputerMark] = computerMark;
                        XOgameMethods.printTheArray(arr);
                        i = 1;
                    }
                    //Check for win condition for Computer
                    if (XOgameMethods.winCondition(arr)) {
                        System.out.println("Looser! Computer has won!");
                        break;
                    }
                }
            }
        }
        if (difficulty ==2){

            //Assign marks for Player and Computer
            System.out.println("Player has mark 0");
            System.out.println("Computer has mark X");
            char userMark = '0';
            char computerMark = 'X';

            int i = 1;
            int turnCount =1;
            while (true) {
                if (i==1){
                    //Check for draw
                    if (XOgameMethods.drawCondition(arr)){
                        System.out.println("Draw!");
                        break;
                    }

                    //Place computer mark
                    System.out.println("It's a computers turn " + turnCount + " :");
                    XOgameMethods.computerTurnHard(arr, turnCount, computerMark);
                    XOgameMethods.printTheArray(arr);
                    turnCount ++;
                    i=2;

                    //Check for win condition for Computer
                    if (XOgameMethods.winCondition(arr)) {
                        System.out.println("Looser! Computer has won!");
                        break;
                    }
                }

                if (i==2){
                    //Check for draw
                    if (XOgameMethods.drawCondition(arr)){
                        System.out.println("Draw!");
                        break;
                    }

                    //Ask user to provide column to chose the place for his mark
                    System.out.println("Player: ");
                    System.out.println("Please select ROW from 1 to 3: ");
                    int rowUserChoice = XOgameMethods.validateUserInput();

                    //Ask user to provide column to chose the place for his mark
                    System.out.println("Please select COLUMN from 1 to 3: ");
                    int columnUserChoice = XOgameMethods.validateUserInput();

                    //Assign user mark to chosen location in the matrix. Print out the matrix
                    if (arr[rowUserChoice][columnUserChoice] != '_') {
                        System.out.println("It is already a mark at that place. Please choose another one");
                    } else {
                        arr[rowUserChoice][columnUserChoice] = userMark;
                        XOgameMethods.printTheArray(arr);
                        i = 1;
                    }

                    //Check for win condition for Player
                    if (XOgameMethods.winCondition(arr)) {
                        System.out.println("Player won! Grats!");
                        break;
                    }
                }
            }
        }
    }

    public static void computerVsComputer () {

        char[][] arr = new char[3][3];

        //Fill array with empty spaces
        System.out.println("Let's play a game: ");
        XOgameMethods.createEmptyArray(arr);
        XOgameMethods.printTheArray(arr);

        //Assign mark to Computer 1 and Computer 2
        System.out.println("Player has mark 0");
        System.out.println("Computer has mark X");
        char computer1mark = 'X';
        char computer2mark = '0';
        int i = 1;
        while (true) {
            if (i == 1) {
                //Check for draw
                if (XOgameMethods.drawCondition(arr)) {
                    System.out.println("Draw!");
                    break;
                }

                //Choose place for computer mark
                int rowComputerMark = XOgameMethods.gererateCopmuterChoiceRow(3, 0);
                int columnComputerMark = XOgameMethods.gererateCopmuterChoiceColumn(3, 0);
                if (arr[rowComputerMark][columnComputerMark] != '_') {
                    rowComputerMark = XOgameMethods.gererateCopmuterChoiceRow(3, 0);
                    columnComputerMark = XOgameMethods.gererateCopmuterChoiceColumn(3, 0);
                } else {
                    System.out.println("It's a Computer 1 turn:");
                    arr[rowComputerMark][columnComputerMark] = computer1mark;
                    XOgameMethods.printTheArray(arr);
                    i = 2;
                }
                //Check for win condition for Computer
                if (XOgameMethods.winCondition(arr)) {
                    System.out.println("Computer 1 has won!");
                    break;
                }
            }
            if (i == 2) {
                //Check for draw
                if (XOgameMethods.drawCondition(arr)) {
                    System.out.println("Draw!");
                    break;
                }

                //Choose place for computer mark
                int rowComputerMark = XOgameMethods.gererateCopmuterChoiceRow(3, 0);
                int columnComputerMark = XOgameMethods.gererateCopmuterChoiceColumn(3, 0);
                if (arr[rowComputerMark][columnComputerMark] != '_') {
                    rowComputerMark = XOgameMethods.gererateCopmuterChoiceRow(3, 0);
                    columnComputerMark = XOgameMethods.gererateCopmuterChoiceColumn(3, 0);
                } else {
                    System.out.println("It's a Computer 2 turn:");
                    arr[rowComputerMark][columnComputerMark] = computer2mark;
                    XOgameMethods.printTheArray(arr);
                    i = 1;
                }
                //Check for win condition for Computer
                if (XOgameMethods.winCondition(arr)) {
                    System.out.println("Computer 2 has won!");
                    break;
                }
            }
        }
    }
}

