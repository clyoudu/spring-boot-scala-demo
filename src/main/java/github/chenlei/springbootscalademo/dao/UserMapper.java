package github.chenlei.springbootscalademo.dao;


import github.chenlei.springbootscalademo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User,String> {
}