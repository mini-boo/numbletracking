package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "URL")
public class URL {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "url_id")
	private Long urlId;
	
	@Column(name = "url", nullable = false)
    private String url;
	
	@Column(name = "total_views")
    private Long totalViews = 0L;
	
	@Column(name = "daily_views")
    private Long dailyViews = 0L;
	
	@Column(name = "created_at")
    private Date createdAt;
}
