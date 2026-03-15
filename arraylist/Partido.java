public class Partido {
    private String local;
    private String visitante;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String local, String visitante, int golesLocal, int golesVisitante) {
        this.local = local;
        this.visitante = visitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
    }

    public boolean ganoVisitante() { return golesVisitante > golesLocal; }
    public boolean ganoLocal() { return golesLocal > golesVisitante; }
    public boolean esEmpate() { return golesLocal == golesVisitante; }
    public String getLocal() { return local; }
    public String getVisitante() { return visitante; }
    
    @Override
    public String toString() {
        return local + " " + golesLocal + " - " + golesVisitante + " " + visitante;
    }
}
