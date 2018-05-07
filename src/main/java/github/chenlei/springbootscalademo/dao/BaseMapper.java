package github.chenlei.springbootscalademo.dao;

/**
 * Create by IntelliJ IDEA
 *
 * @Author chenlei
 * @DateTime 2018/5/7 17:11
 * @Description BaseMapper
 */
public interface  BaseMapper<T,TI> {

    int deleteByPrimaryKey(TI id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(TI id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

}
