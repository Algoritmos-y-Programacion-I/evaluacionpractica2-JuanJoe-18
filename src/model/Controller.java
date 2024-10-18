package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {

        pillars = new Pillar[4];

        preLoadPillars();
        preLoadProyects();

    }

    public void preLoadPillars() {

        pillars[0] = new Pillar("Social");
        pillars[1] = new Pillar("Economic");
        pillars[2] = new Pillar("Environmental");
        pillars[3] = new Pillar("Institutional");

    }

    public void preLoadProyects() {
        pillars[0].registerProject(new Project("1", "Proyecto 1", "Descripcion 1", true));
        pillars[0].registerProject(new Project("2", "Proyecto 2", "Descripcion 2", true));
        pillars[0].registerProject(new Project("3", "Proyecto 3", "Descripcion 3", true));
        pillars[0].registerProject(new Project("4", "Proyecto 4", "Descripcion 4", true));
        pillars[0].registerProject(new Project("5", "Proyecto 5", "Descripcion 5", true));
        pillars[1].registerProject(new Project("6", "Proyecto 6", "Descripcion 6", true));
        pillars[1].registerProject(new Project("7", "Proyecto 7", "Descripcion 7", true));
        pillars[1].registerProject(new Project("8", "Proyecto 8", "Descripcion 8", true));
        pillars[1].registerProject(new Project("9", "Proyecto 9", "Descripcion 9", true));
        pillars[1].registerProject(new Project("10", "Proyecto 10", "Descripcion 10", true));
        pillars[1].registerProject(new Project("11", "Proyecto 11", "Descripcion 11", true));
        pillars[1].registerProject(new Project("12", "Proyecto 12", "Descripcion 12", true));
        pillars[2].registerProject(new Project("13", "Proyecto 13", "Descripcion 13", true));
        pillars[2].registerProject(new Project("14", "Proyecto 14", "Descripcion 14", true));
        pillars[2].registerProject(new Project("15", "Proyecto 15", "Descripcion 15", true));
        pillars[2].registerProject(new Project("16", "Proyecto 16", "Descripcion 16", true));
        pillars[3].registerProject(new Project("17", "Proyecto 17", "Descripcion 17", true));
        pillars[3].registerProject(new Project("18", "Proyecto 18", "Descripcion 18", true));
        pillars[3].registerProject(new Project("19", "Proyecto 19", "Descripcion 19", true));
        pillars[3].registerProject(new Project("20", "Proyecto 20", "Descripcion 20", true));

    }

    /**
     * Descripcion: Permite crear y añadir un Project en un Pillar en el sistema
     *
     * @return boolean true si se logra añadir el Prject en el Pillar, false en
     * caso contrario
     */
    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {
        switch (pillarType) {
            case 1:
                pillars[0].registerProject(new Project(id, name, description, status));
                break;
            case 2:
                pillars[1].registerProject(new Project(id, name, description, status));
                break;
            case 3:
                pillars[2].registerProject(new Project(id, name, description, status));
                break;
            case 4:
                pillars[3].registerProject(new Project(id, name, description, status));
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Descripcion: Calcula el valor en dinero correspondiente al arrendamiento
     * mensual de todos los Edificios pre: El arreglo edificios debe estar
     * inicializado
     *
     * @return String cadena en formato lista con la información de los Project
     * registrados en el Pillar
     */
    public String queryProjectsByPillar(int pillarType) {
        String query = "";
        switch (pillarType) {
            case 1:
                query = pillars[0].getProjectList();
                break;
            case 2:
                query = pillars[1].getProjectList();
                break;
            case 3:
                query = pillars[2].getProjectList();
                break;
            case 4:
                query = pillars[3].getProjectList();
                break;
            default:
                break;
        }
        query = query.replace("true", "Active").replace("false", "Inactive");

        return query;

    }

}
