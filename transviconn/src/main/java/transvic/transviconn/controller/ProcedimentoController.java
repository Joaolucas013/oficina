package transvic.transviconn.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import transvic.transviconn.model.procedimento.Procedimento;
import transvic.transviconn.model.procedimento.ProcedimentoDto;
import transvic.transviconn.model.procedimento.ProcedimentoResponse;
import transvic.transviconn.service.ProcedimentoService;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;


    @Transactional
    @PostMapping("/create")
    public ResponseEntity<ProcedimentoResponse> cadastrar(@RequestBody @Valid ProcedimentoDto dto) {
        var procedimentoCreate = procedimentoService.criar(dto);

        return ResponseEntity.ok(procedimentoCreate);
    }


}
