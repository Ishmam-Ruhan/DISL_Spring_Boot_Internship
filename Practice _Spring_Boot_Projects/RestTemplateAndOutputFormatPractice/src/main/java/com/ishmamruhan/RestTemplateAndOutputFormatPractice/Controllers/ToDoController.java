package com.ishmamruhan.RestTemplateAndOutputFormatPractice.Controllers;

import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Model.ToDo;
import com.ishmamruhan.RestTemplateAndOutputFormatPractice.Service.JsonPlaceHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ToDoController {

    @Autowired
    private JsonPlaceHolderService jsonPlaceHolderService;

    @RequestMapping(
            path = "/get/id/{id}",
            produces = { "application/json","application/xml" },
            method = RequestMethod.GET)
    public ResponseEntity<List<ToDo>> getAllToDoOfSpecificUser(@RequestParam(required = false) Boolean completed, @PathVariable Long id){

        if(completed != null){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(jsonPlaceHolderService.getSpecificUserTodoWithCompleteStatus(completed,id));
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jsonPlaceHolderService.getSpecificUserTodo(id));
    }

    @RequestMapping(
            path = "/add",
            produces = { "application/json","application/xml" },
            method = RequestMethod.POST)
    public ResponseEntity<ToDo> posttodo(@RequestParam(required = false) Boolean completed, @RequestBody ToDo toDo){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(jsonPlaceHolderService.addToDo(toDo));
    }

}
