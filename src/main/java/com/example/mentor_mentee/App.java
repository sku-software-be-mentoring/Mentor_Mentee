package com.example.mentor_mentee;

import com.example.mentor_mentee.global.config.AppConfig;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Getter
public class App {

    private final String appName;

//    @Autowired
//    public App(String appName) {
//        this.appName = appName;
//    }

    //실제 실행할 함수
    public static void main(String[] args) {
        // 스프링 컨테이너를 불러오는데, AppConfig와 App 클래스에 대해 등록하는 컨테이너 불러오기
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, App.class);

        App app = ac.getBean(App.class); //applicationcontext라는 창고에서 꺼내오는 선언
        System.out.println(app.getAppName());

        //String 타입으로 등록된 모든 Bean 조회
        Map<String, String> beansOfType = ac.getBeansOfType(String.class);
        for(String key : beansOfType.keySet()) {
            System.out.println(key + ": " + beansOfType.get(key));
        }
    }

}
