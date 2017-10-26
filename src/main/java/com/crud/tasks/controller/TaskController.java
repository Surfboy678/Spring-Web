package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto>getTasks(){
        return taskMapper.mapToTaskDtoList(service.getAllTask());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public List<TaskDto> getTask(){
       return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask_duplicated")
    public TaskDto getTask(@RequestParam Long taskId){
        return new TaskDto((long)1,"test title","test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
    public void deleteTask(@RequestParam Long taskId){

    }
    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto){
        return new TaskDto((long)1,"Edited task title", "Test content");

    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    public  void createTask(@RequestBody TaskDto taskDto){
        service.saveTask(taskMapper.mapToTask(taskDto));

    }
}
