package tads.eaj.ufrn.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//habilita o swagger
//swagger da um conflito com hateoas
//@EnableSwagger2
public class LojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	//método que cria uma api (um site com uma api)
	//cria toda a documentação do que foi codado e permite modificações
	//para acessar urllocal/swagger-ui.html no navegador
//	@Bean
//	public Docket productApi(){
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("tads.eaj.ufrn.loja.controller"))
//				.paths(PathSelectors.any())
//				.build()
//				.apiInfo( new ApiInfoBuilder().version("1.0").title("API Escola").description("Uma API para uma escola").build());
//	}

}
