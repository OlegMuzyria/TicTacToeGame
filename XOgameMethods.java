package HW.XOgame;

import java.util.Scanner;

public class XOgameMethods {
    //Fill array with empty spaces and print it out
    public static void createEmptyArray (char [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = '_';
            }
        }
    }

    //Print out the array
    public static void printTheArray (char [][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    //Validation of the user input and return 1, 2 or 3
    static public int validateUserInput (){
        int userInput;
        while (true){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input ==1){
                    userInput = 0;
                    break;
                }
                if (input ==2){
                    userInput =1;
                    break;
                }
                if (input ==3){
                    userInput =2;
                    break;
                }
                else {
                    System.out.println("Only numbers 1, 2 and 3 are allowed");
                }
            }
            else System.out.println("Only numbers 1, 2 and 3 are allowed");
        }
        return userInput;
    }

    //Validate user input and return value in range [a,b]
    static public int validateInputMenu (int a, int b){
        int userInput =0;
        while (true){
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input>=a && input<=b){
                    userInput = input;
                }
                break;
            }
            else System.out.println("Only numbers 1, 2 and 3 are allowed");
        }
        return userInput;
    }

    //Check Win conditions
    static public boolean winCondition (char [][] arr) {
        //boolean  threeCharsSame = true;

        //Check rows
        for (int i = 0; i < arr.length; i++) {

            char firstChar = arr[i][0];
            if (firstChar == '_')continue;
            boolean  threeCharsSame = true;
            for (int j=1; j<arr[i].length; j++){
                if (arr[i][j] != firstChar){
                    threeCharsSame = false;
                    break;
                }
            }
            if (threeCharsSame) return true;
        }

        //Check columns
        for (int i = 0; i < arr.length; i++) {

            char firstChar = arr[0][i];
            if (firstChar == '_')continue;
            boolean  threeCharsSame = true;
            for (int j=1; j<arr.length; j++){
                if (arr[j][i] != firstChar){
                    threeCharsSame = false;
                    break;
                }
            }
            if(threeCharsSame) return true;
        }

        //Check first diagonal (from left to right)
        char firstCharDiagonal1 = arr[0][0];
        if (firstCharDiagonal1 != '_') {
            boolean threeCharsSame = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][i] != firstCharDiagonal1) {
                    threeCharsSame = false;
                    break;
                }
            }

            if (threeCharsSame) return true;
        }

        //Check second diagonal (from right to left)
        char firstCharDiagonal2 = arr[0][arr.length-1];
        if (firstCharDiagonal2 != '_') {
            boolean threeCharsSame = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i][arr.length-i-1] != firstCharDiagonal2) {
                    threeCharsSame = false;
                    break;
                }
            }

            if (threeCharsSame) return true;
        }

        return false;
    }

    //Generate computer choice for row. Easy mode
    public static int gererateCopmuterChoiceRow(int a, int b){
        int computerRow = (int) (Math.random()*a + b);

        return computerRow;
    }

    //Generate computer choice for column. Easy mode
    public static int gererateCopmuterChoiceColumn(int a, int b){
        int computerColumn = (int) (Math.random()*a + b);
        return computerColumn;
    }

    //Check for draw
    public static boolean drawCondition (char [][] arr){
        int noPlaceForMark = 0;
        for (int i =0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                if (arr[i][j] != '_'){
                    noPlaceForMark ++;
                    if (noPlaceForMark ==9){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Generate computer input
    public static void computerTurnHard (char [][] arr, int turnCount, char computerMark) {

        //1st turn: Place mark in the corner
        if (turnCount == 1) {
            arr[2][0] = computerMark;
            return;
        }

        //2nd turn:
        //1st scenario
        if (turnCount == 2 && arr[1][1] == '0'){
            arr[0][2] =  computerMark;
            return;
        }
        //2nd scenario
        if (turnCount == 2 && arr[1][1] != '0') {
            if (arr[0][0] == '_' && arr[1][0] == '_'){
                arr[0][0] = computerMark;
                return;
            }
            else {
                arr[2][2] = computerMark;
            }
        }

        //3rd turn:
        // 1st scenario
        if (turnCount == 3 && arr[0][0] == computerMark) {
            if (arr[1][0] == '_') {
                arr[1][0] = computerMark;
                return;
            }
            if (arr[1][0] == '0') {
                if (arr[0][2] == '_') {
                    arr[0][2] = computerMark;
                    return;
                } else {
                    arr[2][2] = computerMark;
                    return;
                }
            }
        }

        if (turnCount == 3 && arr[2][2] == computerMark){
            if (arr[2][1] == '_'){
                arr[2][1] = computerMark;
                return;
            }
            if(arr[2][1] == '0'){
                if(arr[0][2] == '_'){
                    arr[0][2] = computerMark;
                    return;
                }

            }
        }

        //2nd scenario
        if (turnCount == 3 && arr[0][2] == computerMark){
            if (arr[0][1] == '0'){
                arr[2][1] = computerMark;
                return;
            }
            if (arr[1][2] == '0'){
                arr[1][0] = computerMark;
                return;
            }
            if (arr[2][1] == '0'){
                arr[0][1] = computerMark;
                return;
            }
            if (arr[1][0] == '0'){
                arr[1][2] = computerMark;
                return;
            }
            if (arr[0][0] == '0'){
                arr[2][2] = computerMark;
                return;
            }
            else {arr[0][0] = computerMark;}
        }

        //4th turn:
        if (turnCount == 4) {
            if (arr[0][0] == computerMark) {
                if (arr[0][2] == computerMark) {
                    if (arr[0][1] == '_') {
                        arr[0][1] = computerMark;
                        return;
                    }
                    if (arr[1][1] == '_') {
                        arr[1][1] = computerMark;
                        return;
                    }
                    if (arr[1][0] == '_') {
                        arr[1][0] = computerMark;
                    }
                }
                if (arr[0][2] == '0') {
                    if (arr[1][1] == '_') {
                        arr[1][1] = computerMark;
                        return;
                    } else {
                        arr[2][1] = computerMark;
                        return;
                    }
                }
            }
            if (arr[2][2] == computerMark) {
                if (arr[0][2] == computerMark) {
                    if (arr[2][1] == '_') {
                        arr[2][1] = computerMark;
                        return;
                    }
                    if (arr[1][2] == '_') {
                        arr[1][2] = computerMark;
                        return;
                    }
                    if (arr[1][1] == '_') {
                        arr[1][1] = computerMark;
                        return;
                    }
                }
                if (arr[0][2] == '0') {
                    if (arr[1][1] == '_') {
                        arr[1][1] = computerMark;
                        return;
                    }
                    if (arr[2][1] == '_') {
                        arr[2][1] = computerMark;
                        return;
                    }
                }
            }
            if (arr[0][2] == computerMark) {
                if (arr[0][0] == '_') {
                    if (arr[1][0] == computerMark || arr[0][1] == computerMark) {
                        arr[0][0] = computerMark;
                        return;
                    }
                }
                if (arr[2][2] == '_') {
                    if (arr[1][2] == computerMark || arr[2][1] == computerMark) {
                        arr[2][2] = computerMark;
                        return;
                    }
                }
            }
        }

        //Turn 5:
        if (turnCount == 5){
            if (arr[1][0] == '_'){
                arr[1][0] = computerMark;
            }
            if (arr[1][2] == '_'){
                arr[1][2] = computerMark;
            }
            if (arr[0][1] == '_'){
                arr[0][1] = computerMark;
            }
            if (arr[2][1] == '_'){
                arr[2][1] = computerMark;
            }
        }
    }
}
