import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

import lombok.*;

@EqualsAndHashCode
@ToString(includeFieldNames=true)
@Getter
@Setter
public class SubscriptionKey implements Serializable {

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "course_id")
    private Integer courseId;


}
