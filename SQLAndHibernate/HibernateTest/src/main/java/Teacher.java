import jakarta.persistence.*;
import lombok.*;

@ToString(includeFieldNames=true)
@Getter
@Setter
@Entity
@Table(name = "teachers")
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String name;
    private Integer salary;
    private Integer age;
}
