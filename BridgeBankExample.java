//Bridge desen maini
public class BridgeBankExample {
    public static void main(String[] args) {
      //Tekli bir Customer yaratabilmek icin bos özellikler yarattim.
        Date dateBos1 = new Date(0,0,0);
        Cash cashBos1 = new Cash(0);
        Savings savingsBos1 = new Savings(cashBos1.getInterestRate());
        Loan loanBos1 = new Loan(cashBos1.getInterestRate(), 0, 0);
    
        BridgeBankSystem customerDetails = new Customer("Ayşe","Yılmaz", savingsBos1, loanBos1, dateBos1);
        BridgeBankSystem ceoDetails = CEO.getInstance();
        BridgeBankSystem activeCustomerDetails = new Customer("Yeni","Milyoner", new Savings(1000), new Loan(55, 40000,10), new Date(20,11,2024));

        BridgeBankUser customer = new PassiveMember(customerDetails);
        BridgeBankUser ceo = new ActiveMember(ceoDetails);
        BridgeBankUser newmember= new ActiveMember(activeCustomerDetails);

        customer.showInfo();
        System.out.println(" //////////////////////////////////// ");
        ceo.showInfo();
        System.out.println(" //////////////////////////////////// ");
        newmember.showInfo();
    }
}