package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact")
@NamedQueries({
        @NamedQuery(name = "Contact.findAll", query = "from Contact c"),
        @NamedQuery(name = "Contact.findAllWithDetails", query = "select distinct c from Contact c " +
                "left join fetch c.contactTelDetails t " +
                "left join fetch c.hobbies h"),
        @NamedQuery(name = "findById", query = "select distinct c from Contact c " +
                "left join fetch c.contactTelDetails t " +
                "left join fetch c.hobbies h where c.id=:id")
})
public class Contact implements Serializable{
    private Long id;
    private String first_name;
    private String second_name;
    private Date birth_date;
    private Set<ContactTelDetail> contactTelDetails
            = new HashSet<>();
    private Set<Hobby> hobbies
            = new HashSet<>();

    public Contact(){}
    public Contact(String first_name, String second_name, Date birth_date) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.birth_date = birth_date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "second_name")
    public String getSecond_name() {
        return second_name;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    public Date getBirth_date() {
        return birth_date;
    }

    @Column(name = "first_name")
    public String getFirst_name() {
        return first_name;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    public Set<Hobby> getHobbies(){
        return hobbies;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public void addContactTelDetail(ContactTelDetail contactTelDetail){
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }

    public void deleteContactTelDetail(ContactTelDetail contactTelDetail){
        getContactTelDetails().remove(contactTelDetail);
    }

    public void setHobbies(Set<Hobby> hobbies){
        this.hobbies = hobbies;
    }
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
