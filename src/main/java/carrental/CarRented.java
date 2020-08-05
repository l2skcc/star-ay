package carrental;

public class CarRented extends AbstractEvent {

    private Long id;
    private String resrvNo;
    private String carNo;
    private String rentalDt;
    private String returnDt;
    private String paymtNo;
    private String procStatus;
    private String rentalNoNA;
    private String rentalDvsnNA;
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
    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
    public String getRentalDt() {
        return rentalDt;
    }

    public void setRentalDt(String rentalDt) {
        this.rentalDt = rentalDt;
    }
    public String getReturnDt() {
        return returnDt;
    }

    public void setReturnDt(String returnDt) {
        this.returnDt = returnDt;
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
    public String getRentalNoNa() {
        return rentalNoNA;
    }

    public void setRentalNoNa(String rentalNoNA) {
        this.rentalNoNA = rentalNoNA;
    }
    public String getRentalDvsnNa() {
        return rentalDvsnNA;
    }

    public void setRentalDvsnNa(String rentalDvsnNA) {
        this.rentalDvsnNA = rentalDvsnNA;
    }
    public String getBrwerCustNoNa() {
        return brwerCustNoNA;
    }

    public void setBrwerCustNoNa(String brwerCustNoNA) {
        this.brwerCustNoNA = brwerCustNoNA;
    }
}