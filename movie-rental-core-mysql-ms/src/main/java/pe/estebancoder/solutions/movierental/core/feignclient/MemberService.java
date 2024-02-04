package pe.estebancoder.solutions.movierental.core.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.estebancoder.solutions.movierental.core.feignclient.response.Member;

@FeignClient(name = "movie-rental-membership")
public interface MemberService {

    @GetMapping("/members/{memberId}")
    ResponseEntity<Member> getMemberById(@PathVariable Long memberId);
}
