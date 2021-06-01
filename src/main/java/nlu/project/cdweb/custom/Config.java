package nlu.project.cdweb.custom;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


public class Config {
    public static final int LISTPRODUCT = 18;
    public static final int COMMENTITEMS = 10;
    public static final int HOMEITEMS = 16;
    public static final int COMPAREITEMS = 3;

    public static Sort orderByIdAsc() {
        return Sort.by(Sort.Direction.DESC, "id");
    }
    public static Pageable homeProducts(Sort sort){
        return PageRequest.of(0, HOMEITEMS,sort);
    }
}
