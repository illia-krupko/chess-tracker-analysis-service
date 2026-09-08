package krupkoillia.chesstracker.analysisservice;

import org.springframework.boot.SpringApplication;

public class TestAnalysisServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(AnalysisServiceApplication::main)
            .with(TestcontainersConfiguration.class).run(args);
    }

}
