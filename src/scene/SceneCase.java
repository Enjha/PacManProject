package scene;

import java.util.List;

public interface SceneCase {

    int getX();

    int getY();

    void removeCaseContent(Object object);

    void addCaseContent(Object object);

    List<Object> getCaseContent(String typeOfElement);
}
