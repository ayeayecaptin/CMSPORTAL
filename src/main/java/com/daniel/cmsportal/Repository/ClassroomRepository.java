package com.daniel.cmsportal.Repository;

import com.daniel.cmsportal.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<ClassRoom, Long> {

}
