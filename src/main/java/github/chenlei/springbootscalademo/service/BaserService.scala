package github.chenlei.springbootscalademo.service

import github.chenlei.springbootscalademo.dao.BaseMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import scala.reflect.ClassTag

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 14:42
  * @Description BaserService
  */
abstract class BaserService[T : ClassTag,T1 : ClassTag] {

  protected val baseMapper: BaseMapper[T, T1] = null

  def deleteByPrimaryKey(id: T1): Int = baseMapper.deleteByPrimaryKey(id)

  def insert(record: T): Int = baseMapper.insert(record)

  def insertSelective(record: T): Int = baseMapper.insertSelective(record)

  def selectByPrimaryKey(id: T1): T = baseMapper.selectByPrimaryKey(id)

  def updateByPrimaryKeySelective(record: T): Int = baseMapper.updateByPrimaryKeySelective(record)

  def updateByPrimaryKey(record: T): Int = baseMapper.updateByPrimaryKey(record)
}
