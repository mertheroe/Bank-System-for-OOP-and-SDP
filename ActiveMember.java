// RefinedAbstraction sınıfı - CEO
class ActiveMember extends BridgeBankUser {
    public ActiveMember(BridgeBankSystem bankSystem) {
        super(bankSystem);
    }

    @Override
    public void showInfo() {
        System.out.println("Aktif Üye Bilgileri:");
        bankSystem.showDetails();
    }
}