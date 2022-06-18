package com.ishmamruhan.RestTemplateAndOutputFormatPractice.Configurations.Master;

import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Model.ToDo;
import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Service.JsonPlaceHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class Init {

    @Autowired
    public JsonPlaceHolderService jsonPlaceHolderService;

    @PostConstruct
    public void init(){
        initializeToDos();
    }

    public void initializeToDos(){
        List<ToDo> toDoList = jsonPlaceHolderService.getListofTodo();
        jsonPlaceHolderService.saveListOfTodoToDb(toDoList);
    }
}
