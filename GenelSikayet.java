// ChainRes halka bir
public class GenelSikayet implements ReportApprover{
  private ReportApprover nextApprover;

    @Override
    public void setNextApprover(ReportApprover approver) {
        this.nextApprover = approver;
    }

    @Override
    public void approveReport(String report) {
        if (report.length() <= 10) {
            System.out.println("Kucuk bir sikayet");
        } else if (nextApprover != null) {
            nextApprover.approveReport(report);
        } else {
            System.out.println("Sikayet Taninmadi");
        }
    }
}