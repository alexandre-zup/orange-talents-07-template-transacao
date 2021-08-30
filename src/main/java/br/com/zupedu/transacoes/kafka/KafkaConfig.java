package br.com.zupedu.transacoes.kafka;

import br.com.zupedu.transacoes.kafka.dto.TransacaoInput;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {
    @Value("${BOOTSTRAP_SERVER}")
    private String bootstrapServer;

    @Value("${GROUP_ID}")
    private String groupId;

    @Value("${MAX_POLL_RECORDS}")
    private String maxPollRecords;

    @Bean
    public ConsumerFactory<String, TransacaoInput> orderConsumerFactory() {
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        Map<String, Class<?>> classMap = new HashMap<>();
        classMap.put("br.com.zup.academy.transacoes.domain.Transacao", TransacaoInput.class);
        typeMapper.setIdClassMapping(classMap);

        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        JsonDeserializer<TransacaoInput> valueDeserializer = new JsonDeserializer<>(TransacaoInput.class);
        valueDeserializer.addTrustedPackages("br.com.zup.academy.transacoes.domain.Transacao");
        valueDeserializer.setTypeMapper(typeMapper);
        valueDeserializer.setUseTypeMapperForKey(true);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), valueDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TransacaoInput> transacaoKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TransacaoInput> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(orderConsumerFactory());
        return factory;
    }
}
