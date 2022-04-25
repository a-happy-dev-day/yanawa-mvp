package our.fashionablesimba.yanawa.matching.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import our.fashionablesimba.yanawa.matching.domain.matching.Matching;
import our.fashionablesimba.yanawa.matching.domain.usermatching.UserMatching;
import our.fashionablesimba.yanawa.matching.dto.MatchingDto;
import our.fashionablesimba.yanawa.matching.service.MatchingService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/matching")
@Api(tags = "MATCHING APIs")
public class MatchingController {

    Logger log = LoggerFactory.getLogger(this.getClass());
    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping
    @ApiOperation(value = "매칭 전체 조회")
    public ResponseEntity<List<MatchingDto>> findAll() {
        return ResponseEntity.ok(
                matchingService.findAll().stream()
                        .map(matching -> new MatchingDto(matching))
                        .collect(Collectors.toList())
        );
    }

    @PostMapping
    @ApiOperation(value = "매칭 생성")
    public ResponseEntity<MatchingDto> recruitPartner(@RequestBody MatchingDto matchingRequest) {
        Matching matching = matchingService.recruit(matchingRequest.toMatching());
        MatchingDto result = new MatchingDto(matching);
        log.info("{}", result.toString());
        return ResponseEntity.ok(new MatchingDto(matching));
    }

    @PostMapping("apply")
//    @ApiOperation(value = "매칭 지원")
    public ResponseEntity<HttpStatus> apply(Long userId, Long matchingId) {
        UserMatching userMatching = matchingService.apply(userId, matchingId);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}
