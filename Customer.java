//Mert KAHRAMAN 190101028
// musteri class?
//visitor override'ini sona koydum
//visitor icin BankSiniflari implemente etti
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer extends Object implements BankSiniflar,CustomerComponent,BridgeBankSystem{
  //fieldlar
  //musteri ismi
 private String customerFirstName;
 //musteri soyismi
 private String customerLastName;
 //musteri birikim
 private final Savings customerSavings;
 //musteri borc
 private Loan customerLoan;
 //ne oldu?una dair fikrim yok, rastgele int verdim ******************************
 private int commission; 
 //tarih
 private Date date;
 
 
 //customer constructor?
  public Customer(String customerFirstName, String customerLastName, Savings customerSavings, Loan customerLoan, Date date){
   this.customerFirstName = customerFirstName;
   this.customerLastName = customerLastName;
   // savingsi atayabilmeye calistim
   customerSavings = new Savings(customerSavings.getInterestRate());
   this.customerSavings = customerSavings;
   //ayni sekilde loan?
   customerLoan = new Loan(customerLoan.getInterestRate(), customerLoan.getLoanLimit(),
                         customerLoan.getOverdraftPenalty());
   this.customerLoan = customerLoan;
   //ayn? sekilde datei
   date = new Date(date.getDay(),date.getMonth(),date.getYear());
   this.date = date;
 }
 
 
 //methodlar
 //first namegetter
 public String getFirstName(){
   return customerFirstName;
 }
 
 //firstname setter
 public void setFirstName(String ad){
   this.customerFirstName = ad;
 } 
 
 //lastname getter
 public String getLastName(){
   return customerLastName;
 }
 
 //lastname setter
 public void setLastName(String soyad){
   this.customerLastName = soyad;
 }
  
  //savings getter
 public Savings getSavings(){
   return customerSavings;
 }
 
 //laon getter
 public Loan getLoan(){
   return customerLoan;
 }
 
 //date getter
 public Date getDate(){
   return date;
 }
 
 //date setter
 public void setDate(Date tarih){
   this.date = tarih;
 }
 
 //current value ama loandan savings �?kar?lm?? balance
 public double currentValue(){
   return (this.getSavings().getBalance() - this.getLoan().getBalance());
 }
 
 //input? savings balance a ekiyor
 public void deposit(double nakit){
   this.getSavings().setBalance(this.getSavings().getBalance() + nakit);
 }
 
 //loan balance? input kadar azalt?yor
 public void payLoan(double odenen){
   this.getLoan().setBalance(this.getLoan().getBalance() - odenen);
 }
 
 //eger input degeri savings balance a esit ya da kucukse, savings balanceiinput kadar dusuruyor ve true donduruyor
 public boolean withdraw(double cekim){
   if (cekim <= this.getSavings().getBalance()){
     this.getSavings().setBalance(this.getSavings().getBalance() - cekim);
     return true;
   }
   else
     return false;
 }
 
 //Date class?ndaki methodu cagiriyor, savings balance negatif ise bunu loana tasiyor ve savings balancei
 //sifir yapiyor. savings ve loan instanceslar?n?n ikisi icin de processDay methodu cagiriyor, eger ay degisirse
 //processMonthu her ikisi icin de cagiriyor
 public void incrementDate(){
   this.getDate().incrementDay();
   //savingsin balancei negatifse
   if (this.getSavings().getBalance() < 0){
     //eksili balancei loana ekleme
     this.getLoan().setBalance(this.getLoan().getBalance() - this.getSavings().getBalance());
     //savings balanceini sifir yapma
     this.getSavings().setBalance(0);
     //ko?ul sagladiginda processdayleri cagirir
     this.getSavings().processDay();
     this.getLoan().processDay();
     //kosul
     if (this.getDate().getDay() == 1){
       //kosul saglandiginda processmothlar
       this.getSavings().processMonth();
       this.getLoan().processMonth();
     }
   }
 }
 
 //Visitor icin override, (BankSiniflar'dan)
  @Override
    public void accept(BankVisitor visitor) {
        visitor.visitCustomer(this);
    }
  //Iterator ve Composite icin CustomerComponent'ten gelen override
   @Override
    public void displayCustomerInfo() {
        System.out.println("Müşteri Adı: " + this.getFirstName());
    }
   //BridgeBankSystem override
   @Override
    public void showDetails() {
        System.out.println("Müşteri Tam Adı: " + this.getFirstName() + " " + this.getLastName() + ", Borç limiti: " + this.getLoan().getLoanLimit());
    }
}
/* Cash n = new Cash(5)
 Date d = new Date(10,10,2010)
 Loan l = new Loan(3,5,10)
Savings s = new Savings(9)
 Customer mert = new Customer("Mert","Kahraman",s,l,d)*/ 

/* Customer yolu:
   Date date = new Date(31,12,2023)
> Cash cash = new Cash(1.5)
> Savings savings = new Savings(cash.getInterestRate())
Loan loan = new Loan(cash.getInterestRate(), 30, 40)
Customer customer = new Customer("Mert", "Kahraman", savings,loan,date)
*/
