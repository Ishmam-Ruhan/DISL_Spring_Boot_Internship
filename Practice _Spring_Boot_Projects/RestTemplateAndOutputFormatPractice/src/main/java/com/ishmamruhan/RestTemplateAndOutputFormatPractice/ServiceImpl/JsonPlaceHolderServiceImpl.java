package com.ishmamruhan.RestTemplateAndOutputFormatPractice.ServiceImpl;

import com.ishmamruhan.RestTemplateAndOutputFormatPractice.ExternalAPI.JsonPlaceHolder;
import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Model.ToDo;
import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Repositories.TodoRepo;
import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Service.JsonPlaceHolderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class JsonPlaceHolderServiceImpl implements JsonPlaceHolderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TodoRepo todoRepo;

    public static final Logger logger = LoggerFactory.getLogger(JsonPlaceHolderServiceImpl.class);

    @Override
    public List<ToDo> getListofTodo() {

        ResponseEntity<ToDo[]> response = restTemplate.getForEntity(JsonPlaceHolder.todoAPI, ToDo[].class);

        logger.info("Response Code: "+response.getStatusCode().toString());

        return Arrays.asList(response.getBody());
    }

    @Override
    public void saveListOfTodoToDb(List<ToDo> toDoList) {
        todoRepo.saveAll(toDoList);
        logger.info("Successfully Saved All ToDo!");
    }

    @Override
    public List<ToDo> getSpecificUserTodo(Long userId) {
        List<ToDo> userToDo = todoRepo.getToDoByUserId(userId);

        return  userToDo;
    }

    @Override
    public List<ToDo> getSpecificUserTodoWithCompleteStatus(Boolean status,Long userId) {
        List<ToDo> userToDo = todoRepo.getToDoByUserIdAndCompleteStatus(status,userId);

        return  userToDo;
    }

    @Override
    public ToDo addToDo(ToDo toDo) {

        ResponseEntity<ToDo> response = restTemplate.postForEntity(JsonPlaceHolder.todoAPI,toDo,ToDo.class);

        logger.info("Response Status: {}",response.getStatusCode());

        return response.getBody();
    }
}
