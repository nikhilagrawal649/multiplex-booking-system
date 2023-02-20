package com.multiplex.service;
 
import java.util.List;
 
import com.multiplex.entity.HallCapacity;
 
public interface HallCapacityService {

    public  String addHallCapacity(HallCapacity hallcapa);

    public List<HallCapacity> getAllHallCapacity();

    public HallCapacity getHallCapacityById(int hallCapacityid);

    public HallCapacity updatedHallCapacity(HallCapacity updatedHallCapacity);

    public String deleteHallCapacity(Integer hallCapacityId);

    }

