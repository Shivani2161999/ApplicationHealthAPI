package com.tiaa.ApplicationHealth.data;

import com.tiaa.ApplicationHealth.activity.GetApplicationIds;
import com.tiaa.ApplicationHealth.alert.parameters.ParameterValueChecker;
import com.tiaa.ApplicationHealth.application.Application;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/application")
public class DataController {
    private final DataService dataService;
    private ParameterValueChecker parameterValueChecker = new ParameterValueChecker();
    
    public List<Long> appIdList;
    private GetApplicationIds getApplicationIds=new GetApplicationIds();
    
    
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }


    //return list of data of specified application 
    @GetMapping("/{appId}/data")
    public ResponseEntity<List<Data>> getData(@PathVariable Long appId){
        return new ResponseEntity<>(dataService.getAllData(appId), HttpStatus.OK);
    }

    @PostMapping("/{appId}/data")
    public ResponseEntity<?> addData(@RequestBody Data data, @PathVariable Long appId){
        //Add application id to data
        data.setApplication(new Application(appId,"","","",""));

        //Check if the parameters are above limit
        parameterValueChecker.checkParameters(data);

        Data newData = dataService.addData(data);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/data")
    public ResponseEntity<?> addAllData(@RequestBody List<Data> datas){
    	appIdList=new ArrayList<>();
        for(Data data: datas){
            data.setApplication(new Application(data.getApplicationID(),"","","",""));
            parameterValueChecker.checkParameters(data);
            appIdList.add(data.getApplicationID());
        }
        dataService.addAllDatas(datas);
        
        //check for all ids and activity update
        getApplicationIds.checkAllIds(appIdList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
