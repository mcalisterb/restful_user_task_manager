package com.application;

import com.application.model.UserDetails;
import com.application.service.UserDetailsService;
import com.application.model.Task;
import com.application.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@RestController
@EnableAutoConfiguration
public class UserDetailsAndTasksController {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private TaskService taskService;

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsAndTasksController.class);

    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> getHome() {
        logger.info("Api request received");

        Map<String, String> response = new HashMap<String, String>();
        try {
            UserDetails userDetails = new UserDetails();
            // set userDetails ...
            userDetailsService.create(userDetails);
            response.put("status", "success");
        } catch (Exception e) {
            logger.error("Error occurred while trying to process api request", e);
            response.put("status", "fail");
        }

        return response;
    }

    @RequestMapping(value="/api/user", method = RequestMethod.GET)
    @ResponseBody
    public List<UserDetails> getUsers(){            
            logger.info("Requesting details for all users");
            List<UserDetails> userDetailsList = userDetailsService.getAllUserDetails();
            for (UserDetails udetails: userDetailsList){
                logger.info("Got " + udetails.getusername() + " " + udetails.getfirst_name() +  " " + udetails.getlast_name());
            }
            return userDetailsList;
    }

    @RequestMapping(value="/api/user/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserDetails getUserById(@PathVariable int id){            
            logger.info("Requesting user details for id=" + Integer.toString(id));
            UserDetails userDetails = userDetailsService.getUserDetailsById(id);
            logger.info("Got " + userDetails.getusername() + " " + userDetails.getfirst_name() +  " " + userDetails.getlast_name());
            return userDetails;
    }

    @RequestMapping(value="/api/user/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public UserDetails updateUserById(@PathVariable int id, @RequestBody UserDetails userDetails){    
            UserDetails currUserD = userDetailsService.getUserDetailsById(id);
            if (userDetails.getusername() == null)
                userDetails.setusername(currUserD.getusername());
            if (userDetails.getfirst_name() == null)
                userDetails.setfirst_name(currUserD.getfirst_name());
            if (userDetails.getlast_name() == null)
                userDetails.setlast_Name(currUserD.getlast_name());
                    
            logger.info("Updating user details for id=" + Integer.toString(id));
            userDetails.setID(id);
            userDetailsService.update(userDetails);
            UserDetails updatedUser =  userDetailsService.getUserDetailsById(id);
            return updatedUser;
    }

    @RequestMapping(value="/api/user", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody UserDetails userDetails){
            
            logger.info("Got " + userDetails.getusername() + " " + userDetails.getfirst_name() +  " " + userDetails.getlast_name());
            userDetailsService.create(userDetails);
            return "Success!";
    }

    ////// TASK API ///// 

    @RequestMapping(value="/api/user/{user_id}/task", method = RequestMethod.POST)
    @ResponseBody
    public String createTask(@PathVariable int user_id, @RequestBody Task task){            
            logger.info("Got " + task.getName() + " " + task.getDescription() +  " " + task.getDate_time());
            task.setUserID(user_id);
            taskService.create(task);
            return "Success!";
    }

    @RequestMapping(value="/api/user/{user_id}/task/{task_id}", method = RequestMethod.PUT)
    @ResponseBody
    public Task updateTaskById(@PathVariable int user_id, @PathVariable int task_id,  @RequestBody Task task){    
            Task currTask = taskService.getTaskById(task_id);
            if (task.getName() == null)
                task.setName(currTask.getName());
            if (task.getDescription() == null)
                task.setDescription(currTask.getDescription());
            if (task.getDate_time() == null)
                task.setDate_time(currTask.getDate_time());
                    
            logger.info("Updating task " + Integer.toString(task_id) + " for user id=" + Integer.toString(user_id));
            task.setID(task_id);
            task.setUserID(user_id);
            taskService.update(task);
            Task updatedTask =  taskService.getTaskById(task_id);
            return updatedTask;
    }

    @RequestMapping(value="/api/user/{user_id}/task/{task_id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteTask(@PathVariable int task_id){            
            logger.info("Deleting task with id=" + Integer.toString(task_id));
            taskService.delete(task_id);
            return "Success";
    }

    @RequestMapping(value="/api/user/{user_id}/task", method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getUserTasks(@PathVariable int user_id){            
            logger.info("Requesting tasks for user " + Integer.toString(user_id));
            List<Task> taskList = taskService.getAllTasks();
            
            List<Task> newList = new ArrayList<Task>();
            for (Task tsk: taskList){
                if (tsk.getUserID() == user_id)
                    newList.add(tsk);
            }

            return newList;
    }

    @RequestMapping(value="/api/user/task", method = RequestMethod.GET)
    @ResponseBody
    public List<Task> getUserTasks(){            
            logger.info("Requesting all tasks ");
            List<Task> taskList = taskService.getAllTasks();
            
            return taskList;
    }


    @RequestMapping(value="/api/user/{user_id}/task/{task_id}", method = RequestMethod.GET)
    @ResponseBody
    public Task getTaskById(@PathVariable int user_id, @PathVariable int task_id){            
            logger.info("Requesting task with id = "  + Integer.toString(task_id));
            Task task = taskService.getTaskById(task_id);
            if ((task != null) && (task.getUserID() == user_id))
                return task;
            else
                return null;
    }



}
