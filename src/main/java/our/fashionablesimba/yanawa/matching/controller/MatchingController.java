package our.fashionablesimba.yanawa.matching.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.service.MatchingService;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequestMapping("api/matching")
public class MatchingController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping
    public ResponseEntity<List<MatchingResponse>> findAll() {
        return ResponseEntity.ok(
                matchingService.findAll().stream()
                        .map(matching -> new MatchingResponse(matching))
                        .collect(Collectors.toList())
        );
    }

    //매칭 등록
    @PostMapping
    public ResponseEntity<HttpStatus> recruitPartner(@RequestBody MatchingRequest matchingRequest) {
        Matching matching = matchingService.recruit(matchingRequest.toMatching());
        MatchingResponse result = new MatchingResponse(matching);
        log.info("{}", result.toString());
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    //매칭 신청
    @PostMapping("apply")
    public ResponseEntity<HttpStatus> apply(Long userId, Long matchingId) {
        UserMatching userMatching = matchingService.apply(userId, matchingId);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
