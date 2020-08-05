package carrental;

public class CarRentalCanceled extends AbstractEvent {

    private Long id;
    private String resrvNo;
    private String rentalNo;
    private String carNo;
    private String rentalCncleDt;
    private String paymtNo;
    private String procStatus;
    private String brwerCustNoNA;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getResrvNo() {
        return resrvNo;
    }

    public void setResrvNo(String resrvNo) {
        this.resrvNo = resrvNo;
    }
    public String getRentalNo() {
        return rentalNo;
    }

    public void setRentalNo(String rentalNo) {
        this.rentalNo = rentalNo;
    }
    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
    public String getRentalCncleDt() {
        return rentalCncleDt;
    }

    public void setRentalCncleDt(String rentalCncleDt) {
        this.rentalCncleDt = rentalCncleDt;
    }
    public String getPaymtNo() {
        return paymtNo;
    }

    public void setPaymtNo(String paymtNo) {
        this.paymtNo = paymtNo;
    }
    public String getProcStatus() {
        return procStatus;
    }

    public void setProcStatus(String procStatus) {
        this.procStatus = procStatus;
    }
    public String getBrwerCustNoNa() {
        return brwerCustNoNA;
    }

    public void setBrwerCustNoNa(String brwerCustNoNA) {
        this.brwerCustNoNA = brwerCustNoNA;
    }
}