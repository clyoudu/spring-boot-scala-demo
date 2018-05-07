package github.chenlei.springbootscalademo.config

import java.sql.SQLException
import javax.sql.DataSource

import com.alibaba.druid.pool.DruidDataSource
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.context.annotation.{Bean, Configuration, Primary}

/**
  * Create by IntelliJ IDEA
  *
  * @Author chenlei
  * @DateTime 2018/5/7 10:59
  * @Description DruidDataSource
  */
@Configuration
@Primary
class DruidDataSourceConfig extends DataSourceProperties {
  private val LOGGER = LoggerFactory.getLogger(classOf[DruidDataSourceConfig])

  @Value("${spring.datasource.url}")
  private val dbUrl : String = null

  @Value("${spring.datasource.username}")
  private val username : String = null

  @Value("${spring.datasource.password}")
  private val password : String = null

  @Value("${spring.datasource.driverClassName}")
  private val driverClassName : String = null

  @Value("${spring.datasource.initialSize}")
  private val initialSize : Integer = 0

  @Value("${spring.datasource.minIdle}")
  private val minIdle : Integer = 0

  @Value("${spring.datasource.maxActive}")
  private val maxActive : Integer = 0

  @Value("${spring.datasource.maxWait}")
  private val maxWait : Long = 0

  @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
  private val timeBetweenEvictionRunsMillis : Long = 0

  @Value("${spring.datasource.minEvictableIdleTimeMillis}")
  private val minEvictableIdleTimeMillis = 0

  @Value("${spring.datasource.validationQuery}")
  private val validationQuery : String = null

  @Value("${spring.datasource.testWhileIdle}")
  private val testWhileIdle : Boolean = false

  @Value("${spring.datasource.testOnBorrow}")
  private val testOnBorrow : Boolean = false

  @Value("${spring.datasource.testOnReturn}")
  private val testOnReturn : Boolean = false

  @Value("${spring.datasource.poolPreparedStatements}")
  private val poolPreparedStatements : Boolean = false

  @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
  private val maxPoolPreparedStatementPerConnectionSize : Integer = 0

  @Value("${spring.datasource.filters}")
  private val filters : String = null

  @Value("{spring.datasource.connectionProperties}")
  private val connectionProperties : String = null

  @Bean //声明其为Bean实例
  def dataSource: DataSource = {
    val datasource: DruidDataSource = new DruidDataSource
    datasource.setUrl(this.dbUrl)
    datasource.setUsername(username)
    datasource.setPassword(password)
    datasource.setDriverClassName(driverClassName)
    //configuration
    datasource.setInitialSize(initialSize)
    datasource.setMinIdle(minIdle)
    datasource.setMaxActive(maxActive)
    datasource.setMaxWait(maxWait)
    datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis)
    datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis)
    datasource.setValidationQuery(validationQuery)
    datasource.setTestWhileIdle(testWhileIdle)
    datasource.setTestOnBorrow(testOnBorrow)
    datasource.setTestOnReturn(testOnReturn)
    datasource.setPoolPreparedStatements(poolPreparedStatements)
    datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize)
    try
      datasource.setFilters(filters)
    catch {
      case e: SQLException =>
        LOGGER.error("druid configuration initialization filter", e)
    }
    datasource.setConnectionProperties(connectionProperties)
    datasource
  }
}
