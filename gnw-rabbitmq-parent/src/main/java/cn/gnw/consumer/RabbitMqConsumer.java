package cn.gnw.consumer;

import cn.gnw.common.BasePoint;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by letrain on 2017/12/28.
 */
public class RabbitMqConsumer extends BasePoint implements Runnable,Consumer{
    public RabbitMqConsumer(String basePointName) {
        super(basePointName);
    }

    // Called when consumer is registered.
    public void handleConsumeOk(String s) {
        System.out.println("consumer" + s + " registered");
    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    //Called when new message is available.
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map = (HashMap) SerializationUtils.deserialize(bytes);
        System.out.println("Message Number " + map.get("message number") + " reviced");
    }

    public void run() {
        try {
            channel.basicConsume(basePointName,true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
