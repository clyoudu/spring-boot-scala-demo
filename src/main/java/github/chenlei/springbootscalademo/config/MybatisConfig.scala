package github.chenlei.springbootscalademo.config

import java.util.Properties
import javax.sql.DataSource

import com.github.pagehelper.PageHelper
import org.apache.ibatis.plugin.Interceptor
import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.{SqlSessionFactoryBean, SqlSessionTemplate}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.annotation.TransactionManagementConfigurer

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 11:14
  * @Description MybatisConfig
  */
@Configuration
class MybatisConfig extends TransactionManagementConfigurer{

  @Autowired
  private val dataSource : DataSource = null

  @Bean(name = Array("sqlSessionFactory"))
  def sqlSessionFactoryBean: SqlSessionFactory = {
    val bean = new SqlSessionFactoryBean
    bean.setDataSource(dataSource)
    bean.setTypeAliasesPackage("github.chenlei.springbootscalademo.entity")
    //分页插件,插件无非是设置mybatis的拦截器
    val pageHelper = new PageHelper
    val properties = new Properties
    properties.setProperty("offsetAsPageNum", "true")
    properties.setProperty("rowBoundsWithCount", "true")
    properties.setProperty("reasonable", "true")
    pageHelper.setProperties(properties)
    //添加插件
    bean.setPlugins(Array[Interceptor](pageHelper))
    //添加XML目录
    val resolver = new PathMatchingResourcePatternResolver
    try { //设置xml扫描路径
      bean.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"))
      bean.getObject
    } catch {
      case e: Exception =>
        throw new RuntimeException("sqlSessionFactory init fail", e)
    }
  }

  @Bean(name = Array("sqlSessionTemplate"))
  def sqlSessionTemplate(sqlSessionFactory: SqlSessionFactory) = new SqlSessionTemplate(sqlSessionFactory)

  @Bean(name = Array("transactionManager"))
  override def annotationDrivenTransactionManager() = new DataSourceTransactionManager(dataSource)
}
