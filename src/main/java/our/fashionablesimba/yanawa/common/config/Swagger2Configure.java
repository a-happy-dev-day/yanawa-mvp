package our.fashionablesimba.yanawa.common.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static java.util.Collections.singleton;
import static java.util.Collections.singletonList;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
@EnableSwagger2
public class Swagger2Configure extends WebMvcConfigurationSupport {
//    @Bean
//    public Docket restApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .ignoredParameterTypes(AuthenticationPrincipal.class, Pageable.class)
//                .securitySchemes(singletonList(apiKey()))
//                .securityContexts(singletonList(securityContext()))
//                .produces(singleton("application/json"))
//                .consumes(singleton("application/json"))
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(withMethodAnnotation(ApiOperation.class))
//                .build();
//    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(singleton("application/json"))
                .consumes(singleton("application/json"))
                .select()
                .apis(withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Social-Server")
                .contact(new Contact("username", null, "your-email@address.com"))
                .version("1.0.0")
                .build();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

}
