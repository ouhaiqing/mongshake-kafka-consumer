package com.hk.st.consumer;

import com.alibaba.fastjson.JSON;
import com.hk.st.constant.IConstant;
import com.hk.st.pojo.OplogPO;
import com.hk.st.utils.ByteUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.bson.BSONObject;
import org.bson.BasicBSONDecoder;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class KafkaMSListener {

    @KafkaListener(topics = {"${spring.kafka.consumer.topic}"}, groupId = "groupid")
    public void registryReceiver(ConsumerRecord<byte[], byte[]> consumerRecord, Acknowledgment ack) {
        try {

            List<byte[]> byteList = ByteUtils.getByteList(consumerRecord.value(), IConstant.BYTE_SPLIT);

            for (int i = 0; i < byteList.size(); i++) {
                BasicBSONDecoder decoder = new BasicBSONDecoder();
                BSONObject bson = decoder.readObject(byteList.get(i));
                log.info("record:{}", JSON.toJSONString(bson));

                OplogPO oplog = new OplogPO();
                Map map = bson.toMap();
                BeanUtils.populate(oplog, map);

                log.info("oplog:{}", JSON.toJSONString(oplog));
            }

            ack.acknowledge();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

    }

}
