import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Hem Customer hem de CustomerGroup iceren buyuk bir customer.
public class CustomerS implements CustomerComponent {
    private CustomerComponent customerComponent;
    //Tekli bir Customer yaratabilmek icin bos özellikler yarattim.
    Date dateBos = new Date(0,0,0);
    Cash cashBos = new Cash(0);
    Savings savingsBos = new Savings(cashBos.getInterestRate());
    Loan loanBos = new Loan(cashBos.getInterestRate(), 0, 0);

    //Olusturulan CustomerS bir CustomerGroup mu yoksa Customer mı kontrolu yapiyor
    //Eger grupsa CustomerGroup sinifinden bir customerComponent nesnesi olusturuyor,
    //degilse Customer sinifindan degerleri sifir olan bir customerComponent olusturuyor.
    public CustomerS(boolean isGroup) {
        if (isGroup) {
            customerComponent = new CustomerGroup();
        } else {
            customerComponent = new Customer("Individual", "Customer", savingsBos, loanBos, dateBos); //**************
        }
    }
    //gelen CustomerComponent'i customerComponent(CustomerGroup'a donusuturup) ismindeki CustomerGroup'a ekliyor.
    public void addCustomer(CustomerComponent customer) {
        ((CustomerGroup) customerComponent).addCustomer(customer);
    }
    //CustomerComponent override
    @Override
    public void displayCustomerInfo() {
        customerComponent.displayCustomerInfo();
    }
    //iterator alma methodu
    public Iterator<CustomerComponent> getIterator() {
        if (customerComponent instanceof CustomerGroup) {
            return new CustomerIterator(((CustomerGroup) customerComponent).getCustomers());
        } else {
            return null;
        }
    }
   //main methodu
    public static void main(String[] args) {
      //iki tane bireysel CustomerS yaratiyor
        CustomerS individual1 = new CustomerS(false);
        CustomerS individual2 = new CustomerS(false);
        
     //bir tane CustomerS grubu olusturuyor, onceki iki bireyi ekliyor.
        CustomerS group1 = new CustomerS(true);
        group1.addCustomer(individual1);
        group1.addCustomer(individual2);
        
     //ikinci bir CustomerS grubu olusturuyor ve grup biri bunun icine ekliyor.
        CustomerS group2 = new CustomerS(true);
        group2.addCustomer(group1);

        // grup2'deki customer bilgisi gosteriyor.
        group2.displayCustomerInfo();
        // grup2 ile siradakileri ayırmak icin print attiriyorum
        System.out.println("AYIRAÇ");

        // CustomerS arasinda gezmek icin iterator kullaniliyor.
        // Her iterator gezdiginde "AYIRAÇ"tan sonra siradaki musteri adi bilgisi donuyor.
        Iterator<CustomerComponent> iterator = group2.getIterator();
        if (iterator != null) {
            while (iterator.hasNext()) {
                iterator.next().displayCustomerInfo();
            }
        }
    }
}
