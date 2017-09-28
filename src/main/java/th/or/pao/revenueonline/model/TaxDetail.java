package th.or.pao.revenueonline.model;

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
@Table(name = "TAX_DETAIL")
public class TaxDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAX_DETAIL_ID")
    private Long taxDetailId;

    @Column(name = "NUMBER")
    private Integer number;

    @Column(name = "COMPANY_TYPE")
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(name = "DETAIL")
    private String detail;

    @Column(name = "QTY_KILO")
    private Double qtyKilo;

    @Column(name = "QTY_PACK")
    private Integer qtyPack;

    @Column(name = "QTY_ROLL")
    private Integer qtyRoll;

    @Column(name = "AMOUNT")
    private Double amount;

    @OneToMany(mappedBy = "taxDetail")
    private List<Tax> taxList;

    public Long getTaxDetailId() {
        return taxDetailId;
    }

    public void setTaxDetailId(Long taxDetailId) {
        this.taxDetailId = taxDetailId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getQtyKilo() {
        return qtyKilo;
    }

    public void setQtyKilo(Double qtyKilo) {
        this.qtyKilo = qtyKilo;
    }

    public Integer getQtyPack() {
        return qtyPack;
    }

    public void setQtyPack(Integer qtyPack) {
        this.qtyPack = qtyPack;
    }

    public Integer getQtyRoll() {
        return qtyRoll;
    }

    public void setQtyRoll(Integer qtyRoll) {
        this.qtyRoll = qtyRoll;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Tax> getTaxList() {
        return taxList;
    }

    public void setTaxList(List<Tax> taxList) {
        this.taxList = taxList;
    }

    @Override
    public String toString() {
        return "TaxDetail{" +
                "taxDetailId=" + taxDetailId +
                ", number=" + number +
                ", companyType=" + companyType +
                ", detail='" + detail + '\'' +
                ", qtyKilo=" + qtyKilo +
                ", qtyPack=" + qtyPack +
                ", qtyRoll=" + qtyRoll +
                ", amount=" + amount +
                ", taxList=" + taxList +
                '}';
    }
}
