// Ziyaretçi sınıfı
public class BankInfoVisitor implements BankVisitor {
    @Override
    public void visitCEO(CEO ceo) {
        System.out.println("Bankanın CEO'su: " + ceo.getCEOFirstName());
    }

    @Override
    public void visitCustomer(Customer customer) {
        System.out.println("Müşteri Adı: " + customer.getFirstName() + ", Borc limiti: " + customer.getLoan().getLoanLimit());
    }
    /* Kullanım:
     * Once Customer yaratacaksin(Customer.java'ya nasıl yaratacagini yazdim)
     * BankInfoVisitor biv = new BankInfoVisitor()
       biv.visitCustomer(customer)
     * CEO için de:
     * biv.visitCEO(CEO.getInstance())
       */
    
    
    /* DAHA IYISI:
     * > Date date = new Date(31,12,2023)
> Cash cash = new Cash(1.5)
> Savings savings = new Savings(cash.getInterestRate())
> Loan loan = new Loan(cash.getInterestRate(), 30, 40)
> Customer customer = new Customer("Mert", "Kahraman", savings,loan,date)
> BankVisitor visitor = new BankInfoVisitor();
> CEO.getInstance().accept(visitor)
      Bankanın CEO'su: Mert 
> customer.accept(visitor)
      Müşteri Adı: Mert, Borc limiti: 30.0 
*/
}