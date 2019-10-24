package fr.pb.entities;

/**
 *
 * @author Pays
 */
public class Pays {

    private String id;
    private String idPays;
    private String nomPays;

    public Pays() {
    }

    public Pays(String id, String idPays, String nomPays) {
        this.id = id;
        this.idPays = idPays;
        this.nomPays = nomPays;
    }

    public Pays(String idPays, String nomPays) {
        this.idPays = idPays;
        this.nomPays = nomPays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPays() {
        return idPays;
    }

    public void setIdPays(String idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    @Override
    public String toString() {
        return "Pays{" + "id=" + id + ", idPays=" + idPays + ", nomPays=" + nomPays + '}';
    }

} /// class
