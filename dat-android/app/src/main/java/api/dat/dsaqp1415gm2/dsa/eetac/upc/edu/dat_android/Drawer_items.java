package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android;

public class Drawer_items {
    private String title;
    private int icon;

    public Drawer_items(String titulo, int icono)
    {
        this.title=titulo;
        this.icon=icono;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

}
