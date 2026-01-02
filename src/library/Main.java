package library;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner s1 = new Scanner(System.in);

        boolean run = true;

        while (run) {

            Library.PrintMainMenu();

            switch (s1.next()) {

                case "1":{
                    Library.PrintAddMenu();
                    switch (s1.next()) {

                        case "1":{
                            Library.PrintAddBook();
                            continue;
                        }
                        case "2":{
                            Library.PrintAddCustomer();
                            continue;
                        }
                        case "3":{
                            Library.PrintAddPeriodical();
                            continue;
                        }
                        default:
                            continue;
                    }
                }

                case "2":{
                    Library.PrintPreviewMenu();
                    switch (s1.next()) {
                        case "1":{
                            Library.PrintPreviewAllBooks();
                            continue;
                        }
                        case "2":{
                            Library.PrintPreviewAllAvailableBooks();
                            continue;
                        }
                        case "3":{
                            Library.PrintPreviewAllBorrowedBooks();
                            continue;
                        }
                        case "4":{
                            Library.PrintPreviewAllCustomerBorrowed();
                            continue;
                        }
                        case "5":{
                            Library.PrintPreviewAllCustomers();
                            continue;
                        }
                        case "6":{
                            Library.PrintPreviewBookInfo();
                            continue;
                        }
                        case "7":{
                            Library.PrintPreviewCustomerInfo();
                            continue;
                        }
                        default:
                            continue;
                    }
                }

                case "3":{
                    Library.PrintDeleteMenu();
                    switch (s1.next()) {

                        case "1":{
                            Library.PrintDeleteBookOrPeriodical();
                            continue;
                        }
                        case "2":{
                            Library.PrintDeleteCustomer();
                            continue;
                        }
                        default:
                            continue;
                    }
                }

                case "4":{
                    Library.PrintBorrowBookMenu();
                    continue;
                }
                case "5" :{
                    Library.PrintReturnBorrowBookMenu();
                    continue;
                }

                default:
                    s1.close();
                    run = false;
                    break;
            }
        }
        System.out.println("--------------------------------");
        System.out.println("*Thanks for using this software see you soon *");
        System.out.println("--------------------------------");


    }
}

