package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resume_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@NotBlank(message = "Boş geçilemez")
	@Column(name = "company_name")
	private String companyName;
	
	@ManyToOne(targetEntity = JobTitles.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id", referencedColumnName = "id", nullable = false)
	private JobTitles jobTitle;
	
	@NotBlank(message = "Boş geçilemez")
	@Column(name = "started_date")
	private LocalDate startedDate;
	
	@Column(name = "is_continued")
	private boolean isContinued;
	
	@Column(name = "end_date")
	private LocalDate endDate;
}
