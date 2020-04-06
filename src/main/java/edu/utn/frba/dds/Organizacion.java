package edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class Organizacion {
    private List<OperacionDeEgreso> operacionesDeEgreso = new ArrayList<OperacionDeEgreso>();

    public List<OperacionDeEgreso> getOperacionesDeEgreso() {
        return operacionesDeEgreso;
    }

    public void setOperacionesDeEgreso(List<OperacionDeEgreso> operacionesDeEgreso) {
        this.operacionesDeEgreso = operacionesDeEgreso;
    }

}
