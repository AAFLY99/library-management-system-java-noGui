package library;

import java.io.IOException;
import java.util.Scanner;

public class Library{


public static void PrintMainMenu(){
System.out.printf("----------------------------------------------------------------"+ "\n Enter anything else to exit..."+  "\n 1) Add"+"\n 2) Inventory"+"\n 3) Delete" + "\n 4) Borrow Book" + "\n 5) Return Book" +"\n ----------------------------------------------------------------\n");
}
public static void PrintAddMenu(){
System.out.printf("----------------------------------------------------------------"+ "\n Enter anything else to exit..."+ "\n 1) Add new Book"+"\n 2) Add new Customer"+"\n 3) Add new Periodical" +"\n ----------------------------------------------------------------\n");
}
public static void PrintPreviewMenu(){
System.out.printf("----------------------------------------------------------------"+ "\n Enter anything else to exit..."+ "\n 1) Display All Books"+"\n 2) Display Available Books"+"\n 3) Display Borrowed Books" +"\n 4) Display Customers Borrowed Books" +"\n 5) Display All Customers"+"\n 6) Display Information of Book"+"\n 7) Display Information of Customer"+"\n ----------------------------------------------------------------\n");
}
public static void PrintDeleteMenu(){
System.out.printf("----------------------------------------------------------------"+ "\n Enter anything else to exit..."+ "\n 1) Delete Book or Periodical"+"\n 2) Delete Customer" +"\n ----------------------------------------------------------------\n");
}






static int CustomerAdded =1 ;
public static void PrintAddCustomer(){
Scanner c = new  Scanner(System.in);
Customer.allCustomers.add(new Customer());
System.out.println("Enter Customer First Name: ");
Customer.GetCustomer(CustomerAdded).FirstName = c.nextLine();
System.out.println("Enter Customer Last Name: ");
Customer.GetCustomer(CustomerAdded).LastName = c.nextLine();
System.out.println("Enter Customer Phone Number: ");
Customer.GetCustomer(CustomerAdded).setPhoneNumber(c.nextLong());
System.out.println("\nThis is Customer Information:");
System.out.println("****************************************************************");
Customer.GetCustomer(CustomerAdded).PrintCustomerInformation();
System.out.println("****************************************************************");
System.out.println("Press any key to Continue...");
try {
    System.in.read();
} catch (IOException e) {
    e.printStackTrace();
}
CustomerAdded++;
}


static int BookAdded =1;
public static void PrintAddBook(){
Scanner c = new  Scanner(System.in);
Books.allBooks.add(new Books());
System.out.println("Enter Book Name: ");
Books.GetBook(BookAdded).Name = c.nextLine();
System.out.println("Enter the Name of Author: ");
Books.GetBook(BookAdded).Author = c.nextLine();
System.out.println("Enter Number of Pages: ");
Books.GetBook(BookAdded).NumberOfPages = c.nextInt();
System.out.println("\nThis is Book Information:");
System.out.println("****************************************************************");
Books.GetBook(BookAdded).PrintBookInformation();
System.out.println("****************************************************************");
System.out.println("Press any key to Continue...");
try {
    System.in.read();
} catch (IOException e) {
    e.printStackTrace();
}
BookAdded++;
}

public static void PrintAddPeriodical(){
Scanner c = new  Scanner(System.in);
Periodical.allBooks.add(new Periodical());
System.out.println("Enter Periodical Name: ");
Periodical.GetBook(BookAdded).Name = c.nextLine();
System.out.println("Enter the Name of Author: ");
Periodical.GetBook(BookAdded).Author = c.nextLine();
System.out.println("Enter Number of Pages: ");
Periodical.GetBook(BookAdded).NumberOfPages = c.nextInt();

System.out.println("Choose Periodical Type 1 for Papers or 2 for Scientific paper or 3 for Magazine and any other number will be undefined ");
switch (c.next()) {
    case "1":
    Periodical.GetBook(BookAdded).Type = "Papers";
    break;
    case "2":
    Periodical.GetBook(BookAdded).Type  = "Scientific paper";
    break;
    case "3":
    Periodical.GetBook(BookAdded).Type = "Magazine";
    break;
    default:
    Periodical.GetBook(BookAdded).Type  = "undefined";
break;
}
System.out.println("\nThis is Book Information:");
System.out.println("****************************************************************");
Books.GetBook(BookAdded).PrintBookInformation();
System.out.println("****************************************************************");
System.out.println("Press any key to Continue...");
try {
    System.in.read();
} catch (IOException e) {
    e.printStackTrace();
}
BookAdded++;
}


public static void PrintPreviewAllBooks(){
System.out.println("--------------------------------");
Books.PrintAllBooksNames();
System.out.println("--------------------------------");
System.out.println("Press any key to Continue...");
try {
    System.in.read();
} catch (IOException e) {
    e.printStackTrace();
}
    }

public static void PrintPreviewAllAvailableBooks(){
    System.out.println("--------------------------------");
    Books.PrintAllAvailableBooksNames();
    System.out.println("--------------------------------");
    System.out.println("Press any key to Continue...");
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
        }

public static void PrintPreviewAllBorrowedBooks(){
    System.out.println("--------------------------------");
    Books.PrintBorrowedBooksDetails();
    System.out.println("--------------------------------");
    System.out.println("Press any key to Continue...");
    try {
        System.in.read();
    } catch (IOException e) {
        e.printStackTrace();
    }
        }


