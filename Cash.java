//Mert KAHRAMAN 190101028
//nakitle ugrasan bir hesap
public class Cash extends Object{
  //field at?yorum
  // faiz oran?
  private double intRate;
  //para miktar?
  private double balance;
  //record of amount of interest earned
  private double rIE;
  
  
  //constructor
  Cash(double interestRate){
    intRate = interestRate;
  }
  
  
  //balance getter?
  public double getBalance(){
    return balance;
  }
  
  //Interest rate getter?
  public double getInterestRate(){
    return intRate;
  }
  
  //intRate setter?
  public void setInterestRate(double intRate){
    this.intRate = intRate;
  }
  
  //balance setter?
  public void setBalance(double balance){
    this.balance = balance;
  }
  
  //hesapten para cikarma
  public void transfer(double miktar){
    this.setBalance(this.getBalance() - miktar);
  }
  
  //bu ay kazan?lm?? faiz miktar?
  public double getInterestEarned(){
    return rIE;
  }
  
  // rIE setter
  public void setInterestEarned(double rIE){
    this.rIE = rIE;
  }
  
  //balance pozitif ise faiz oran?n?n 365e b�l�nm�? haliyle �arp?p uzerine anl?k ayl?k faizi ekliyoruz
  public void processDay(){
    if (this.getBalance() > 0){
      this.setBalance((this.getBalance() * (this.getInterestRate() / 365)) + this.getInterestEarned());
    }
  }
  
  //anl?k ayl?k faizi balance a ekliyor ve anl?k ayl?k faizi s?f?ra �ekiyor
  public void processMonth(){
    this.setBalance(this.getInterestEarned() + this.getBalance());
    this.setInterestEarned(0);
  }
}