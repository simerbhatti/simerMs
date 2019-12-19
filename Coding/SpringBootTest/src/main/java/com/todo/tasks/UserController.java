package com.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  @RestController -->meaning it’s ready for use by
 * Spring MVC to handle web requests. @RequestMapping maps / to the index()
 * method. When invoked from a browser or using curl on the command line, the
 * method returns pure text. That’s because @RestController combines @Controller
 * and @ResponseBody, two annotations that results in web requests returning
 * data rather than a view.
 */

@Controller
public class UserController {

	@Autowired
	Task task;
	@GetMapping(value="/")
    public String homepage(){
        return "/index";
    }

	@GetMapping(value="/getTasks")
    public String getTasks(){
        return task.toString();
    }


}