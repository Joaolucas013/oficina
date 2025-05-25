package transvic.transviconn.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import transvic.transviconn.model.veiculo.DadosVeiculos;
import transvic.transviconn.model.veiculo.UpdateVeiculo;
import transvic.transviconn.model.veiculo.Veiculo;
import transvic.transviconn.model.veiculo.VeiculoDto;
import transvic.transviconn.repository.MarcaRepository;
import transvic.transviconn.repository.ModeloRepository;
import transvic.transviconn.repository.VeiculoRepository;


@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ModeloRepository modeloRepository;

    public DadosVeiculos created(@Valid VeiculoDto dto) {
        validate(dto);
        Veiculo veiculo = new Veiculo();
        var veiculo1 = criar(veiculo, dto);
       return new DadosVeiculos(veiculo1.getPlaca(), veiculo1.getMarca(),
                veiculo1.getModelo(), veiculo1.getAnoFabricacao(), veiculo1.getQuilometragem(),
                veiculo1.getChassi());
    }

    private Veiculo criar(Veiculo veiculo, @Valid VeiculoDto dto) {
        veiculo.ativar();
        veiculo.setAnoFabricacao(dto.anoFabricacao());
        veiculo.setChassi(dto.chassi());
        veiculo.setCor(dto.cor());
        veiculo.setPlaca(dto.placa());

        var modelo = modeloRepository.findById(dto.modeloId().getModelo()).get();
        var marca = marcaRepository.findById(dto.marca().getMarcaId()).get();

        veiculo.setModelo(modelo);
        veiculo.setMarca(marca);
        veiculo.setQuilometragem(dto.quilometragem());

        veiculoRepository.save(veiculo);
        return veiculo;
    }

    private void validate(@Valid VeiculoDto dto) {

        var veiculoExist = veiculoRepository.findByPlaca(dto.placa());
        if (veiculoExist != null) {
            throw new RuntimeException();
        }
    }

    public Page<DadosVeiculos> paginacao(Pageable paginacao) {
        var page = veiculoRepository.findAllByAtivoTrue(paginacao)
                .map(dados -> new DadosVeiculos(dados.getPlaca(),
                                dados.getMarca(),dados.getModelo(), dados.getAnoFabricacao(),
                dados.getQuilometragem(), dados.getChassi()));
        return page;

    }

    public void inativar(@Valid String placa) {
        veiculoRepository.inativar(placa);
    }


    public DadosVeiculos atualizar( UpdateVeiculo dados) {
        var veiculo = veiculoRepository.findByPlaca(dados.placa());

        veiculo = atualizar(veiculo, dados);
        veiculoRepository.save(veiculo);
        return new DadosVeiculos(veiculo.getPlaca(), veiculo.getMarca(),
                veiculo.getModelo(), veiculo.getAnoFabricacao(),
                veiculo.getQuilometragem(), veiculo.getChassi());


    }

    private Veiculo atualizar(Veiculo v,  UpdateVeiculo dados) {

        if(dados.chassi()!=null){
            v.setChassi(dados.chassi());
        }
        if(dados.anoFabricacao()!=null){
            v.setAnoFabricacao(dados.anoFabricacao());
        }
        if(dados.quilometragem()!= 0){
            v.setQuilometragem(dados.quilometragem());
        }
        if(dados.cor()!=null){
            v.setCor(dados.cor());
        }

        return v;
    }



}
