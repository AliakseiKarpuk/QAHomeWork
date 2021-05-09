package models.apiModels;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.testng.collections.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@ToString
@Builder
public class Listuser {

    int page;
    int per_page;
    int total;
    int total_pages;
    List data;
    Object support;

}
