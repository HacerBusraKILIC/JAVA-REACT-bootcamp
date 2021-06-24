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
@Data
@Table(name = "resume_qualifications")
@AllArgsConstructor
@NoArgsConstructor
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(targetEntity = Resume.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name = "created_date")
	private LocalDate createdDate;
	
	@NotBlank(message = "Boş geçilemez")
	@Column(name = "description")
	private String description;
}
