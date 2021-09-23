package com.softeem.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * description:
 *
 * @author lyming
 * @date 2021/2/26 6:03 下午
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {

    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }

    @Override
    public DataSource getDataSource() {
        try {
            ((DruidDataSource)this.dataSource).init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.dataSource;
    }
}
