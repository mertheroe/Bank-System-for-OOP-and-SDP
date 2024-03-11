// Visitor arayüzü
public interface BankVisitor {
    void visitCEO(CEO ceo);
    void visitCustomer(Customer customer);
}
