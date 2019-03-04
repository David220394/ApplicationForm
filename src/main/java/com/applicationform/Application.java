package com.applicationform;

import com.applicationform.Config.StageManager;
import com.applicationform.entities.FxmlView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.applicationform")
public class Application extends javafx.application.Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    protected StageManager stageManager;

	public static void main(String[] args){

	    //SpringApplication.run(Application.class, args);
        launch(args);
	}

    @Override
    public void init() throws Exception {
        /*springContext = SpringApplication.run(Application.class);
        springContext.getAutowireCapableBeanFactory().autowireBean(this);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("template/index.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();*/
        springContext = springBootApplicationContext();

    }

    @Override
    public void stop() {
        springContext.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent fxml = FXMLLoader.load(getClass().getClassLoader().getResource("template/form.fxml"));
        /*Scene scene = new Scene(rootNode);
        primaryStage.setScene(scene);
        primaryStage.show();*/
        stageManager = springContext.getBean(StageManager.class, primaryStage);
        displayInitialScene();
    }

    protected void displayInitialScene() {
        stageManager.switchScene(FxmlView.INDEX);
    }

    private ConfigurableApplicationContext springBootApplicationContext() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }
}
