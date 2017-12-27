package cn.gnw.producer;

import cn.gnw.common.BasePoint;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by letrain on 2017/12/27.
 */
public class RabbitMqProducer extends BasePoint{

    public RabbitMqProducer(String basePointName) {
        super(basePointName);
    }

    public void sendMessage(Serializable message) throws IOException {
        channel.basicPublish("",basePointName,null, SerializationUtils.serialize(message));
    }
}
