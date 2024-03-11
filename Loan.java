//Mert KAHRAMAN 190101028
//borclar class?, cashten extend eden bir alt class
public class Loan extends Cash{
  //borc limit
  private double loanLimit;
  // borc asimi cezas?
  private double overdraftPenalty;
  //borc gecildi mi
  private boolean isLoanDrafted;
  
  
  //loan constructor?, biri ust classtan olmak uzere 3 input al?yor
  Loan(double intRate, double loanLimit, double overdraftPenalty){
    super(intRate);
    this.loanLimit = loanLimit;
    this.overdraftPenalty = overdraftPenalty;
  }
  
  
  // borc limiti getter?
  public double getLoanLimit(){
    return loanLimit;
  }
  
  //borc limiti setter?
  public void setLoanLimit(double limit){
    this.loanLimit = limit;
  }
  
  //borc gecme cezas? getter
  public double getOverdraftPenalty(){
    return overdraftPenalty;
  }
  
  // borc asim setter?
  public void setOverdraftPenalty(double asim){
    this.overdraftPenalty = asim;
  }
  
  //borc gecildi mi getter
  public boolean getIsLoanDrafted(){
    return isLoanDrafted;
  }
  
  //borc gecildi mi setter
  public void setIsLoanDrafted(boolean gecildimi){
    this.isLoanDrafted = gecildimi;
  }
  
  //cash processday overload, �ncekiyle ayn? fakat eger butce borc limitinden buyukse
   public void processDay(){
     if (this.getBalance() > 0){
       this.setBalance((this.getBalance() * (this.getInterestRate() / 365)) + this.getInterestEarned());
    }
     if (this.getBalance() > this.getLoanLimit()){
       this.setIsLoanDrafted(true);
    }
     else 
        this.setIsLoanDrafted(false);
  }
   
   //processmonth ile ayn? fakat bu method en son �a?r?ld???ndan beri overdraft olduysa overdraft
   //penalty i balance a ekle
  public void processMonth(){
    this.setBalance(this.getInterestEarned() + this.getBalance());
    this.setInterestEarned(0);
  //eger borc asildiysa asim cezasini nakite ekleniyor. ayrica sonraki sefer kullan?l?rsa bir daha
  //eklememesi icin borc asilmadi olarak kaydediliyor
    if (getIsLoanDrafted() == true){
      this.setBalance(this.getBalance() + this.getOverdraftPenalty());
      setIsLoanDrafted(false);
  }
 }
}