package hr.algebra.cableshop;

import hr.algebra.cableshop.domain.Cable;
import hr.algebra.cableshop.domain.CableTag;
import hr.algebra.cableshop.repository.CableRepository;
import hr.algebra.cableshop.repository.CableTagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class CableshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CableshopApplication.class, args);
    }

    @Bean
    CommandLineRunner dataLoader(CableRepository cableRepository, CableTagRepository cableTagRepository) {
                return args -> {

                    CableTag tag1 = cableTagRepository.save(new CableTag("thick"));
                    CableTag tag2 = cableTagRepository.save(new CableTag("black"));
                    CableTag tag3 = cableTagRepository.save(new CableTag("plastic"));


                    cableRepository.save(new Cable("UsbA", false, BigDecimal.valueOf(10), Arrays.asList(tag1)));
                    cableRepository.save(new Cable("UsbB", false, BigDecimal.valueOf(15), Arrays.asList(tag1, tag2)));
                    cableRepository.save(new Cable("UsbC", true, BigDecimal.valueOf(25), Arrays.asList(tag3)));
        };
    }

}
