package th.or.pao.revenueonline.model;

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
@Table(name = "TAX_CIGARETTE")
public class TaxCigarette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAX_CIGARETTE_ID")
    private Long taxCigaretteId;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "TOTAL_PACK")
    private Integer totalPack;

    @Column(name = "TOTAL_ROLL")
    private Integer totalRoll;

    @OneToMany(mappedBy = "taxCigarette")
    private List<Tax> taxList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAX_CIGARETTE_ATTACHED_ID")
    private TaxCigaretteAttached taxCigaretteAttached;

    public Long getTaxCigaretteId() {
        return taxCigaretteId;
    }

    public void setTaxCigaretteId(Long taxCigaretteId) {
        this.taxCigaretteId = taxCigaretteId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTotalPack() {
        return totalPack;
    }

    public void setTotalPack(Integer totalPack) {
        this.totalPack = totalPack;
    }

    public Integer getTotalRoll() {
        return totalRoll;
    }

    public void setTotalRoll(Integer totalRoll) {
        this.totalRoll = totalRoll;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    public TaxCigaretteAttached getTaxCigaretteAttached() {
        return taxCigaretteAttached;
    }

    public void setTaxCigaretteAttached(TaxCigaretteAttached taxCigaretteAttached) {
        this.taxCigaretteAttached = taxCigaretteAttached;
    }

    @Override
    public String toString() {
        return "TaxCigarette{" +
                "taxCigaretteId=" + taxCigaretteId +
                ", number=" + number +
                ", totalPack=" + totalPack +
                ", totalRoll=" + totalRoll +
                ", taxList=" + taxList +
                ", taxCigaretteAttached=" + taxCigaretteAttached +
                '}';
    }
}
