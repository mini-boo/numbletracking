package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.jasper.tagplugins.jstl.core.Url;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dailyViewBackup")
public class dailyViewBackup {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "backup_id")
    private Long backupId;

    @ManyToOne
    @JoinColumn(name = "url_id")
    private Url url;

    @Column(name = "view_date")
    private Date viewDate;

    @Column(name = "views_count")
    private Long viewsCount = 0L;
}
