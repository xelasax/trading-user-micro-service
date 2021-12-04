package io.turntabl.userservice.frontend.response;

import io.turntabl.userservice.entities.PortfolioItem;
import lombok.Data;
import java.util.List;

@Data
public class WalletInformation {
    private String userId;
    private double balance;
    private List<PortfolioItem> portfolios;
}
