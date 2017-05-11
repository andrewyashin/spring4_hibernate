package dao.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby implements Serializable {
    private Long hobby_id;
    private String name;
    private Set<Contact> contacts
            = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hobby_id")
    public Long getHobby_id() {
        return hobby_id;
    }

    public void setHobby_id(Long hobby_id) {
        this.hobby_id = hobby_id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
        joinColumns = @JoinColumn(name = "hobby_id"),
        inverseJoinColumns = @JoinColumn(name = "contact_id"))
    public Set<Contact> getContacts(){
        return contacts;
    }

    public void setContacts(Set<Contact> contacts){
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hobby_id=" + hobby_id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
