package int202.assignment1.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Offices")
@NamedQueries({
        @NamedQuery(name = "OFFICE.FIND_ALL",
                query = "select o from Office o "),
        @NamedQuery(name = "OFFICE.SEARCH_ALL",
                query = "select o from Office o where o.officeCode like :search or o.city like :search or " +
                        "o.phone like :search or o.addressLine1 like :search or o.addressLine2 like :search or " +
                        "o.state like :search or o.country like :search or o.postalCode like :search or o.territory like :search")
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
}
