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
import our.fashionablesimba.yanawa.matching.dto.MatchingDto;
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
    public ResponseEntity<List<MatchingDto>> findAll() {
        return ResponseEntity.ok(
                matchingService.findAll().stream()
                        .map(matching -> new MatchingDto(matching))
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    public ResponseEntity<MatchingDto> recruitPartner(@RequestBody MatchingDto matchingRequest) {
        Matching matching = matchingService.recruit(matchingRequest.toMatching());
        MatchingDto result = new MatchingDto(matching);
        log.info("{}", result.toString());
        return ResponseEntity.ok(new MatchingDto(matching));
    }

    @PostMapping("apply")
    public ResponseEntity<HttpStatus> apply(Long userId, Long matchingId) {
        UserMatching userMatching = matchingService.apply(userId, matchingId);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}