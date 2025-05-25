package transvic.transviconn.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transvic.transviconn.model.motorista.MotoristaCreate;
import transvic.transviconn.model.motorista.MotoristaDados;
import transvic.transviconn.service.MotoristaService;

@RequestMapping("motorista")
@RestController
public class MotoristaController {


    @Autowired
    private MotoristaService motoristaService;

    @PostMapping("/post")
    public ResponseEntity<MotoristaDados> create(@RequestBody @Valid MotoristaCreate dto){
        var motorista = motoristaService.cadastrar(dto);
        return ResponseEntity.ok(motorista);
    }

    @GetMapping("/read")
    public ResponseEntity<Page<MotoristaDados>> read(@PageableDefault(size=10, sort = {"nome"}) Pageable pageable){
        var page = motoristaService.read(pageable);
        return ResponseEntity.ok(page);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletar(@PathVariable long id){
        motoristaService.inativar(id);
        return ResponseEntity.noContent().build();
    }

}
