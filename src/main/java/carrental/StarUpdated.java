package carrental;

public class StarUpdated extends AbstractEvent {

    private Long id;
    private String carNo;
    private String stars;
    private String resrvNo;

    public StarUpdated(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }
    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }
    public String getResrvNo() {
        return resrvNo;
    }

    public void setResrvNo(String resrvNo) {
        this.resrvNo = resrvNo;
    }
}
