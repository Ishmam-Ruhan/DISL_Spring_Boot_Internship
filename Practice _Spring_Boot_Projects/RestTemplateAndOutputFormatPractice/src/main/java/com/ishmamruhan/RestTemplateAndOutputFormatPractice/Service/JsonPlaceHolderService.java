package com.ishmamruhan.RestTemplateAndOutputFormatPractice.Service;

import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Model.ToDo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JsonPlaceHolderService {
    /*
    * ToDo API
    */
    List<ToDo> getListofTodo();

    void saveListOfTodoToDb(List<ToDo> toDoList);

    List<ToDo> getSpecificUserTodo(Long userId);

    List<ToDo> getSpecificUserTodoWithCompleteStatus(Boolean status, Long id);

    ToDo addToDo(ToDo toDo);
}
