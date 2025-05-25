package transvic.transviconn.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import transvic.transviconn.model.setor.ListaSetores;
import transvic.transviconn.model.setor.SetorDto;
import transvic.transviconn.model.setor.SetorReturn;
import transvic.transviconn.service.SetorService;

@RestController
@RequestMapping("setor")
public class SetorController {

    @Autowired
    private SetorService service;

    @Transactional
    @PostMapping("/create")
    public ResponseEntity<SetorReturn> create(@RequestBody @Valid SetorDto dto) {
        var setor = service.cadastrarSetor(dto);
        return ResponseEntity.ok(setor);
    }


    @GetMapping("/read")
    public ResponseEntity<Page<ListaSetores>> listar(@PageableDefault(size = 5, sort = {"id"}) Pageable pageable) {
        var page = service.paginar(pageable);
        return ResponseEntity.ok(page);
    }


    @Modifying
    @PutMapping("/update")
    public ResponseEntity<SetorReturn> update(@RequestBody @Valid SetorReturn setorDto) {
        var up = service.atualizar(setorDto);

        return ResponseEntity.ok(up);
    }


    @PutMapping("delete/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        service.inativar(id);
        return ResponseEntity.ok("Setor deletado com sucesso!!!");
    }


    @PutMapping("ativar/{id}")
    public ResponseEntity<String> ativar(@PathVariable Long id) {
        service.ativar(id);
        return ResponseEntity.ok("Setor ativado com sucesso!!!");
    }






}
