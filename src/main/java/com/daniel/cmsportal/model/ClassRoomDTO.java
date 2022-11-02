package com.daniel.cmsportal.model;

import lombok.Data;

@Data
public class ClassRoomDTO {
    private ClassRoom classroom;

    public ClassRoomDTO(ClassRoom classroom)
    {
        this.classroom = classroom;
    }
    public ClassRoomDTO()
    {

    }
    public Student newstudent;

}
