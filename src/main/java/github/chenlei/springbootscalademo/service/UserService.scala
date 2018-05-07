package github.chenlei.springbootscalademo.service

import java.util.{Date, UUID}
import javax.annotation.PostConstruct

import github.chenlei.springbootscalademo.dao.{UserMapper, UserOperationHistoryMapper}
import github.chenlei.springbootscalademo.entity.{User, UserOperationHistory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 15:16
  * @Description UserController
  */
@Service
class UserService extends BaserService[User,String] {
  @Autowired protected val userOperationHistoryMapper : UserOperationHistoryMapper = null
  @Autowired override protected val baseMapper : UserMapper = null

  @Transactional
  def createUser(user: User) : User = {
    user.setId(UUID.randomUUID().toString)
    user.setRegisterTime(new Date)
    baseMapper.insertSelective(user)

    val userOperationHistory : UserOperationHistory = new UserOperationHistory
    userOperationHistory.setId(UUID.randomUUID().toString)
    userOperationHistory.setOperationType("register")
    userOperationHistory.setOperateTime(user.getRegisterTime)
    userOperationHistory.setUsername(user.getUsername)
    userOperationHistory.setUserId(user.getId)
    userOperationHistoryMapper.insertSelective(userOperationHistory)

    user
  }
}
