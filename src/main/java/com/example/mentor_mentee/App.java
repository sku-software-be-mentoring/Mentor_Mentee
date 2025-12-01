package com.example.mentor_mentee;


import com.example.mentor_mentee.global.config.AppConfig;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class App {

  private final String appName;

  public static void main(String[] args) {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, App.class);


    App app = ac.getBean(App.class);
    System.out.println(app.getAppName());
    
    Map<String, String> beansOfType = ac.getBeansOfType(String.class);
    for(String key : beansOfType.keySet()) {
      System.out.println("key = " + key + ", bean = " + beansOfType.get(key));
    }
  }

}