package io.turntabl.userservice.feignclients;

import io.turntabl.userservice.frontend.response.WalletInformation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderFeignClient {

    @PostMapping("/api/v1/wallets")
    public WalletInformation walletInformation(@RequestHeader("Authorization") String bearerToken);

}
