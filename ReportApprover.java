// ChainRes Handler arayüzü
public interface ReportApprover {
    void approveReport(String report);
    void setNextApprover(ReportApprover approver);
}