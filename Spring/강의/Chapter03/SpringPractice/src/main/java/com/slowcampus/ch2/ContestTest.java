package com.slowcampus.ch2;

import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.google.common.reflect.ClassPath;
import org.springframework.util.StringUtils;

public class ContestTest {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car = (Car) ac.getBean(Car.class);
        SportsCar sportscar = (SportsCar) ac.getBean(SportsCar.class);
        Truck truck = (Truck) ac.getBean(Truck.class);
        Engine engine = (Engine) ac.getBean(Engine.class);
        System.out.println("car=" + car);
        System.out.println("SportsCar=" + sportscar);
        System.out.println("Truck=" + truck);
        System.out.println("engine=" + engine);

    }

    static Object getObject(String key) throws Exception {
        // config.txt를 읽어서 Properties에 저장
        Properties p = new Properties();
        p.load(new FileReader("/Users/ikjuncho/Downloads/ch2/src/main/resources/config.txt"));

        // 클래스 객체(설계도)를 얻어서
        Class cls = Class.forName(p.getProperty(key));
        return cls.newInstance();  // 객체를 생성해서 반환
    }

    static Car getCar() throws Exception {
        // config.txt를 읽어서 Properties에 저장
        Properties p = new Properties();
        p.load(new FileReader("/Users/ikjuncho/Downloads/ch2/src/main/resources/config.txt"));

        // 클래스 객체(설계도)를 얻어서
        Class cls = Class.forName(p.getProperty("car"));
        return (Car)cls.newInstance();  // 객체를 생성해서 반환
    }
}

@Component class Car {}

@Component class SportsCar extends Car {}

@Component class Truck extends Car {}

@Component class Engine {}

@Component class TurboEngine extends Engine {}

class AppContext {
    Map map;
    AppContext() {
        map = new HashMap();
        try {
            ClassLoader classloader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classloader);

            // 1. 패키지 내의 모든 클래스를 읽어서 Set에 저장
            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.slowcampus.ch2");
            // 2. 반복문으로 클래스를 하나씩 가져와서 @Component 애너테이션이 붙어있는지 확인
            for(ClassPath.ClassInfo classInfo : set) {
                Class cls = classInfo.load();
                Component component = (Component) cls.getAnnotation(Component.class);
                // 3. @Component 애너테이션이 붙어 있다면 객체를 생성해서 Map에 저장
                if (component != null) {
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    map.put(id, cls.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Object getBean(String id) { return map.get(id); }
    Object getBean(Class cls) {
        for(Object obj : map.values()) {
            if(cls.isInstance(obj))
                return obj;
        }
        return null;
    }
}