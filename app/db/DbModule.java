package db;

import com.google.inject.AbstractModule;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class DbModule extends AbstractModule {

    protected void configure() {
        try {
            bind(SqlSessionFactory.class).toInstance(new SqlSessionFactoryBuilder()
                    .build(Resources.getResourceAsStream("shop.xml")));
        } catch (IOException e) {
            // todo logging
            e.printStackTrace();
        }
    }
}
