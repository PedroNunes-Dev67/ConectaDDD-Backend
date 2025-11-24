package PedroNunesDev.ConsultaDDD.service;

import PedroNunesDev.ConsultaDDD.dtos.DtoRequest;
import PedroNunesDev.ConsultaDDD.model.ExceptionDDD;
import PedroNunesDev.ConsultaDDD.model.DDD;
import PedroNunesDev.ConsultaDDD.model.RequestUsuario;
import PedroNunesDev.ConsultaDDD.model.Usuario;
import PedroNunesDev.ConsultaDDD.repository.RequestRepository;
import PedroNunesDev.ConsultaDDD.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class DDDService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private RequestRepository requestRepository;

    public ResponseEntity<?> buscarDDD(String dddRequest){

        try {
            return restTemplate.getForEntity("https://brasilapi.com.br/api/ddd/v1/" + dddRequest, DDD.class);
        }
        catch (HttpClientErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAs(ExceptionDDD.class));
        }
        catch (HttpServerErrorException e){
            return ResponseEntity.status(e.getStatusCode()).body(null);
        }
    }

    public ResponseEntity<RequestUsuario> cadastrarRequest(DtoRequest dtoRequest){

        Usuario usuario = usuarioRepository.findByEmail(dtoRequest.getEmail());

        if (usuario == null){
            usuario = new Usuario(dtoRequest.getEmail());
            usuarioRepository.save(usuario);
        }

        RequestUsuario requestUsuario = new RequestUsuario();
        requestUsuario.setRequest(dtoRequest.getRequest());
        requestUsuario.setUsuario(usuario);

        requestRepository.save(requestUsuario);

        return ResponseEntity.ok(requestUsuario);
    }
}
