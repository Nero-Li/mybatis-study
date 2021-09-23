package com.softeem.datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * description:
 *
 * @author lyming
 * @date 2021/1/5 2:59 下午
 */
public class C3P0DataSourceFactory extends UnpooledDataSourceFactory {

    public C3P0DataSourceFactory() {
        this.dataSource = new ComboPooledDataSource();
    }
}
