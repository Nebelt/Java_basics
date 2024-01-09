import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@ToString(includeFieldNames=true)
@AllArgsConstructor
@Getter
@Setter
public class LinkedPurchaseList {
    @EmbeddedId
    private LinkedPurchaseListKey key;
    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;
    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;
}
