import jakarta.persistence.Column;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@ToString(includeFieldNames=true)
@Getter
@Setter
public class PurchaseListKey implements Serializable {
    @Column(name = "student_name", length = 100)
    private String studentName;
    @Column(name = "course_name", length = 100)
    private String courseName;
}
