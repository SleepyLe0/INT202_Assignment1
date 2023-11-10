package int202.assignment1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Offices")
@NamedQueries({
        @NamedQuery(name = "OFFICE.FIND_ALL",
                query = "select o from Office o "),
        @NamedQuery(name = "OFFICE.SEARCH_ALL",
                query = "select o from Office o where o.officeCode like :search or o.city like :search or o.phone like :search or o.addressLine1 like :search or o.addressLine2 like :search or o.state like :search or o.country like :search or o.postalCode like :search or o.territory like :search")
})
public class Office {
    @Id
    private String officeCode;
    private String city;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String state;
    private String country;
    private String postalCode;
    private String territory;

    public Office() {
    }

    public Office(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state, String country, String postalCode, String territory) {
        this.officeCode = officeCode;
        this.city = city;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.territory = territory;
    }
}
