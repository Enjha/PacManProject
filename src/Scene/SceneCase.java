package Scene;

import java.util.List;

public interface SceneCase {

    int getX();
    int getY();
    double getHeight();
    double getWidth();
    boolean removeCaseContent(Object object);
    boolean addCaseContent(Object object);
    List<Object> getCaseContent();
}
