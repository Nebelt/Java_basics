import jakarta.persistence.Column;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@ToString(includeFieldNames=true)
@Getter
@Setter
@AllArgsConstructor
public class LinkedPurchaseListKey implements Serializable {
    @Column(name = "student_id")
    private Integer studentId;
    @Column(name = "course_id")
    private Integer courseId;

}
