package com.pablords.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.retry.annotation.EnableRetry;

import lombok.extern.slf4j.Slf4j;


@SpringBootApplication(scanBasePackages = "com.pablords.inventory")
@EnableRetry
@Import({
    com.pablords.shared.config.KafkaProducerConfig.class
})
@Slf4j
public class InventoryApplication implements CommandLineRunner {

  @Value("${spring.application.name}")
  String appName;

  @Override
  public void run(String... args) {
    log.info("{} app is running", appName);
  }

  public static void main(String[] args) {
    SpringApplication.run(InventoryApplication.class, args);
  }

}
