import jakarta.persistence.*;

import java.util.Date;

import lombok.*;

@ToString(includeFieldNames=true)
@Getter
@Setter
@Entity
@Table(name = "PurchaseList")
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseList {

    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "student_name", length = 100, insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", length = 100, insertable = false, updatable = false)
    private String courseName;
    private Integer price;
    @Column(name = "subscription_date", columnDefinition ="datetime")
    private Date subscriptionDate;
}
