package th.or.pao.revenueonline.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TAX_CONFIGURE")
public class TaxConfigure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERCENTAGE_TAX_ID")
    private Long percentageTaxId;

    @NotEmpty
    @Column(name = "PERCENTAGE_TAX", nullable = false)
    private Integer percentageTax;

    @OneToMany(mappedBy = "taxConfigure")
    private List<Tax> taxList;

    public Long getPercentageTaxId() {
        return percentageTaxId;
    }

    public void setPercentageTaxId(Long percentageTaxId) {
        this.percentageTaxId = percentageTaxId;
    }

    public Integer getPercentageTax() {
        return percentageTax;
    }

    public void setPercentageTax(Integer percentageTax) {
        this.percentageTax = percentageTax;
    }
}
