package PedroNunesDev.ConsultaDDD.controller;

import PedroNunesDev.ConsultaDDD.dtos.DtoRequest;
import PedroNunesDev.ConsultaDDD.model.RequestUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import PedroNunesDev.ConsultaDDD.service.DDDService;

@CrossOrigin(origins= "http://localhost:5500")
@RestController
@RequestMapping("/ddd")
public class DDDController {

    @Autowired
    private DDDService dddService;

    @GetMapping("/{ddd}")
    public ResponseEntity<?> buscarDDD(@PathVariable("ddd") String dddRequest){

        ResponseEntity<?> response = dddService.buscarDDD(dddRequest);

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @PostMapping("/request")
    public ResponseEntity<RequestUsuario> cadastrarRequest(@RequestBody @Valid DtoRequest dtoRequest){

        return dddService.cadastrarRequest(dtoRequest);
    }
}
