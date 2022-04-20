package our.fashionablesimba.yanawa.matching.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.service.MatchingService;

import java.util.List;

@Repository
@RequestMapping("matching")
public class MatchingController {

    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping
    public ResponseEntity<List<Matching>> findAll() {
        return ResponseEntity.ok(matchingService.findAll());
    }

    //매칭 등록
    @PostMapping
    public ResponseEntity<MatchingResponse> recruitPartner(MatchingRequest matchingRequest) {
        Matching matching = matchingService.recruit(matchingRequest.toMatching());
        return ResponseEntity.ok(new MatchingResponse(matching));
    }

    //매칭 신청
    @PostMapping("apply")
    public ResponseEntity<UserMatching> apply(Long userId, Long matchingId) {
        UserMatching userMatching = matchingService.apply(userId, matchingId);
        return ResponseEntity.ok(userMatching);
    }
}
