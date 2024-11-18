package nhn.academy.config;

import nhn.academy.CsvHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.print.attribute.standard.Media;
import java.util.List;

// 스프링의 설정파일
@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 메세지 컨버터 관련 설정을 해주는 메서드
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new CsvHttpMessageConverter());
    }

    // configuration 관련 설정을 해주는 메서드
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        /* favorParameter 속성 값이 true(기본값 false)이고,
        요청 파라미터에 미디어 타입을 정의하는 값이 포함되어 있다면 그 값을 미디어 타입으로 사용합니다.
         파라미터의 변수명은 'format' 입니다. */
        configurer.parameterName("format").favorParameter(true).defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML);
    }
}

