// ChainRes ikinci chain
public class BuyukSikayet implements ReportApprover{
  private ReportApprover nextApprover;

    @Override
    public void setNextApprover(ReportApprover approver) {
        this.nextApprover = approver;
    }

    @Override
    public void approveReport(String report) {
        System.out.println("SIKAYET BUYUK!!!");
    }
}