package jp.co.axa.apidemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/**
	 * SWAGGERのConfig情報設定
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				//インタフェース所在のパッケージをスキャンする
				.apis(RequestHandlerSelectors.basePackage("jp.co.axa.apidemo.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(new ApiInfoBuilder()
						.title("APIサンプル")
						.description("APIの情報は下記をご参照ください。")
						.version("1.0")
						.contact(new Contact("Xiaogang.Kan","https://www.axa.co.jp/","kanxiaogang05142@gmail.com"))
						.license("Dummy License")
						.licenseUrl("https://www.axa.co.jp/")
						.build());
	}
	
}
