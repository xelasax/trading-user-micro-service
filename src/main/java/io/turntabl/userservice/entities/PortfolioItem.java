package io.turntabl.userservice.entities;

import lombok.Data;

import java.math.BigInteger;

@Data
public class PortfolioItem {
    private String ticker;
    private BigInteger quantity;

}
