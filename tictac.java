import java.util.Scanner;

public class tictac {
    public static void main(String args[]) {
        char[] board = {32, 32, 32, 32, 32, 32, 32, 32, 32};
        boolean turn = true;
        int count = 1;
        Scanner IO = new Scanner(System.in);


        while (true) {
            printBoard(board);

            //get input
            if (turn)
                System.out.println("\nX's turn");
            else
                System.out.println("\nO's turn");
            int t = getValidInput(board);

            //set the board value based on t above
            if (turn)
                board[(t + 9) % 9] = 'X';
            else
                board[(t + 9) % 9] = 'O';

            //determine winner if any
            char win = determineWinner(board);
            if (win != ' ') {

                System.out.println("\n");
                printBoard(board);
                System.out.println("\n");
                System.out.println("Player with the " + win + " pieces won!!");
                break;
            }

            //check if tie
            if (count == 9) {
                System.out.println("\n");
                printBoard(board);
                System.out.println("\n");
                System.out.println("its a tie, no one wins");
                break;
            }


            count++;
            turn = !turn;
        }
        IO.close();
    }

    public static String superscript(int n) {
        String out = "";
        while (n > 0) {
            int v = n % 10;
            if (v == 1)
                out = '\u00b9' + out;
            else if (v == 2 || v == 3)
                out = (char) ('\u00b0' + v) + out;
            else
                out = (char) ('\u2070' + v) + out;
            n /= 10;
        }
        return out;
    }

    public static void printBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ')
                System.out.print(superscript(i + 1));
            else
                System.out.print(board[i]);

            if (i % 3 < 2)
                System.out.print("|");
            else if (i < board.length - 1)
                System.out.println("\n-+-+-");
            else
                System.out.println();
        }
    }

    public static char getRow(char[] board) {
        if (board[0] == 'X' && board[3] == 'X' && board[6] == 'X') {
            System.out.println("X");
            return 'X';
        }

        else if (board[1] == 'X' && board[4] == 'X' && board[7] == 'X') {
            System.out.println("X");
            return 'X';
        }
        else if (board[2] == 'X' && board[5] == 'X' && board[8] == 'X') {
            System.out.println("X");
            return 'X';
        }
        else if (board[0] == 'O' && board[3] == 'O' && board[5] == 'O') {
            System.out.println("O");
            return 'O';
        }

        else if (board[1] == 'O' && board[4] == 'O' && board[7] == 'O') {
            System.out.println("O");
            return 'O';
        }
        else if (board[2] == 'O' && board[5] == 'O' && board[8] == 'O') {
            System.out.println("O");
            return 'O';
        }
        char[] out = new char[3];
        return ' ';
        }

    public static char getCol(char[] board) {
        if (board[0] == 'X' && board[1] == 'X' && board[2] == 'X') {
            System.out.println("X");
            return 'X';
        }

        if (board[3] == 'X' && board[4] == 'X' && board[5] == 'X') {
            System.out.println("X");
            return 'X';

        }

        if (board[6] == 'X' && board[7] == 'X' && board[8] == 'X') {
            System.out.println("X");
            return 'X';
        }
        if (board[0] == 'O' && board[1] == 'O' && board[2] == 'O') {
            System.out.println("");
            return 'O';
        }

        if (board[3] == 'O' && board[4] == 'O' && board[5] == 'O') {
            System.out.println("O");
            return 'O';
        }

        if (board[6] == 'O' && board[7] == 'O' && board[8] == 'O') {
            System.out.println("O");
            return 'O';
        }
        char[] out = new char[3];
        return ' ';
    }

    public static char getDia(char[] board) {

        if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
            System.out.println("X");
            return 'X';
        }
        if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
            System.out.println("X");
            return 'X';
        }

        if(board[0]=='O'&&board[4]=='O'&&board[8]=='O')

        {
            System.out.println("O");
            return 'O';
        }
        if(board[2]=='O'&&board[4]=='O'&&board[6]=='O')

        {
            System.out.println("O");
            return 'O';
        }

        char[] out = new char[3];
        return' ';
    }


    public static boolean isWinner(char[] line){
        return false;
    }

    public static char determineWinner(char[] board){

        char col = getCol(board);
        char row = getRow(board);
        char dia = getDia(board);

        if (col != ' '){
            return col;
        }
        if (row != ' '){
            return row;
        }
        if (dia != ' '){
            return dia;
        }

        return ' ';
    }

    public static boolean isNumeric(String str) {
        try{
            Integer.valueOf(str);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public static int getValidInput(char[] board) {





        boolean smart = false;
        int n = 9;
        int player;

        boolean notString = false;


        while (!notString) {
            Scanner ch = new Scanner(System.in);
            String player1 = ch.next();
            try {

                player = Integer.valueOf(player1);


            } catch (Exception e) {
                System.out.println("invalid");
                ch.nextLine();
                continue;
            }
            if (player < 9 && player > 0) {
                System.out.println("");
                notString = true;

            } else if (!(player < 10 && player > 0)) {
                System.out.println("out of  range");
                continue;
            }
            if(!(board[player - 1]== ' ')){
                System.out.println("not valid");
                notString = false;

            }
            else{
                System.out.println("valid");
                return player -1;
            }
        }





        return ' ';}
}