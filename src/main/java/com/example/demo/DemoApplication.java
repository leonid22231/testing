package com.example.demo;

import com.example.demo.Catalog.Wood;
import com.example.demo.Catalog.WoodContainer;
import com.example.demo.DB.DataBase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PreDestroy;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class DemoApplication implements WebMvcConfigurer {

@Override
public void addResourceHandlers(ResourceHandlerRegistry registration){
	registration.addResourceHandler("/img/**").addResourceLocations("/WEB-INF/images/")
			.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
}
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(DemoApplication.class, args);
//		DataBase db = new DataBase();
//		db.Connect();
//		WoodContainer wc = db.Update();
//		for (int i = 0; i < wc.size();i++){
//			//System.out.println(wc.get(i).toString());
//		}
//		wc.Random(5);
//		db.Update(wc);
//		db.CloseDB();
//		db.Connect();
//		wc = db.Update();
//		wc.Print();
//		db.CloseDB();


}
@PreDestroy
public void onDestroy() throws Exception {
	System.out.println("Spring Container is destroyed!");
}

}
