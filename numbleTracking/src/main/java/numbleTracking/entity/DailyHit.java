package numbleTracking.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dailyhit")
public class DailyHit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dailyhit_seq_gen")
	@SequenceGenerator(name = "dailyhit_seq_gen", sequenceName = "dailyhit_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

	@ManyToOne
    @JoinColumn(name = "viewcount_id")
    private ViewCount viewCount;

    @Column(name = "daily_hit")
    private Long dailyHit;

    @Column(name = "hit_date")
    @Temporal(TemporalType.DATE)
    private Date hitDate;
    
    
}
