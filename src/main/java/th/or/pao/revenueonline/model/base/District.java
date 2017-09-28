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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "DISTRICT")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISTRICT_ID")
    private Long districtId;

    @Column(name = "CODE")
    private String code;

    @NotEmpty
    @Column(name = "DISTRICT", nullable = false)
    private String districtName;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    @OneToMany(mappedBy = "district")
    private List<SubDistrict> subDistricts;

    @OneToMany(mappedBy = "code")
    private List<PostalCode> postalCodes;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public List<SubDistrict> getSubDistricts() {
        return subDistricts;
    }

    public void setSubDistricts(List<SubDistrict> subDistricts) {
        this.subDistricts = subDistricts;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<PostalCode> getPostalCodes() {
        return postalCodes;
    }

    public void setPostalCodes(List<PostalCode> postalCodes) {
        this.postalCodes = postalCodes;
    }

    @Override
    public String toString() {
        return "District{" +
                "districtId=" + districtId +
                ", code='" + code + '\'' +
                ", districtName='" + districtName + '\'' +
                ", isActive=" + isActive +
                ", province=" + province +
                ", subDistricts=" + subDistricts +
                ", postalCodes=" + postalCodes +
                '}';
    }
}
