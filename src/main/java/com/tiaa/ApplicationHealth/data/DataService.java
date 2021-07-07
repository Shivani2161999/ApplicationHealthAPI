package com.tiaa.ApplicationHealth.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private DataRepo dataRepo;

    @Autowired
    public DataService(DataRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    public List<Data> getAllData(Long appId){
        List<Data> data = new ArrayList<>();
        dataRepo.findByApplicationAppId(appId).forEach(data::add);
        return data;
    }

    public Data addData(Data data){
        return dataRepo.save(data);
    }

    public List<Data> addAllDatas(List<Data> datas){ return dataRepo.saveAll(datas); }

}
