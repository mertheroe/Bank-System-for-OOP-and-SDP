// Abstraction sınıfı
//BridgeBankSystem ile Köpru(Bridge) kuruyor.
//iki cesit user var, ActiveMember ve PassiveMember(bu abstract classi extendlemelerinden anliyoruz)
public abstract class BridgeBankUser {
    protected BridgeBankSystem bankSystem;

    protected BridgeBankUser(BridgeBankSystem bankSystem) {
        this.bankSystem = bankSystem;
    }

    public abstract void showInfo();
}