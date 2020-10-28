package Conexion;

public class Cliente {

    private String id;
    private String notes;

    public Cliente() {
        this.id = "";
        this.notes = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return id;
    }

}
