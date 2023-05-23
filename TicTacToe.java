import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOver = false;
        
        while (!gameOver) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]):");
            int row = scanner.nextInt() - 1;
            int column = scanner.nextInt() - 1;
            
            if (isValidMove(row, column)) {
                makeMove(row, column);
                if (isWinningMove(row, column)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
        
        scanner.close();
    }
    
    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                board[row][column] = '-';
            }
        }
    }
    
    private void printBoard() {
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int column = 0; column < 3; column++) {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
            System.out.println("---------");
        }
    }
    
    private boolean isValidMove(int row, int column) {
        if (row < 0 || row >= 3 || column < 0 || column >= 3) {
            return false;
        }
        
        return board[row][column] == '-';
    }
    
    private void makeMove(int row, int column) {
        board[row][column] = currentPlayer;
    }
    
    private boolean isWinningMove(int row, int column) {
        // Check row
        if (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) {
            return true;
        }
        
        // Check column
        if (board[0][column] == currentPlayer && board[1][column] == currentPlayer && board[2][column] == currentPlayer) {
            return true;
        }
        
        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true;
        }
        
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true;
        }
        
        return false;
    }
    
    private boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (board[row][column] == '-') {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
