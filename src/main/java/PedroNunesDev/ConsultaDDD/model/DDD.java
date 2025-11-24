package PedroNunesDev.ConsultaDDD.model;

import java.util.List;

public class DDD {

    private String state;
    private List<String> cities;

    public String getState() {
        return state;
    }

    public void setState(String estado) {
        this.state = estado;
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCities(List<String> listaDeCidades) {
        this.cities = listaDeCidades;
    }
}
