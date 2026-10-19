package krupkoillia.chesstracker.analysisservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import krupkoillia.chesstracker.analysisservice.model.enums.MoveClassification;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@Table(name = "move_analysis")
public class MoveAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ply_number", nullable = false, unique = true)
    private Integer plyNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "classification", nullable = false)
    private MoveClassification classification;

    @Column(name = "centipawn_loss", nullable = false)
    private Integer centipawnLoss;

    @Column(name = "position_evaluation", nullable = false)
    private BigDecimal afterMovePositionEvaluation;

}
