package jp.co.axa.apidemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import jp.co.axa.apidemo.common.CommonResult;

@EnableWebMvc
@Configuration
public class UnifiedReturnConfig {

    @RestControllerAdvice
    static class CommonResultResponseAdvice implements ResponseBodyAdvice<Object>{

		@Override
		public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
				Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
				ServerHttpResponse response) {
			// TODO Auto-generated method stub
			if(body instanceof CommonResult) {
				return body;
			}
			return new CommonResult<Object>(body);
		}

    }
}
