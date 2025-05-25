package transvic.transviconn.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transvic.transviconn.model.funcionario.FuncionarioDetalhado;
import transvic.transviconn.model.funcionario.FuncionarioDto;
import transvic.transviconn.model.funcionario.UpdateFuncionario;
import transvic.transviconn.service.FuncionarioService;


@RequestMapping("/funcionarioteste")
@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;


    @Transactional
    @PostMapping("/create")
    public ResponseEntity<FuncionarioDetalhado> cadastrar(@RequestBody @Valid FuncionarioDto dto){
       var funcionario = funcionarioService.salvar(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @GetMapping("/read")
    public ResponseEntity<Page<UpdateFuncionario>> read(@PageableDefault(size = 10, sort = {"funcionarioId"})
                                                           Pageable pageable){
        var page = funcionarioService.paginacao(pageable);

        return ResponseEntity.ok(page);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateFuncionario> update(@RequestBody @Valid UpdateFuncionario upFunc){
        var func = funcionarioService.update(upFunc);

        return ResponseEntity.ok(func);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletar(@PathVariable long id){
      funcionarioService.inativar(id);

      return ResponseEntity.noContent().build();
    }

}
