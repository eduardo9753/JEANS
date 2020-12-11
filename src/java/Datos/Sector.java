
package Datos;


public class Sector {
    
    private String idsector ;
    private String sector ;

    public Sector() {
    }

    public Sector(String idsector, String sector) {
        this.idsector = idsector;
        this.sector = sector;
    }

    public String getIdsector() {
        return idsector;
    }

    public void setIdsector(String idsector) {
        this.idsector = idsector;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    @Override
    public String toString() {
        return "Sector{" + "idsector=" + idsector + ", sector=" + sector + '}';
    }
}
