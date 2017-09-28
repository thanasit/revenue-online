package th.or.pao.revenueonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "TAX_CIGARETTE_ATTACHED")
public class TaxCigaretteAttached {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAX_CIGARETTE_ATTACHED_ID")
    private Long taxCigaretteAttachedId;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "BRANCH_CODE")
    private String branchCode;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "BRANCH_ADDRESS")
    private String branchAddress;

    @Column(name = "NO_PACK")
    private String noPack;

    @Column(name = "NO_ROLL")
    private String noRoll;

    @OneToMany(mappedBy = "taxCigaretteAttached")
    private List<TaxCigarette> taxCigaretteList;

    public Long getTaxCigaretteAttachedId() {
        return taxCigaretteAttachedId;
    }

    public void setTaxCigaretteAttachedId(Long taxCigaretteAttachedId) {
        this.taxCigaretteAttachedId = taxCigaretteAttachedId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getNoPack() {
        return noPack;
    }

    public void setNoPack(String noPack) {
        this.noPack = noPack;
    }

    public String getNoRoll() {
        return noRoll;
    }

    public void setNoRoll(String noRoll) {
        this.noRoll = noRoll;
    }

    public List<TaxCigarette> getTaxCigaretteList() {
        return taxCigaretteList;
    }

    public void setTaxCigaretteList(List<TaxCigarette> taxCigaretteList) {
        this.taxCigaretteList = taxCigaretteList;
    }

    @Override
    public String toString() {
        return "TaxCigaretteAttached{" +
                "taxCigaretteAttachedId=" + taxCigaretteAttachedId +
                ", number=" + number +
                ", branchCode='" + branchCode + '\'' +
                ", branchName='" + branchName + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", noPack='" + noPack + '\'' +
                ", noRoll='" + noRoll + '\'' +
                ", taxCigaretteList=" + taxCigaretteList +
                '}';
    }
}
