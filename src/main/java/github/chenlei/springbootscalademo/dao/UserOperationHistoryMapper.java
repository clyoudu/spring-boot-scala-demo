package github.chenlei.springbootscalademo.dao;

import github.chenlei.springbootscalademo.entity.UserOperationHistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserOperationHistoryMapper extends BaseMapper<UserOperationHistory,String> {
}