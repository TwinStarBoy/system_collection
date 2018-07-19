package crm_mgr_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("crm_mgr_test.dao")
public class Application{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("helloworld");
		SpringApplication.run(Application.class, args);
	}

}
