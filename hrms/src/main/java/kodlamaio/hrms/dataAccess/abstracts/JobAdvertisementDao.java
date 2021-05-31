package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getByIsActive(boolean isActive);

	List<JobAdvertisement> getByEmployerIdAndIsActiveTrue(int employerId);

    @Transactional
	@Modifying
	@Query("update JobAdvertisement j set j.isActive=:isActive where j.id=:id")
	void updateIsActive(@Param("isActive") boolean isActive,
			@Param("id") int id);
}
