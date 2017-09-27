package th.or.pao.revenueonline.model;

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
    @Column(name = "CODE")
    private Long code;

    @NotEmpty
    @Column(name = "DISTRICT", nullable = false)
    private String districtName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    @OneToMany(mappedBy = "district")
    private List<SubDistrict> subDistricts;

    @OneToMany(mappedBy = "code")
    private List<ZipCode> zipCodes;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
}
