package negocio;

/**
 *
 * @author marcnetts
 */
public class Media implements IMedia {
    private float media;

    public float getMedia() {
        return media;
    }
    
    @Override
    public void calcularMedia(float p1, float p2){
        media = (p1 + p2) / 2;
    }

    @Override
    public void calcularMedia(float p1, float p2, float tp){
        media = (p1 + p2 + tp) / 3;
    }
    
}
