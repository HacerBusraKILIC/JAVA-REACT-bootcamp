package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;
import java.util.Date;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resume_educations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonIgnore
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
	@Column(name = "school_name")
	@NotBlank(message = "Boş geçilemez")
	private String schoolName;
	
	@ManyToOne(targetEntity = Graduate.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "graduate_id", referencedColumnName = "id", nullable = false)
	private Graduate graduate;
	
	@Column(name = "department_name")
	@NotBlank(message = "Boş geçilemez")
	private String departmentName;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "start_date")
	@NotNull(message = "Boş geçilemez")
	private Date startDate;
	
	@Column(name = "graduate_date")
	private Date graduateDate;
	
	@Column(name = "is_graduate")
	private boolean isGraduate; 
}
