package library;

import java.time.LocalDate;
import java.util.ArrayList;

class Customer {
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
static int i=1;
int id ;
String FirstName;
String LastName;
private long PhoneNumber;
int NumberOfBorrowedBooks =0;
boolean IsCustomerAvailable = true;
static int NumberOfAvailableCustomers;
final int  MaxNumberOfBooks = 3;
Books[] Cart = new Books[3];
static ArrayList<Customer> allCustomers = new ArrayList<>();
static ArrayList<Customer> BorrowedCustomers = new ArrayList<>();
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ

/*إضافة رقم الهاتف */
public void setPhoneNumber(long Ph) {
PhoneNumber = Ph;
}
/*عرض رقم الهاتف */
public long getPhoneNumber(){
return PhoneNumber;
}



/*حذف الزبون*/
public static void DeleteCustomer (Customer c) {
if (c.NumberOfBorrowedBooks == 0) {
c.IsCustomerAvailable = false;
Customer.NumberOfAvailableCustomers--;
System.out.println("the Customer  "+c.FirstName +" "+c.LastName+" has been deleted successfully");
}else{
System.out.println("the Customer "+c.FirstName +" "+c.LastName + " Can't be deleted because he has been Borrowed a Book Please Return the Book so you can be able to delete the Customer");
c.PrintCustomerCart();
}

}
/*Non parameterized constructor */

public Customer() {
Customer.NumberOfAvailableCustomers++;
this.id = i;
i++;
}
/* parameterized constructor */
public Customer(String FirstName, String LastName, long Ph){
this.FirstName  = FirstName;
this.LastName = LastName;
this.setPhoneNumber(Ph);
this.id = i;
i++;
Customer.NumberOfAvailableCustomers++;
}



/*طباعة بيانات الزبون */
public void PrintCustomerInformation(){
if (this.NumberOfBorrowedBooks == 0){
System.out.println("CustomerID: " + id+"\nCustomer Name: " + FirstName +" "+ LastName +"\nPhone Number: " + PhoneNumber);

}else{
System.out.println("CustomerID: " + id+"\nCustomer Name: " + FirstName +"  "+  LastName +"\nPhone Number: " + PhoneNumber +"\nNumber of Borrowed Book = " + NumberOfBorrowedBooks  );
this.PrintCustomerCart();
}
}

/*طباعة اسماء كل الزبائن */
public static void PrintAllCustomersName(){
    System.out.println("--------------------------------");
    if (Customer.NumberOfAvailableCustomers == 0) {
        System.out.println("There is no Customers at All !!");
    }else{
System.out.println("this is list of All Customers in the System:-");
for (int i = 0; i < Customer.allCustomers.size(); i++) {
    if (Customer.allCustomers.get(i).IsCustomerAvailable == true) {
    System.out.println(allCustomers.get(i).id +") " +allCustomers.get(i).FirstName +" " +allCustomers.get(i).LastName ) ;
    }
}
}
}

/* طباعة اسماء كل الزبائن الذين استعارو كتب */
public static void PrintAllBorrowedCustomersName(){
    System.out.println("--------------------------------");
    if (Customer.BorrowedCustomers.size()==0) {
        System.out.println("There is no Customer has  Borrowed a book !!");

        }else{
System.out.println("this is a list of Customers that Borrowed Books from the Library:-");
for (int i = 0; i < Customer.allCustomers.size(); i++) {

    if (allCustomers.get(i).IsCustomerAvailable == true && allCustomers.get(i).NumberOfBorrowedBooks !=0 ) {

System.out.println(allCustomers.get(i).id +") " +allCustomers.get(i).FirstName +" " +allCustomers.get(i).LastName  ) ;
System.out.println("The following books are borrowed by "+allCustomers.get(i).FirstName);
System.out.println("---------");

for (Books n : allCustomers.get(i).Cart) {
        if (n != null) {
            System.out.println( n.Name );
        }
    }
}
}
}
}


/*طباعة الكتب المستعارة خاصة بالزبون */
public void PrintCustomerCart(){
if (Cart[0] == null && Cart[1] == null && Cart[2] == null) {

System.out.println("the Customer Cart is empty");
}else{
System.out.println("---------");
System.out.println("The following books are borrowed by "+ this.FirstName);
for (Books n : Cart) {
        if (n != null) {
            System.out.println(   n.id+") "+n.Name );
        }
        }
System.out.println("----------");

}
}
/*استعارت كتاب  */
public void BorrowBook(Books b){

if (b.IsBookCanBorrowed==true) {
if (this.NumberOfBorrowedBooks < MaxNumberOfBooks){
switch (this.NumberOfBorrowedBooks) {
    case 0 :
    this.Cart[0]= b;
        break;
        case 1 :
    this.Cart[1]= b;
        break;
        case 2 :
    this.Cart[2]= b;
    System.out.println("you have Borrowed your third Book Thanks!");
        break;
    }
b.IsBookCanBorrowed = false;
this.NumberOfBorrowedBooks++;
Books.BorrowedBooks.add(b);
Customer.BorrowedCustomers.add(this);
b.CustomerName = this.FirstName +" "+ this.LastName;
b.BorrowDate = LocalDate.now();
System.out.println("The Book '" + b.Name +"' has been borrowed" );
}
else {
System.out.println("The Customer reaches the limit of the Borrowed Books witch is = 3 " );
}
}
else {
System.out.println("The Book '" + b.Name +"' is Already borrowed" + " by " + b.CustomerName);
}
}

/*إعادة كتاب المستعار */
public void ReturnBorrowBook(Books b){
if (b.IsBookCanBorrowed == false) {
for (int i = 0; i < Cart.length; i++) {
if ( Cart[i] != null &&Cart[i].Name.equals(b.Name)) {

    b.IsBookCanBorrowed = true;
    this.NumberOfBorrowedBooks--;
    Books.BorrowedBooks.remove(b);
    if (this.NumberOfBorrowedBooks==0){Customer.BorrowedCustomers.remove(this);}
    b.CustomerName = null;
    b.BorrowDate = null;
    this.Cart[i]=null;
    System.out.println("The Book ( "+ b.Name +" ) has been Returned");
}
}
}
        else {
        System.out.println("The Book (" + b.Name +") is  Already Not Borrowed");
        }

}


/* استرجاع الزبون */
public static Customer GetCustomer(int CustomerId) {
    Customer d = null;
if (Customer.allCustomers.get(CustomerId-1).IsCustomerAvailable==true) {
d = Customer.allCustomers.get(CustomerId-1);
}
return d;
}
//ـــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــــ
}
