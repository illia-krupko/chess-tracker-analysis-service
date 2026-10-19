package krupkoillia.chesstracker.analysisservice.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "game_analysis")
public class GameAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(
            name = "white_accuracy",
            precision = 5,
            scale = 2,
            nullable = false
    )
    private BigDecimal whiteAccuracy;

    @Column(
            name = "black_accuracy",
            precision = 5,
            scale = 2,
            nullable = false
    )
    private BigDecimal blackAccuracy;

    @Column(name = "white_estimated_rating", nullable = false)
    private Integer whiteEstimatedRating;

    @Column(name = "black_estimated_rating", nullable = false)
    private Integer blackEstimatedRating;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MoveAnalysis> moveAnalyses = new ArrayList<>();

}
