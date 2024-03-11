 // ChainResponsibility uygulama
public class SikayetOnay {
    public static void main(String[] args) {
   // Zinciri oluştur
        ReportApprover genelSikayet = new GenelSikayet();
        ReportApprover buyukSikayet = new BuyukSikayet();

        genelSikayet.setNextApprover(buyukSikayet);

        // Sikayet onaylanıyor
        genelSikayet.approveReport("123456789");
        genelSikayet.approveReport("12345678910");
        // 10dan sonrası ve öncesi
        //icin farkli handler (class) kullaniyor 
 }
}
        
      
    

