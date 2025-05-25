package transvic.transviconn.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import transvic.transviconn.model.funcionario.FuncionarioDetalhado;
import transvic.transviconn.model.funcionario.FuncionarioDto;
import transvic.transviconn.model.funcionario.UpdateFuncionario;

import transvic.transviconn.model.funcionario.Funcionario;
import transvic.transviconn.repository.FuncionarioRepository;
import transvic.transviconn.repository.SetorRepository;


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    public FuncionarioDetalhado salvar(@Valid FuncionarioDto dto) {

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.nome());
        funcionario.setCpf(dto.cpf());
        funcionario.setDataAdmissao(dto.dataAdmissao());
        funcionario.setProfissao(dto.profissao());
        var setor = setorRepository.findById(dto.setorId()).get();
        funcionario.setSetor(setor);


        funcionario.setDataNascimento(dto.dataNascimento());
        funcionario.setDataDemissao(dto.dataDemissao());

        funcionario.ativar();
        var func = funcionarioRepository.save(funcionario);
       var detalhado = new FuncionarioDetalhado(func, setor);

        return detalhado;
    }


    public void inativar(long id) {
        var funExists = funcionarioRepository.getReferenceById(id);

        if (funExists == null) {
            throw new RuntimeException("Funcionário não cadastrado");
        }
        funcionarioRepository.inativar(id);

    }


    public UpdateFuncionario update(UpdateFuncionario upFunc) {
        if (upFunc.cpf() == null && upFunc.nome() == null) {
            throw new RuntimeException("É necessario informar o cpf ou nome");
        }

        var funcionario = funcionarioRepository.findByCpf(upFunc.cpf());
        if (funcionario == null) {
            throw new RuntimeException();
        }

        if (upFunc.cpf() != null) {
            funcionario.setCpf(upFunc.cpf());
        }
        if (upFunc.dataAdmissao() != null) {
            funcionario.setDataAdmissao(upFunc.dataAdmissao());
        }
        if (upFunc.nome() != null) {
            funcionario.setNome(upFunc.nome());
        }
        if (upFunc.profissao() != null) {
            funcionario.setProfissao(upFunc.profissao());
        }
        if (upFunc.dataNascimento() != null) {
            funcionario.setDataNascimento(upFunc.dataNascimento());
        }

        funcionarioRepository.save(funcionario);
        var setor = setorRepository.findById(funcionario.getSetor().getId()).get();
        return new UpdateFuncionario(funcionario, setor);
    }


    public Page<UpdateFuncionario> paginacao(Pageable pageable) {
        var page = funcionarioRepository
                .findAllByAtivoTrue(pageable)
                .map(up -> new UpdateFuncionario(up.getFuncionarioId(), up.getNome(),
                        up.getCpf(), up.getDataAdmissao(), up.getDataNascimento(), up.getSetor(),
                        up.getProfissao()));
        return page;
    }
}
