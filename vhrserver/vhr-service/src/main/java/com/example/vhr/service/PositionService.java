package com.example.vhr.service;

import com.example.vhr.mapper.PositionMapper;
import com.example.vhr.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PositionService {

    @Autowired
    PositionMapper positionMapper;
    public List<Position> getAllPositions() {
        return  positionMapper.getAllPositions();
    }

    public int addPosition(Position position) {
        position.setEnabled(true);
        position.setCreateDate(new Date());
        return positionMapper.insert(position);
    }

    public int deletePosition(Position position) {
        int id = position.getId();
        return positionMapper.deleteByPrimaryKey(id);
    }

    public int updatePosition(Position position) {
        return positionMapper.updateByPrimaryKey(position);
    }

    public int deleteBatchPosition(int[] arr) {
        return positionMapper.deleteByPrimaryKeyBatch(arr);
    }
}
