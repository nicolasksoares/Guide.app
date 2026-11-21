package app.guide;

import org.springframework.boot.SpringApplication;

public class TestGuideApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(GuideApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
