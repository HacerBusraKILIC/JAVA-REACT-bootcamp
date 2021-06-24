package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;

public interface EducationService {

	DataResult<List<Education>> getAllByResumeId(int id);
	
	DataResult<List<Education>> getAllByResumeId(int id, Sort sort);
	
	DataResult<Education> add(Education education);
	
}
