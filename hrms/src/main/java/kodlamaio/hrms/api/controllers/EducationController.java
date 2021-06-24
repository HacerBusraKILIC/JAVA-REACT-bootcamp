package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Education;

@RestController
@RequestMapping("api/education/")
public class EducationController {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
	
	@GetMapping("resume-id/{resumeId}")
	public DataResult<List<Education>> getAllByResumeId(@PathVariable("resumeId") int resumeId){
		return this.educationService.getAllByResumeId(resumeId);
	}
	
	@GetMapping("resume-id/{resumeId}/order")
	public DataResult<List<Education>> getAllByResumeIdOrderBy(@PathVariable("resumeId") int resumeId, Sort direciton ){
		return this.educationService.getAllByResumeId(resumeId, direciton);
	}
	
	@PostMapping("add")
	public ResponseEntity<DataResult<Education>> add(@Valid @RequestBody Education education) {
		DataResult<Education> result = this.educationService.add(education);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
