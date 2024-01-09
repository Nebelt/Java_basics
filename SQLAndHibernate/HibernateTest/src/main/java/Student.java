import jakarta.persistence.*;

import java.util.Date;

import lombok.*;

@ToString(includeFieldNames=true)
@Getter
@Setter
@Entity
@Table(name = "Students")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;



    private Integer age;

    @Column(name = "registration_date")
    private Date registrationDate;

    public Integer getAge() {
        return age;
    }
}
