package transvic.transviconn.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import transvic.transviconn.model.motorista.Motorista;
import transvic.transviconn.model.veiculoMotorista.*;
import transvic.transviconn.repository.MotoristaRepository;
import transvic.transviconn.repository.VeiculoMotoristaRepository;
import transvic.transviconn.repository.VeiculoRepository;

import java.util.Optional;

@Service
public class VeiculoMotoristaService {

    private final MotoristaRepository motoristaRepository;
    private final VeiculoRepository veiculoRepository;

    public VeiculoMotoristaService(MotoristaRepository motoristaRepository,
                                   VeiculoRepository veiculoRepository){
        this.motoristaRepository = motoristaRepository;
        this.veiculoRepository = veiculoRepository;
    }

    @Autowired
    private VeiculoMotoristaRepository veiculoMotoristaRepository;


    public Page<VeiculoMotoristaDto> paginar(Pageable pageable) {
        var page = veiculoMotoristaRepository
                .findAll(pageable)
                .map(VeiculoMotoristaDto::new);
        return page;
    }


    public VeiculoMotoristaDto cadastrar(@Valid DadosVeiculos dados) {
        var veiculoMotorista = new VeiculoMotorista();

     
        Optional<Motorista> motorista = motoristaRepository.findById(dados.motoristaId());
      var veiculo = veiculoRepository.buscarVeiculo(dados.placa());

        if(motorista.isEmpty()){
            throw new RuntimeException("Motorista não encontrado");
        }
        if(veiculo==null){
            throw new RuntimeException("Veiculo não encontrado!!!");
        }

        veiculoMotorista.setVeiculo(veiculo);
        veiculoMotorista.setMotorista(motorista.get());
        veiculoMotorista.setDataFim(dados.dataFim());

        VeiculoMotoristaId id = new VeiculoMotoristaId(veiculoMotorista.getVeiculo().getPlaca(),
                veiculoMotorista.getMotorista().getMotoristaId(), dados.dataInicio());

        veiculoMotorista.setId(id);

        veiculoMotoristaRepository.save(veiculoMotorista);
        return new VeiculoMotoristaDto(veiculoMotorista);

    }

    public VeiculoMotoristaDto atualizar(UpdateVeiculoMotorista dados) {
        validacao(dados.placa(), dados.idMotorista());

        veiculoMotoristaRepository.update(dados.dataFim(),
                dados.placa(), dados.idMotorista());
        VeiculoMotorista veiculoMotorista = veiculoMotoristaRepository.buscar(dados.placa(), dados.idMotorista());

        VeiculoMotoristaDto dto = new VeiculoMotoristaDto(veiculoMotorista.getVeiculo().getPlaca(),
                veiculoMotorista.getMotorista().getMotoristaId(), veiculoMotorista.getId().getDataInicio(),
                veiculoMotorista.getDataFim());

        return dto;

    }

    private boolean validacao(String placa, long motorista) {
        var existMotorista = motoristaRepository.BuscarPeloId(motorista);
        var existVeiculo = veiculoRepository.buscarVeiculo(placa);

        if (existVeiculo == null) {
            throw new RuntimeException("Veiculo não cadastrado!");
        }
        if (existMotorista == null) {
            throw new RuntimeException("Motorista não cadastrado!!!");
        }
        return true;
    }

    public void deletar(@Valid DeleteVeiculoMotorista dados) {
        veiculoMotoristaRepository
                .deletar(dados.dataInicio(), dados.motoristaId(), dados.placa());
    }
}
