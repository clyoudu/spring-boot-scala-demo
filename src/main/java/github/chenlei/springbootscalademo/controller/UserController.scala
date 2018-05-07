package github.chenlei.springbootscalademo.controller

import com.alibaba.fastjson.JSON
import github.chenlei.springbootscalademo.entity.User
import github.chenlei.springbootscalademo.service.UserService
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestBody, RequestMapping, RequestMethod, RestController}

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 15:15
  * @Description UserController
  */
@RestController
@RequestMapping(value = Array("user"))
class UserController @Autowired()(val userService: UserService = null) {
  private val LOGGER : Logger = LoggerFactory.getLogger(classOf[UserController])

  @RequestMapping(value = Array("create"),method = Array(RequestMethod.POST))
  def create(@RequestBody paramJson : String): User ={
    LOGGER.info("创建用户参数：{}",paramJson)

    userService.createUser(JSON.parseObject(paramJson,classOf[User]))
  }
}
