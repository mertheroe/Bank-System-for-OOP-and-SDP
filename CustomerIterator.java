// Iterator sınıfı
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//iterator implemente ediyor
public class CustomerIterator implements Iterator<CustomerComponent> {
  
    private final List<CustomerComponent> customers;
    private int position = 0;
//constructor
    public CustomerIterator(List<CustomerComponent> customers) {
        this.customers = customers;
    }
//Iterator overridei
    @Override
    public boolean hasNext() {
        return position < customers.size();
    }
//CustomerComponent interface'ini iterator ile kullaniyor
    @Override
    public CustomerComponent next() {
        if (hasNext()) {
            return customers.get(position++);
        }
        return null;
    }
}