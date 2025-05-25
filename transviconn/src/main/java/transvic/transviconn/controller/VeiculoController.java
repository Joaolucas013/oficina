package transvic.transviconn.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import transvic.transviconn.model.veiculo.DadosVeiculos;
import transvic.transviconn.model.veiculo.UpdateVeiculo;
import transvic.transviconn.model.veiculo.VeiculoDto;
import transvic.transviconn.service.VeiculoService;


@RestController
@RequestMapping("veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping("/criar")
    public ResponseEntity<DadosVeiculos> criarVeiculo(@RequestBody @Valid VeiculoDto dto) {
        var v = service.created(dto);
        return ResponseEntity.ok(v);
    }

    @GetMapping("/read")
    public ResponseEntity<Page<DadosVeiculos>> listarVeiculos(@PageableDefault(size = 10, sort = {"chassi"}) Pageable paginacao) {
        var page = service.paginacao(paginacao);
        return ResponseEntity.ok(page);
    }


    @PutMapping("/update")
    public ResponseEntity<DadosVeiculos> atualizar(@RequestBody UpdateVeiculo dados) {
        var veiculo = service.atualizar(dados);
        return ResponseEntity.ok(veiculo);
    }


    @Transactional
    @DeleteMapping("/delete/{placa}")
    public ResponseEntity deletar(@Valid @PathVariable String placa) {
        service.inativar(placa);
        return ResponseEntity.noContent().build();
    }


}
