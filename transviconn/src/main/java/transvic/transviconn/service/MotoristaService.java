package transvic.transviconn.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import transvic.transviconn.model.motorista.Motorista;
import transvic.transviconn.model.motorista.MotoristaCreate;
import transvic.transviconn.model.motorista.MotoristaDados;
import transvic.transviconn.repository.MotoristaRepository;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public MotoristaDados cadastrar(MotoristaCreate dto) {
        var motorista = new Motorista();
        motorista.setCpf(dto.getCpf());
        motorista.setDataDemissao(dto.getDataDemissao());
        motorista.setHabilitacao(dto.getHabilitacao());
        motorista.setNome(dto.getNome());
        motorista.ativar();
        var motoristaReturn = motoristaRepository.save(motorista);

        MotoristaDados motoristaDados = new MotoristaDados(motoristaReturn);
        return motoristaDados;

    }


    public Page<MotoristaDados> read(Pageable pageable) {
        var page = motoristaRepository
                .findAllByAtivoTrue(pageable)
                .map(MotoristaDados::new);
        return page;
    }

    @Transactional
    public void inativar(long id) {
        motoristaRepository.inativar(id);
    }
}
