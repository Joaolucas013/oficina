package transvic.transviconn.model.veiculoMotorista;

import java.time.LocalDate;

public record VeiculoMotoristaDto(
        String placa,
        long idMotorista,
        LocalDate dataInicio,
        LocalDate dataFim
) {

    public VeiculoMotoristaDto(VeiculoMotorista vm) {
        this(vm.getVeiculo().getPlaca(), vm.getMotorista().getMotoristaId(),
                vm.getId().getDataInicio(), vm.getDataFim());

    }
}
