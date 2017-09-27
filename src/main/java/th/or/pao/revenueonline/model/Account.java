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
import javax.persistence.Table;


@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long accountId;

    @NotEmpty
    @Column(name = "ACCOUNT_NAME", nullable = false)
    private String accountName;

    @Column(name = "BRANCH_NAME", nullable = true)
    private String branchName;

    @Column(name = "TAX_PAYER", nullable = true)
    private String taxPayer;

    @Column(name = "REGISTRATION_CER", nullable = true)
    private String registrationCer;

    @NotEmpty
    @Column(name = "ACCOUNT_TYPE", nullable = false)
    private String accountType;

    @Column(name = "ADDRESS", nullable = true)
    private String address;

    @NotEmpty
    @Column(name = "PHONE", nullable = false)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROVINCE_ID")
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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

    public String getRegistrationCer() {
        return registrationCer;
    }

    public void setRegistrationCer(String registrationCer) {
        this.registrationCer = registrationCer;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
