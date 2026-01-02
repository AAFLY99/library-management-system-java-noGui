package library;

class Periodical extends Books {
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
String Type ;
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
/* Non parameterized constructor*/
public Periodical(){
this.Type = "undefined";
}
/* parameterized constructor*/
public Periodical(String n , int p , String a , int  t){
    this.Name = n;
    this.NumberOfPages = p;
    this.Author = a;
switch (t) {
    case 1:
this.Type = "Papers";
    break;
    case 2:
this.Type = "Scientific paper";
    break;
    case 3:
this.Type = "Magazine";
    break;
    default:
this.Type = "undefined";
break;
}

    }

/*طباعة تفاصيل الدورية */
@Override
public void PrintBookInformation(){
    System.out.println("--------------------------------");
    if (IsBookCanBorrowed == true){
        System.out.printf("The Periodical ID: " + id +"\nPeriodical Name: " + Name + "\nNumber of Pages: " + NumberOfPages+" Page" + "\nAuthor: " + Author + "\nType: " + Type  +"\nCan Borrow the Periodical: " + IsBookCanBorrowed+"\n" );
    }
    else {
        System.out.printf("The Periodical ID: " + id +"\nPeriodical Name: " + Name + "\nNumber of Pages: " + NumberOfPages+" Page" + "\nAuthor: " + Author +"\nType: " + Type  +"\nCan Borrow the Periodical: " + IsBookCanBorrowed+"\nBorrowed by: " + CustomerName + "\nBorrowed at date: " + BorrowDate + "\n" );
    }
    }

    /* استرجاع الدورية */

public static Periodical  GetBook(int periodicalId) {
    Periodical d = null;
    if (Periodical.allBooks.get(periodicalId-1).IsBookAvailable==true) {
    d = (Periodical) Periodical.allBooks.get(periodicalId-1);
    }
    return d;
    }
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
}
