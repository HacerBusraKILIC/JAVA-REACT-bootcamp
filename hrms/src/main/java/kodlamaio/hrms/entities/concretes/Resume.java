package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "resumes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	//@JsonIgnore
	@ManyToOne(targetEntity = Candidate.class)
	@JoinColumn(name = "candidate_id", referencedColumnName = "id", nullable = false)
	private Candidate candidate;
	
	@Column(name = "created_date",  columnDefinition = "DATE")
	private Date createdDate;
	
	@Column(name = "modified_date",  columnDefinition = "DATE")
	private Date modifiedDate;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "profile_picture_url")
	private String profilePictureUrl;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linked_link")
	private String linkedLink;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Language> languages;

	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Qualification> qualifications;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<Education> education;
	
	@JsonIgnore
	@OneToMany(mappedBy = "resume")
	private List<JobExperience> jobExperiences;
}
