package dao.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {
    private Long id;
    private String tel_type;
    private String tel_number;
    private Contact contact;

    private ContactTelDetail(){}

    public ContactTelDetail(String tel_type, String tel_number) {
        this.tel_type = tel_type;
        this.tel_number = tel_number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "tel_type")
    public String getTel_type() {
        return tel_type;
    }

    public void setTel_type(String tel_type) {
        this.tel_type = tel_type;
    }

    @Column(name = "tel_number")
    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }


    public void setContact(Contact contact){
        this.contact = contact;
    }

    @ManyToOne
    @JoinColumn(name = "contact_id")
    public Contact getContact(){
        return this.contact;
    }
    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", tel_type='" + tel_type + '\'' +
                ", tel_number='" + tel_number + '\'' +
                '}';
    }
}
