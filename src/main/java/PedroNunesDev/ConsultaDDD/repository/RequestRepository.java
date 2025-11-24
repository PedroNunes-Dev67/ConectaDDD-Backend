package PedroNunesDev.ConsultaDDD.repository;

import PedroNunesDev.ConsultaDDD.model.RequestUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestUsuario, Long> {
}
