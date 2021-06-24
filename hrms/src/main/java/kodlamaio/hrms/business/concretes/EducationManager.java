package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;
	
	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAllByResumeId(int id) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByResumeId(id));
	}
	
	@Override
	public DataResult<List<Education>> getAllByResumeId(int id, Sort sort) {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAllByResumeId(id, sort));
	}
	
	@Override
	public DataResult<Education> add(Education education) {
		this.educationDao.save(education);
		return new SuccessDataResult<Education>("Data eklendi");
	}	

}
