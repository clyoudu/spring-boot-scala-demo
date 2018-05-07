package github.chenlei.springbootscalademo.config

import javax.servlet.{Filter, Servlet}

import com.alibaba.druid.support.http.{StatViewServlet, WebStatFilter}
import org.springframework.boot.web.servlet.{FilterRegistrationBean, ServletRegistrationBean}
import org.springframework.context.annotation.{Bean, Configuration}

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 11:07
  * @Description DruidMonitorConfig
  */
@Configuration
class DruidMonitorConfig {
  /**
    * 注册ServletRegistrationBean
    *
    * @return
    */
  @Bean
  def registrationBean: ServletRegistrationBean[StatViewServlet] = {
    val bean : ServletRegistrationBean[StatViewServlet] = new ServletRegistrationBean(new StatViewServlet, "/druid/*")

    /** 初始化参数配置，initParams **/
    //白名单
    bean.addInitParameter("allow", "127.0.0.1") //多个ip逗号隔开

    //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
    //bean.addInitParameter("deny", "192.168.1.73");
    //登录查看信息的账号密码.
    bean.addInitParameter("loginUsername", "admin")
    bean.addInitParameter("loginPassword", "123456")
    //是否能够重置数据.
    bean.addInitParameter("resetEnable", "false")
    bean
  }

  /**
    * 注册FilterRegistrationBean
    *
    * @return
    */
  @Bean
  def druidStatFilter: FilterRegistrationBean[_ <: Filter] = {
    val bean = new FilterRegistrationBean(new WebStatFilter)
    //添加过滤规则.
    bean.addUrlPatterns("/*")
    //添加不需要忽略的格式信息.
    bean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*")
    bean
  }
}
