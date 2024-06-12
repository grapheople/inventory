package org.grapheople.inmaroom.competition.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.grapheople.inmaroom.competition.entities.Competition;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionVO {
    private Long id;

    @NotBlank
    @Schema(description = "대회명")
    private String name;
    @Schema(description = "대회 설명")
    private String description;
    @Schema(description = "장소")
    private String location;
    @Schema(description = "주최")
    private String host;
    @Schema(description = "주관")
    private String hostCompany;
    @Schema(description = "후원")
    private String support;
    @Schema(description = "대회 요강")
    private String outline;
    @Schema(description = "대회 안내")
    private String guide;
    @Schema(description = "대회 규정")
    private String rule;
    @Schema(description = "대회 공지")
    private String notice;
    @Schema(description = "대회 기념품 및 시상")
    private String souvenirsAndAwards;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @Schema(description = "모집 시작일")
    private LocalDateTime recruitStartAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @Schema(description = "모집 종료일")
    private LocalDateTime recruitEndAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @Schema(description = "환불 마감일")
    private LocalDateTime refundEndAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @Schema(description = "대회 시작일")
    private LocalDateTime startAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm") @Schema(description = "대회 종료일")
    private LocalDateTime endAt;
    @Schema(description = "모집 인원")
    private Integer recruitCount;

    public static CompetitionVO from(Competition competition) {
        return new CompetitionVO(
            competition.getId(),
            competition.getName(),
            competition.getDescription(),
            competition.getLocation(),
            competition.getHost(),
            competition.getHostCompany(),
            competition.getSupport(),
            competition.getOutline(),
            competition.getGuide(),
            competition.getRule(),
            competition.getNotice(),
            competition.getSouvenirsAndAwards(),
            competition.getRecruitStartAt(),
            competition.getRecruitEndAt(),
            competition.getRefundEndAt(),
            competition.getStartAt(),
            competition.getEndAt(),
            competition.getRecruitCount()
        );
    }
}
