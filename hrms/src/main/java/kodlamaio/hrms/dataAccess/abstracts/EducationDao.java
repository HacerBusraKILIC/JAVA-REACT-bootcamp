package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.domain.Sort;

public interface EducationDao extends JpaRepository<Education, Integer> {

	List<Education> findAllByResumeId(int id);
	
	List<Education> findAllByResumeId(int id, Sort sort);
}
