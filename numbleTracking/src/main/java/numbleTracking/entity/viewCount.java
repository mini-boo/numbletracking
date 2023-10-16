package numbleTracking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "viewcount")
public class viewCount {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "viewcount_seq_gen")
	@SequenceGenerator(name = "viewcount_seq_gen", sequenceName = "viewcount_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "url")
    private String url;

    @Column(name = "daily_hit")
    private Long dailyHit;

    @Column(name = "total_hit")
    private Long totalHit;

    @Column(name = "average_hit")
    private Long averageHit;
}
