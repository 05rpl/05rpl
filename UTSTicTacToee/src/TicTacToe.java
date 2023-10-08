import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[3][3];
        char currentPlayer = 'X';

        // Inisialisasi papan dengan karakter kosong
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        boolean gameWon = false;
        int moves = 0;

        while (!gameWon && moves < 9) {
            // Tampilkan papan
            printBoard(board);

            // Mintalah input pemain
            System.out.println("Pemain " + currentPlayer + ", masukkan baris (0-2) dan kolom (0-2) yang ingin Anda isi:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            // Periksa apakah langkah valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                moves++;

                // Periksa apakah pemain menang
                if (checkWin(board, currentPlayer)) {
                    gameWon = true;
                    printBoard(board);
                    System.out.println("Pemain " + currentPlayer + " menang!");
                } else {
                    // Ganti pemain
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Langkah tidak valid. Coba lagi.");
            }
        }

        // Permainan berakhir dengan seri jika tidak ada pemain yang menang
        if (!gameWon) {
            printBoard(board);
            System.out.println("Permainan berakhir dengan seri.");
        }

        scanner.close();
    }

    // Metode untuk mencetak papan
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Metode untuk memeriksa apakah ada pemenang
    public static boolean checkWin(char[][] board, char player) {
        // Periksa baris dan kolom
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Periksa diagonal
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
