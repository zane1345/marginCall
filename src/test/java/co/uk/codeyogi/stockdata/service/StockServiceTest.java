package co.uk.codeyogi.stockdata.service;

import co.uk.codeyogi.stockdata.model.StockWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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

        final BigDecimal change = stockService.changePercent(stock);
        System.out.println(change);


        final BigDecimal find200DayPercent = stockService.find200MeanPercent(stock);
        System.out.println(find200DayPercent);

        final BigDecimal find200avg = stockService.avg200(stock);
        System.out.println(find200avg);
    }

    @Test
    void multiple() throws IOException, InterruptedException {
        final List<StockWrapper> stocks = stockService.findStocks(Arrays.asList("MS", "JPM", "CRSR"));
        findPrices(stocks);
        Thread.sleep(16000);
        final StockWrapper ttwo = stockService.findStock("TTWO");
        stocks.add(ttwo);
        System.out.println(stockService.findPrice(ttwo));

        findPrices(stocks);
    }

    private void findPrices(List<StockWrapper> stocks) {
        stocks.forEach(stock -> {
            try {
                System.out.println(stockService.findPrice(stock));
            } catch (IOException e) {

            }
        });
    }
}