package transvic.transviconn.service;


import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import transvic.transviconn.model.procedimento.Procedimento;
import transvic.transviconn.model.procedimento.ProcedimentoDto;
import transvic.transviconn.model.procedimento.ProcedimentoResponse;
import transvic.transviconn.repository.ProcedimentoRepository;
import transvic.transviconn.repository.SetorRepository;

@Service
public class ProcedimentoService {


    @Autowired
    private ProcedimentoRepository repository;

    @Autowired
    private SetorRepository setorRepository;

    public ProcedimentoResponse criar(@Valid ProcedimentoDto dto) {
        Procedimento procedimento = new Procedimento();
        procedimento.setDescricao(dto.descricao());
        procedimento.setValorProcedimento(dto.valor());

        ProcedimentoResponse pr = new ProcedimentoResponse(procedimento.getIdProcedimento(), procedimento.getDescricao(), procedimento.getValorProcedimento(), procedimento.getSetor());

        repository.save(procedimento);
        return pr;
    }
}
