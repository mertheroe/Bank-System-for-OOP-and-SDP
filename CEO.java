//Mert KAHRAMAN 190101028
// tekli CEO SINGLETON
//visitor overrideini sona koydum
//visitor icin BankSiniflar'i implemente etti
public class CEO extends Object implements BankSiniflar, BridgeBankSystem{
   // İlk ve tek örnek
    private static CEO instance;
    private String CEOFirstName;
    private String CEOLastName;

    // Constructor gizlendi
    private CEO() {
      this.CEOFirstName = "Mert";
      this.CEOLastName = "Kahraman";
    }
    //  CEO mertCEO = CEO.getInstance() ile instance'i mertCEO adinda baskabir nesnede gosterebiliyorum
    // CEO.getInstance().getCEOFirstName() ile instancei direktcagirabiliyorum.
    // Singleton örneğine erişim metodu
    public static CEO getInstance() {
        if (instance == null) {
            instance = new CEO();
        }
        return instance;
    }
    //Instance olusturuldu mu garanti denemek icin
    public String getCEOFirstName(){
      return CEOFirstName;
    }
    
    public String getCEOLastName(){
      return CEOLastName;
    }
    
    //Visitor icin override(BankSiniflardan gelen)
    @Override
    public void accept(BankVisitor visitor) {
        visitor.visitCEO(this);
    }
    //BridgeBankSystem override
    @Override
    public void showDetails() {
        System.out.println("CEO Tam Adı: " + this.getCEOFirstName() + " " + this.getCEOLastName());
    }

}