package Scene;

import java.util.List;

public interface CaseContentManager {

    void addContent(String typeOfContent, Object content);
    List<Object> getContent(String typeOfContent);
    void removeContent(String typeOfContent, Object element);
}
