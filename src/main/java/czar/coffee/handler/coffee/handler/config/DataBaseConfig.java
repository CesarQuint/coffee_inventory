package czar.coffee.handler.coffee.handler.config;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConfig {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @PostConstruct
    public  void testConnection(){
        try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            System.out.println("MySQL connection successfully");
        }catch(Exception e){
            System.out.println("❌ MySQL connection failed!");
            e.printStackTrace();
        }
    }

}
