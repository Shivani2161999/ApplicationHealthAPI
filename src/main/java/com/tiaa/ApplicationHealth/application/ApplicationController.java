package com.tiaa.ApplicationHealth.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/getApplicationNames")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.findAllApplication();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("{appId}/name")
    public Optional<Application> getApplication(Long appId) {
        //Check if an application exists and return
        Optional<Application> application = applicationService.findApplicationById(appId);
        return application;
    }

    @PostMapping("/new")
    public ResponseEntity<ArrayList<Object>> addApplication(@RequestBody Application application){
        Application newApplication =applicationService.addApplication(application);
        ArrayList<Object> response = new ArrayList<>();
        response.add(newApplication.getAppId());
        response.add(newApplication.getApplicationName());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/newApps")
    public ResponseEntity<List<HashMap<String,Object>>> addApplications(@RequestBody List<Application> applications){
        //Todo: Get application by id api(Done)
        //Loop array , check each entry available in db or not by get api
        //If available :
        //     add id and name to response array
        //If not available:
        //     create new entry , assign id and name and add it to response array

        List<Application> allApplications = applicationService.addAllApplications(applications);
        List<HashMap<String,Object>> response= new ArrayList<>();


        for(Application app: allApplications){
            HashMap<String,Object> temp = new HashMap<String, Object>();
            temp.put("appId",app.getAppId());
            temp.put("applicationName",app.getApplicationName());

            response.add(temp);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
