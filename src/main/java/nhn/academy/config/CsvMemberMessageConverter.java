package nhn.academy.config;

import nhn.academy.model.Member;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CsvMemberMessageConverter implements HttpMessageConverter<Member> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false; // 읽기는 지원하지 않음
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return List.of(MediaType.valueOf("text/csv"));
    }

    @Override
    public Member read(Class<? extends Member> clazz, HttpInputMessage inputMessage) {
        throw new UnsupportedOperationException("CSV 읽기는 지원하지 않습니다.");
    }

    @Override
    public void write(Member member, MediaType contentType, HttpOutputMessage outputMessage) throws IOException {
        outputMessage.getHeaders().setContentType(MediaType.valueOf("text/csv; charset=UTF-8"));
        try (Writer writer = new OutputStreamWriter(outputMessage.getBody())) {
            writer.write("name,age\n"); // CSV 헤더
            writer.write(member.getName() + "," + member.getAge() + "\n"); // 데이터
        }
    }
}
