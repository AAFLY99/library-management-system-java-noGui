package library;
import java.time.LocalDate;
import java.util.ArrayList;

/*كتاب */
class Books {

    //ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
    static int i=1 ;
    int id ;
    String Name;
    int NumberOfPages;
    String Author;
    String CustomerName ;
    boolean IsBookCanBorrowed = true;
    static int NumberOfAvailableBooks = 0;
    boolean IsBookAvailable = true;
    LocalDate BorrowDate;
    static ArrayList<Books> allBooks = new ArrayList<>();
    static ArrayList<Books> BorrowedBooks = new ArrayList<>();
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ


    /*طباعة عداد الكتب المستعارة */
    public static void getNumberOfallBorrowedBooks() {
        System.out.println(Books.BorrowedBooks.size());
    }

    /*حذف كتاب*/
    public static void DeleteBookOrPeriodical(Books c) {
        if (c.CustomerName == null) {
            c.IsBookAvailable = false;
            Books.NumberOfAvailableBooks--;
            System.out.println("the Book "+c.Name+" has been deleted successfully");
        }else{
            System.out.println("the Book "+c.Name + " Can't be deleted because he Borrowed By "+c.CustomerName);
        }
    }
    /* Non parameterized constructor*/
    public Books(){
        Books.NumberOfAvailableBooks++;
        this.id = i;
        i++;
    }
    /* parameterized constructor */
    public Books(String n , int p , String a ){
        this.Name = n;
        this.NumberOfPages = p;
        this.Author = a;
        int i = id ++;
        this.id = i;
        Books.NumberOfAvailableBooks++;
    }

    /*طباعة تفاصيل الكتاب */
    public void PrintBookInformation(){
        System.out.println("--------------------------------");
        if (IsBookCanBorrowed == true){
            System.out.printf("The Book ID: " + id +"\nBook Name: " + Name + "\nNumber of Pages: " + NumberOfPages+" Page" + "\nAuthor: " + Author +"\nCan Borrow the Book: " + IsBookCanBorrowed+"\n" );
        }
        else {
            System.out.printf("The Book ID: " + id +"\nBook Name: " + Name + "\nNumber of Pages: " + NumberOfPages+" Page" + "\nAuthor: " + Author +"\nCan Borrow the Book: " + IsBookCanBorrowed+"\nBorrowed by: " + CustomerName + "\nBorrowed at date: " + BorrowDate + "\n" );
        }

    }


    /*طباعة تفاصيل جميع الكتب المستعارة */
    public static void PrintBorrowedBooksDetails(){
        System.out.println("--------------------------------");
        if (Books.BorrowedBooks.size()==0) {
            System.out.println("There is no Borrowed Books !!");

        }else{
            System.out.println("The following Books is Borrowed:-");
            for (int i = 0; i < BorrowedBooks.size(); i++) {
                System.out.println( BorrowedBooks.get(i).id +") " +"Book Name: " +BorrowedBooks.get(i).Name +  "\n   Borrowed by: " + BorrowedBooks.get(i).CustomerName +" " + "\n   at: " + BorrowedBooks.get(i).BorrowDate+"\n********************" ) ;
            }
            System.out.println("--------------------------------");
        }


    }
    /*طباعة اسماء جميع الكتب */
    public static void PrintAllBooksNames(){
        System.out.println("--------------------------------");
        if (NumberOfAvailableBooks == 0) {
            System.out.println("There is no  Books at All!!");
        }else{
            System.out.println("this is list of All Books in the Library:-");
            for (int i = 0; i < allBooks.size(); i++) {
                if (Books.allBooks.get(i).IsBookAvailable == true) {
                    System.out.println( allBooks.get(i).id +") "+allBooks.get(i).Name);
                }
            }

        }
    }

    /*طباعة اسماء جميع الكتب المتاحة */
    public static void PrintAllAvailableBooksNames(){
        System.out.println("--------------------------------");
        if (NumberOfAvailableBooks==0) {
            System.out.println("There is no  Books Available All!!");
        }else{
            System.out.println("this is list of All Available Books in the Library:-");
            for (int i = 0; i < allBooks.size(); i++) {
                if (Books.allBooks.get(i).IsBookAvailable == true && Books.allBooks.get(i).IsBookCanBorrowed==true) {
                    System.out.println( allBooks.get(i).id +") "+allBooks.get(i).Name);
                }
            }

        }
    }

    /* استرجاع الكتاب */
    public static Books GetBook(int BookId ) {
        Books d = null;
        if (Books.allBooks.get(BookId-1).IsBookAvailable==true) {
            d = Books.allBooks.get(BookId-1);
        }
        return d;
    }

//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
}