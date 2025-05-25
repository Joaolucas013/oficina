package transvic.transviconn.model.veiculoMotorista;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;


public record UpdateVeiculoMotorista(
        @NotBlank
        String placa,
        @NotNull
        Long idMotorista,
        LocalDate dataFim) {
}
