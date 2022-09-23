package co.uk.codeyogi.stockdata.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;
import org.springframework.cglib.core.Local;
import yahoofinance.Stock;

import java.time.LocalDateTime;
@Getter
@With
@AllArgsConstructor
public class StockWrapper {
    private final Stock stock;
    private final LocalDateTime lastAccessed;

    public StockWrapper(final Stock stock){
        this.stock=stock;
        lastAccessed=LocalDateTime.now();
    }

}
