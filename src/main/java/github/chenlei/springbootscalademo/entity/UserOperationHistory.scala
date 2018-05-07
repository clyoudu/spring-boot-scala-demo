package github.chenlei.springbootscalademo.entity

import java.util.Date

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 10:29
  * @Description UserOperationHistory
  */
class UserOperationHistory {
  private var id : String = _

  private var userId : String = _

  private var username : String = _

  private var operationType : String = _

  private var operateTime : Date = _

  def getId: String = id

  def setId(id: String): Unit = {
    this.id = id
  }

  def getUserId: String = userId

  def setUserId(userId: String): Unit = {
    this.userId = userId
  }

  def getUsername: String = username

  def setUsername(username: String): Unit = {
    this.username = username
  }

  def getOperationType: String = operationType

  def setOperationType(operationType: String): Unit = {
    this.operationType = operationType
  }

  def getOperateTime: Date = operateTime

  def setOperateTime(operateTime: Date): Unit = {
    this.operateTime = operateTime
  }
}
