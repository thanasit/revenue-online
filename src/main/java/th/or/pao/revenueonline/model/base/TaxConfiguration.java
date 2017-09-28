package th.or.pao.revenueonline.model.base;

import th.or.pao.revenueonline.model.Tax;
import th.or.pao.revenueonline.model.enumeration.CompanyType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TAX_CONFIGURATION")
public class TaxConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAX_CONFIGURATION_ID")
    private Long taxConfigurationId;

    @Column(name = "TAX_RATE", nullable = false)
    private Double taxRate;

    @Column(name = "TAX_RATE_TYPE")
    @Enumerated(EnumType.STRING)
    private CompanyType taxRateType;

    @OneToMany(mappedBy = "taxConfiguration")
    private List<Tax> taxList;

    public Long getTaxConfigurationId() {
        return taxConfigurationId;
    }

    public void setTaxConfigurationId(Long taxConfigurationId) {
        this.taxConfigurationId = taxConfigurationId;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public CompanyType getTaxRateType() {
        return taxRateType;
    }

    public void setTaxRateType(CompanyType taxRateType) {
        this.taxRateType = taxRateType;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    @Override
    public String toString() {
        return "TaxConfiguration{" +
                "taxConfigurationId=" + taxConfigurationId +
                ", taxRate=" + taxRate +
                ", taxRateType=" + taxRateType +
                ", taxList=" + taxList +
                '}';
    }
}
