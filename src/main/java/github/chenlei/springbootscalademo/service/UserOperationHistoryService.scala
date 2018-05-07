package github.chenlei.springbootscalademo.service

import javax.annotation.PostConstruct

import github.chenlei.springbootscalademo.dao.UserOperationHistoryMapper
import github.chenlei.springbootscalademo.entity.UserOperationHistory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 14:46
  * @Description UserOperationHistoryService
  */
@Service
class UserOperationHistoryService extends BaserService[UserOperationHistory,String]  {
  @Autowired override val baseMapper : UserOperationHistoryMapper = null
}
