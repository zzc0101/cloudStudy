package cloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zzc0101
 * @date : 2022-09-04 12:17:50
 * @description : 规则定义类，不能在 @ComponentScan 注解的扫描范围内
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule() {
        // 定义为随机
        return new RandomRule();
    }
}
