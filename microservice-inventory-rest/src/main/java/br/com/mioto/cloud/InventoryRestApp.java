package br.com.mioto.cloud;

import br.com.mioto.cloud.controllers.ConsulController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@RestController
@EnableConfigurationProperties
@EnableFeignClients
@Slf4j
@SpringBootApplication
public class InventoryRestApp {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main( String[] args ) {
        ConfigurableApplicationContext context = SpringApplication.run(InventoryRestApp.class, args);
        //After Start process, create or update dependencies entry on KV Store from Service Discovery
        context.getBean(ConsulController.class).kvPut();
    }
}