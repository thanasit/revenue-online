package th.or.pao.revenueonline.model.base;

import org.hibernate.validator.constraints.NotEmpty;
import th.or.pao.revenueonline.model.enumeration.CompanyType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long companyId;

    @NotEmpty
    @Column(name = "COMPANY_NAME", nullable = false)
    private String companyName;

    @Column(name = "BRANCH_NAME")
    private String branchName;

    @Column(name = "TAX_PAYER")
    private String taxPayer;

    @Column(name = "COM_REGISTRATION_CER")
    private String comRegistrationCer;

    @Column(name = "COMPANY_TYPE")
    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;

    @NotEmpty
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getTaxPayer() {
        return taxPayer;
    }

    public void setTaxPayer(String taxPayer) {
        this.taxPayer = taxPayer;
    }

    public String getComRegistrationCer() {
        return comRegistrationCer;
    }

    public void setComRegistrationCer(String comRegistrationCer) {
        this.comRegistrationCer = comRegistrationCer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", branchName='" + branchName + '\'' +
                ", taxPayer='" + taxPayer + '\'' +
                ", comRegistrationCer='" + comRegistrationCer + '\'' +
                ", companyType=" + companyType +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", province=" + province +
                '}';
    }
}
