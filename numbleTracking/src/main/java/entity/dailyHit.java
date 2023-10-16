package entity;

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
public class dailyHit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dailyhit_seq_gen")
	@SequenceGenerator(name = "dailyhit_seq_gen", sequenceName = "dailyhit_sequence", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "viewcount_id")
    private Long viewcountId;

    @Column(name = "daily_hit")
    private Long dailyHit;

    @Column(name = "hit_date")
    private Date hitDate;
    
    @ManyToOne
    @JoinColumn(name = "viewcount_id")
    private viewCount viewCount;
}
