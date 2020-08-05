package carrental;

import carrental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired StarRepository starRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCarRented_StarInsert(@Payload CarRented carRented){
        System.out.println("##### listener StarInsert : " + carRented.toJson());
        if(carRented.isMe()){
            Star star = new Star();
            star.setId(carRented.getId());
            star.setStars("-");
            star.setResrvNo(carRented.getResrvNo());
            star.setCarNo(carRented.getCarNo());
            starRepository.save(star);
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCarRentalCanceled_StarInsert(@Payload CarRentalCanceled carRentalCanceled){

        if(carRentalCanceled.isMe()){
            System.out.println("##### listener StarInsert : " + carRentalCanceled.toJson());
        }
    }

}
