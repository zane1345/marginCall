package co.uk.codeyogi.stockdata.service;

import co.uk.codeyogi.stockdata.model.StockWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.math.BigDecimal;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private StockService stockService;
    @Test
    void invoke() throws IOException {
final StockWrapper stock = stockService.findStock("GS");
    System.out.println(stock.getStock());
final BigDecimal price = stockService.findPrice(stock);
     System.out.println(price);
}

}