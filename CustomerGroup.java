// Grup müşteri sınıfı
//diyelim ki 5 kişi ortak hesap açıyorlar
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class CustomerGroup implements CustomerComponent {
  //customers adinda bir array listesi olusturuyor. Icerigi CustomerComponent implemente edenler.
    private List<CustomerComponent> customers = new ArrayList<>();

    //customers arraylistine ekleme yapiyor.
    public void addCustomer(CustomerComponent customer) {
        customers.add(customer);
    }

    //CustomerComponent override'i
    @Override
    public void displayCustomerInfo() {
        for (CustomerComponent customer : customers) {
            customer.displayCustomerInfo();
        }
    }
    //customersi alabilmek icin getter
    public List<CustomerComponent> getCustomers(){
     return customers;
    }
}