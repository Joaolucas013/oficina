package transvic.transviconn.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import transvic.transviconn.model.procedimento.ListaProcedimentos;
import transvic.transviconn.model.setor.*;
import transvic.transviconn.repository.SetorRepository;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository setorRepository;


    public SetorReturn cadastrarSetor(@Valid SetorDto dto) {
        Setor setor = new Setor();
        setor.setDescricao(dto.descricao());
        setor.ativar();
        setorRepository.save(setor);

        return new SetorReturn(
                setor.getId(),
                setor.getDescricao());
    }


    public Page<ListaSetores> paginar(Pageable pageable) {
        return setorRepository.findAll(pageable)
                .map(s -> {
                            List<DadosFuncionariosSetores>
                                    dadosFuncionariosSetores =
                                    s.getFuncionarios()
                                            .stream()
                                            .map(f ->
                                                    new DadosFuncionariosSetores(f.getNome(),
                                                            f.getCpf(),
                                                            f.getProfissao()))
                                            .toList();

                            List<ListaProcedimentos> listaProcedimentos =
                                    s.getProcedimento()
                                            .stream()
                                            .map(p -> new ListaProcedimentos(p.getDescricao(),
                                                    p.getValorProcedimento()))
                                            .toList();


                            return new ListaSetores(
                                    s.getId(),
                                    s.getDescricao(),
                                    dadosFuncionariosSetores, listaProcedimentos
                            );
                        }

                );

    }


    public SetorReturn atualizar(@Valid SetorReturn setorDto) {
        var setorUpdate = setorRepository.getReferenceById(setorDto.id());

        if (setorUpdate == null) {
            throw new RuntimeException();
        }
        setorUpdate.setDescricao(setorDto.descricao());
        setorRepository.save(setorUpdate);
        return new SetorReturn(setorUpdate.getId(), setorUpdate.getDescricao());
    }



    public void inativar(Long id) {
        setorRepository.inativar(id);
    }

    public void ativar(Long id) {
        setorRepository.ativar(id);
    }
}



