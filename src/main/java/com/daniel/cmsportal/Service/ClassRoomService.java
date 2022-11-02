package com.daniel.cmsportal.Service;

import com.daniel.cmsportal.Repository.ClassroomRepository;
import com.daniel.cmsportal.model.ClassRoom;
import com.daniel.cmsportal.model.ClassRoomDTO;
import com.daniel.cmsportal.model.Student;
import com.daniel.cmsportal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public ClassRoom save(ClassRoomDTO classroomdto)
    {

        ClassRoom existingclassroom = classroomRepository.findById(classroomdto.getClassroom().getId()).orElse(null);
        ClassRoom newclassroom = classroomdto.getClassroom();
        if(classroomdto.newstudent != null){
            existingclassroom.getStudents().add(classroomdto.getNewstudent());
        }
        existingclassroom.setNote(newclassroom.getNote());
        existingclassroom.setRoomname(newclassroom.getRoomname());
        existingclassroom.setEnddate(newclassroom.getEnddate());
        existingclassroom.setStartdate(newclassroom.getStartdate());
        existingclassroom.setMainteacher(newclassroom.getMainteacher());
        existingclassroom.setAssitantteacher(newclassroom.getAssitantteacher());
        existingclassroom.setSchoolyear(newclassroom.getSchoolyear());
        existingclassroom.setSemester(newclassroom.getSemester());


        return classroomRepository.save(existingclassroom);
    }

    public ClassRoom deleteStudent(Student student, ClassRoom classroom)
    {
        classroom.getStudents().remove(student);
        return classroomRepository.save(classroom);
    }

}
