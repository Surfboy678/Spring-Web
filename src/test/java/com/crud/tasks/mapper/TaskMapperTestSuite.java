package com.crud.tasks.mapper;


import com.crud.tasks.domian.Task;
import com.crud.tasks.domian.TaskDto;
import com.crud.tasks.domian.mapper.TaskMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testMapToTask(){
      TaskDto taskDto = new TaskDto(2l, "title1","content");

      Task task = taskMapper.mapToTask(taskDto);


      Assert.assertTrue(task.getId().equals(taskDto.getId()));
      Assert.assertTrue(task.getTitle().equals(taskDto.getTitle()));
      Assert.assertTrue(task.getContent().equals(taskDto.getContent()));
    }
    @Test
    public void shouldMapToTaskDto() {
        TaskMapper taskMapper = new TaskMapper();
        Task task = new Task(1l, "task", "content");

        TaskDto taskDto = taskMapper.mapToTaskDto(task);


        assertEquals("task", taskDto.getTitle());
        assertEquals("content", taskDto.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        TaskMapper taskMapper = new TaskMapper();
        Task task1 = new Task(1l, "task1", "content1");
        Task task2 = new Task(2l, "task2", "content2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);
        taskList.add(task2);

        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        assertEquals(2, taskDtoList.size());
        assertEquals("task1", taskDtoList.get(0).getTitle());
    }
}





