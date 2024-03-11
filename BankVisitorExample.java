// Visitor Kullanımı
public class BankVisitorExample {
  // Siniflarin icine sadece BankSiniflar interface'inden accept methodu ekledik. Ayri ayri siniflarla ugrasmadik.
  // Butun isi BankVisitor interfaceini implementleyen BankInfoVisitor'e yaptirdik.
  // Ayri ayri classlara method yazmak yerine tek bir accept methodunun ne vereceğini visitorluk
  //yapan BankInfoVisitor visitoru halletti.
    public static void main(String[] args) {
Date date = new Date(31,12,2023);
Cash cash = new Cash(1.5);
Savings savings = new Savings(cash.getInterestRate());
Loan loan = new Loan(cash.getInterestRate(), 30, 40);
Customer customer = new Customer("Mert", "Kahraman", savings,loan,date);
BankVisitor visitor = new BankInfoVisitor();
CEO.getInstance().accept(visitor);
customer.accept(visitor);
 }
}