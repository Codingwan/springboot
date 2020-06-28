package com.example.vhr.service;

import com.example.vhr.mapper.JObLevelMapper;
import com.example.vhr.model.JObLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JobLevelService {

    @Autowired
    JObLevelMapper jObLevelMapper;
    public List<JObLevel> getAllJobLevels() {
        return jObLevelMapper.getAllJobLevels();
    }

    public int addJobLevel(JObLevel jObLevel) {
        jObLevel.setCreatedate(new Date());
        jObLevel.setEnabled(true);
        return jObLevelMapper.insertSelective(jObLevel);
    }

    public int updateJobLevel(JObLevel jObLevel) {
        return jObLevelMapper.updateByPrimaryKeySelective(jObLevel);
    }

    public int deleteJobLevel(int id) {
        return jObLevelMapper.deleteByPrimaryKey(id);
    }

    public Integer deleteJobLevelsByIds(Integer[] ids) {
        return jObLevelMapper.deleteJobLevelsByIds(ids);
    }
}
