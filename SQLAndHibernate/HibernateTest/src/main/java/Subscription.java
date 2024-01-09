import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString(includeFieldNames=true)
@Getter
@Setter
@Entity
@Table(name = "Subscriptions")
@AllArgsConstructor
public class Subscription {

    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;

    @Column(name = "subscription_date", columnDefinition = "datetime")
    private LocalDateTime subscriptionDate;
}
