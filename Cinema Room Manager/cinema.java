package cinema;

import java.util.Scanner;

public class Cinema {

    public char[][] cinema;
    public int income = 0;
    public int estimatedRevenue = 0;
    public int purchasedTickets = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        int seats = scanner.nextInt();

        Cinema cinema = new Cinema(rows, seats);
        cinema.totalIncome(rows, seats);

        int action = 1;
        while (action != 0) {
            System.out.println("Menu: ");
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Show statistics");
            System.out.println("0. Exit");
            action = scanner.nextInt();
            switch (action) {
                case 1:
                    cinema.showSeats(rows, seats);
                    break;
                case 2:
                    cinema.buyTicket(rows, seats);
                    break;
                case 3:
                    cinema.showStatistics(rows, seats);
                case 0:
                    break;
            }
        }

    }

    public Cinema(int rows, int seats) {
        cinema = new char[rows + 1][seats + 1];
        cinema[0][0] = ' ';
        for (int col = 1; col < seats + 1; col++) {
            cinema[0][col] = (char) (48 + col);
        }
        for (int row = 1; row < rows + 1; row++) {
            cinema[row][0] = (char) (48 + row);
        }
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < seats + 1; j++) {
                cinema[i][j] = 'S';
            }
        }
    }

    //Method below prints array
    public void showSeats(int rows, int seats) {
        System.out.println("Cinema: ");
        for (int k = 0; k < rows + 1; k++) {
            for (int l = 0; l < seats + 1; l++) {
                System.out.print(cinema[k][l] + " ");
            }
            System.out.println();
        }
    }

    public void buyTicket(int rows, int seats) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number: ");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row: ");
        int seat = scanner.nextInt();

        if (row > rows || seat > seats) {
            System.out.println("Wrong input!");
            buyTicket(rows, seats);
        }
        else if (cinema[row][seat] == 'B') {
            System.out.println("That ticket has already been purchased!");
            buyTicket(rows, seats);
        }
        else {
            cinema[row][seat] = 'B';
            purchasedTickets++;

            int totalSeats = rows * seats;

            if (totalSeats <= 60) {
                income += 10;
                System.out.println("Ticket price: $" + 10);
            }
            else {
                int frontRows = rows / 2;
                if (row <= frontRows) {
                    income += 10;
                    System.out.println("Ticket price: $" + 10);
                }
                else {
                    income += 8;
                    System.out.println("Ticket price: $" + 8);
                }
            }
        }
    }
    
    public void showStatistics(int rows, int seats) {
        double percentage = (double) purchasedTickets/(rows * seats)* 100;
        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + income);
        System.out.println("Total income $" + estimatedRevenue);

    }

    public void totalIncome (int rows, int seats) {
        int sum = rows * seats;
        if(sum < 60) {
            estimatedRevenue = sum * 10;
        }
        else if(sum >= 60 && rows % 2 != 0) {
            estimatedRevenue = ((rows/2 * seats * 10) + ((rows/2 + 1) * seats * 8));
        }
        else {
            estimatedRevenue = (sum/2 * 10 + sum/2 * 8);
        }
    }
}

