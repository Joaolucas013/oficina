package transvic.transviconn.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transvic.transviconn.model.veiculoMotorista.DadosVeiculos;
import transvic.transviconn.model.veiculoMotorista.DeleteVeiculoMotorista;
import transvic.transviconn.model.veiculoMotorista.UpdateVeiculoMotorista;
import transvic.transviconn.model.veiculoMotorista.VeiculoMotoristaDto;
import transvic.transviconn.service.VeiculoMotoristaService;

@RestController
@RequestMapping("/veiculoMotorista")
public class VeiculoMotoristaController {



    @Autowired
    private VeiculoMotoristaService veiculoMotoristaService;


    @PostMapping("/post")
    public ResponseEntity<VeiculoMotoristaDto> create(@RequestBody @Valid DadosVeiculos dados) {
        var vm = veiculoMotoristaService.cadastrar(dados);
        return ResponseEntity.ok(vm);
    }

    @GetMapping("/listar")
    public ResponseEntity<Page<VeiculoMotoristaDto>> listar(@PageableDefault(size = 5) Pageable pageable) {
        var page = veiculoMotoristaService.paginar(pageable);
        return ResponseEntity.ok(page);
    }

    @PutMapping("update")
    public ResponseEntity<VeiculoMotoristaDto> update(@RequestBody @Valid UpdateVeiculoMotorista dados) {
        var atualiza = veiculoMotoristaService.atualizar(dados);
        return ResponseEntity
                .status(HttpStatus.OK).body(atualiza);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletar(@RequestBody @Valid DeleteVeiculoMotorista dados) {
        veiculoMotoristaService.deletar(dados);
        return ResponseEntity.ok("relação deletada com sucesso!!!");
    }



}
