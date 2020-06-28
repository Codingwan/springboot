package com.example.vhr.mapper;

import com.example.vhr.model.JObLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JObLevelMapper {
    Integer deleteJobLevelsByIds(@Param("ids") Integer[] ids);

    int deleteByPrimaryKey(Integer id);

    int insert(JObLevel record);

    int insertSelective(JObLevel record);

    JObLevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JObLevel record);

    int updateByPrimaryKey(JObLevel record);

    List<JObLevel> getAllJobLevels();
}