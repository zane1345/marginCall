package co.uk.codeyogi.stockdata.service;

import co.uk.codeyogi.stockdata.model.StockWrapper;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Service
public class RefreshService {

    private Map<StockWrapper, Boolean> refreshedStocks;
    private static final ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);

    private static final Duration refreshPeriod = Duration.ofSeconds(15);

    public RefreshService() {
        refreshedStocks = new HashMap<>();
    }

    public void refreshInterval() {
        schedule.scheduleAtFixedRate(() = >
                refreshedStocks.forEach((stock, value) -> {
                    if (stock.getLastAccessed().isBefore(LocalDateTime.now().minus(refreshPeriod))) {
                        System.out.println("");
                    }
                });)
    )
    }
}
