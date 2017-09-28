package th.or.pao.revenueonline.model.base;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SUB_DISTRICT")
public class SubDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_DISTRICT_ID")
    private Long subDistrictId;

    @Column(name = "CODE")
    private String code;

    @NotEmpty
    @Column(name = "SUB_DISTRICT", nullable = false)
    private String subDistrictName;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DISTRICT_ID")
    private District district;

    public Long getSubDistrictId() {
        return subDistrictId;
    }

    public void setSubDistrictId(Long subDistrictId) {
        this.subDistrictId = subDistrictId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSubDistrictName() {
        return subDistrictName;
    }

    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "SubDistrict{" +
                "subDistrictId=" + subDistrictId +
                ", code='" + code + '\'' +
                ", subDistrictName='" + subDistrictName + '\'' +
                ", isActive=" + isActive +
                ", district=" + district +
                '}';
    }
}
