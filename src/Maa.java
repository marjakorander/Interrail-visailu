public class Maa {
    private String kysymys;
    private String oikeaVastaus;

    public Maa(String kysymys, String oikeaVastaus) {
        this.kysymys = kysymys;
        this.oikeaVastaus = oikeaVastaus;
    }

    public Maa() {
    }

    public String getKysymys() {
        return kysymys;
    }

    public void setKysymys(String kysymys) {
        this.kysymys = kysymys;
    }

    public String getOikeaVastaus() {
        return oikeaVastaus;
    }

    public void setOikeaVastaus(String oikeaVastaus) {
        this.oikeaVastaus = oikeaVastaus;
    }
}
