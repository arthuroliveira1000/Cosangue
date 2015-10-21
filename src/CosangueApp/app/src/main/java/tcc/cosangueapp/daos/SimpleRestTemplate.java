package tcc.cosangueapp.daos;


import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class SimpleRestTemplate {

    protected RestTemplate restTemplate = new RestTemplate();

    public SimpleRestTemplate() {
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
    }
}
