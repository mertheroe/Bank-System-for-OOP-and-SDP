// RefinedAbstraction sınıfı - Müşteri
class PassiveMember extends BridgeBankUser {
    public PassiveMember(BridgeBankSystem bankSystem) {
        super(bankSystem);
    }

    @Override
    public void showInfo() {
        System.out.println("Pasif Üye Bilgileri:");
        bankSystem.showDetails();
    }
}