        public static void PrintPreviewAllCustomerBorrowed(){
            System.out.println("--------------------------------");
            Customer.PrintAllBorrowedCustomersName();
            System.out.println("--------------------------------");
            System.out.println("Press any key to Continue...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
                }


        public static void PrintPreviewAllCustomers(){
            System.out.println("--------------------------------");
            Customer.PrintAllCustomersName();
            System.out.println("--------------------------------");
            System.out.println("Press any key to Continue...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
                }


        public static void PrintPreviewBookInfo(){
            if (Books.allBooks.size()!=0) {
                Books.PrintAllBooksNames();
                System.out.println("Pick the Book you want to preview his information:");
                Scanner c = new Scanner(System.in);
                System.out.println("--------------------------------");
                Books.GetBook(c.nextInt()).PrintBookInformation();
                System.out.println("--------------------------------");
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Books.PrintAllBooksNames();
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                }



        public static void PrintPreviewCustomerInfo(){
            if (Customer.NumberOfAvailableCustomers!=0) {
                Customer.PrintAllCustomersName();
                System.out.println("Pick the Customer you want to preview his information:");
                Scanner c = new Scanner(System.in);
                System.out.println("--------------------------------");
                Customer.GetCustomer(c.nextInt()).PrintCustomerInformation();
                System.out.println("--------------------------------");
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Customer.PrintAllCustomersName();
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                }

        public static void PrintDeleteCustomer(){
            if (Customer.NumberOfAvailableCustomers!=0) {
                Customer.PrintAllCustomersName();
                System.out.println("Pick the Customer you want to Delete:");
                Scanner c = new Scanner(System.in);
                System.out.println("--------------------------------");
                Customer cu =Customer.GetCustomer(c.nextInt());
                Customer.DeleteCustomer(cu);
                System.out.println("--------------------------------");
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                Customer.PrintAllCustomersName();
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                }



                public static void PrintDeleteBookOrPeriodical(){
                    if (Books.NumberOfAvailableBooks!=0) {
                        Books.PrintAllBooksNames();
                        System.out.println("Pick the Book or Periodical you want to Delete:");
                        Scanner c = new Scanner(System.in);
                        System.out.println("--------------------------------");
                        Books bk = Books.GetBook(c.nextInt());
                        Books.DeleteBookOrPeriodical(bk);
                        System.out.println("--------------------------------");
                        System.out.println("Press any key to Continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        Books.PrintAllAvailableBooksNames();
                        System.out.println("Press any key to Continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                        }


                public static void PrintBorrowBookMenu(){
                    if (Customer.NumberOfAvailableCustomers != 0) {
                        System.out.println("Pick a Customer to Borrow a Book:");
                        Customer.PrintAllCustomersName();
                        Scanner c = new Scanner(System.in);
                        Scanner b = new Scanner(System.in);
                        System.out.println("--------------------------------");
                        Customer cu =Customer.GetCustomer(c.nextInt());
                        System.out.println("the Customer  "+cu.FirstName+" "+ cu.LastName+" has been Selected successfully");
                        cu.PrintCustomerCart();
                        System.out.println("--------------------------------");
                        if (Books.BorrowedBooks.size()!= Books.NumberOfAvailableBooks) {
                        System.out.println("Pick Book to Borrow");
                        Books.PrintAllAvailableBooksNames();
                        System.out.println("--------------------------------");
                        cu.BorrowBook(Books.GetBook(b.nextInt()));
                        System.out.println("Press any key to Continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        System.out.println("All Books in Library is already Borrowed");
                        System.out.println("Press any key to Continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }else {Customer.PrintAllCustomersName();
                System.out.println("Press any key to Continue...");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
                        }


                        //----------------------------------------------------------------

                public static void PrintReturnBorrowBookMenu() {
                    if (Books.BorrowedBooks.size() != 0) {
                        System.out.println("Pick a Customer to Return a Borrowed Book:");
                        Customer.PrintAllBorrowedCustomersName();
                        Scanner c = new Scanner(System.in);
                        Scanner b = new Scanner(System.in);
                        System.out.println("--------------------------------");
                        Customer cu = Customer.GetCustomer(c.nextInt());
                        System.out.println("the Customer  " + cu.FirstName + " " + cu.LastName + " has been Selected successfully");
                        cu.PrintCustomerCart();
                        System.out.println("--------------------------------");
                        if (Customer.BorrowedCustomers.size() != 0) {
                            // Books.PrintBorrowedBooksDetails();
                            cu.PrintCustomerCart();
                            System.out.println("Pick Book to Return");
                            cu.ReturnBorrowBook(Books.GetBook(b.nextInt()));
                            System.out.println("Press any key to Continue...");
                            try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Books.PrintAllBooksNames();
                            System.out.println("Press any key to Continue...");
                            try {
                                System.in.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                        }
                    } else {
                        Books.PrintBorrowedBooksDetails();
                        System.out.println("Press any key to Continue...");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


}


