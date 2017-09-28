package th.or.pao.revenueonline.model.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GAS_TYPE")
public class GasType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GAS_TYPE_ID")
    private Long gasTypeId;

    @Column(name = "CODE")
    private String code;

    @Column(name = "GAS_TYPE_NAME", nullable = false)
    private String gasTypeName;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    public Long getGasTypeId() {
        return gasTypeId;
    }

    public void setGasTypeId(Long gasTypeId) {
        this.gasTypeId = gasTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGasTypeName() {
        return gasTypeName;
    }

    public void setGasTypeName(String gasTypeName) {
        this.gasTypeName = gasTypeName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "GasType{" +
                "gasTypeId=" + gasTypeId +
                ", code='" + code + '\'' +
                ", gasTypeName='" + gasTypeName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
