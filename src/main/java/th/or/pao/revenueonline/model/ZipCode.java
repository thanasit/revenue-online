package th.or.pao.revenueonline.model;

import javax.persistence.*;

@Entity
@Table(name = "ZIP_CODE")
public class ZipCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ZIP_CODE")
    private Long zipCode;

    public Long getZipCode() {
        return zipCode;
    }

    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
}
