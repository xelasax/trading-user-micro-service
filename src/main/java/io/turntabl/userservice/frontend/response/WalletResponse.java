package io.turntabl.userservice.frontend.response;

import io.turntabl.userservice.dto.PortfolioDto;
import lombok.Data;

import java.util.List;

@Data
public class WalletResponse {

    private String userId;

    private double balance;

    private List<PortfolioDto> portfolios;

}
