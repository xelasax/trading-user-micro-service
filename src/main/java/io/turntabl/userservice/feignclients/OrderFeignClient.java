package io.turntabl.userservice.feignclients;

import io.turntabl.userservice.frontend.response.WalletInformation;
import io.turntabl.userservice.frontend.response.WalletResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "ORDER-SERVICE")
public interface OrderFeignClient {

    @PostMapping("/api/v1/wallets")
    public WalletInformation walletInformation(@RequestHeader("Authorization") String bearerToken);

    @GetMapping("/api/v1/wallet/all")
    public List<WalletResponse> wallets(@RequestHeader("Authorization") String bearerToken);


}
