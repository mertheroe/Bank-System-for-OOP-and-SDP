//Mert KAHRAMAN 190101028
//Cashten extend eden bir alt class, birikimler
public class Savings extends Cash{
  
  //ust classtan intRate ceken bir constructor
  Savings(double intRate){
    super(intRate);
  }
  
  
  //hesaba miktar kadar para yat?rma
  public void deposit(double miktar){
    this.setBalance(this.getBalance() + miktar);
  }
  
  //verilen deger var olan bakiyeye e? veya daha az ise bakiyeyi deger kadar dusurup true donduruyor,
  //degilse false donduruyor
  public boolean withdraw(double deger){
    if (deger <= this.getBalance()){
      this.setBalance(this.getBalance() - deger);
      return true;
    }
    else 
       return false;
  }
  //kontrol yazisi
  public String savingsControl(){
   return "ben savingsim";
  }
  /* Customer yolu:
   Date date = new Date(31,12,2023)
> Cash cash = new Cash(1.5)
> Savings savings = new Savings(cash.getInterestRate())
Loan loan = new Loan(cash.getInterestRate(), 30, 40)
Customer customer = new Customer("Mert", "Kahraman", savings,loan,date)
*/
}