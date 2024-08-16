package vn.edu.hust.project.appledeviceservice.enitity.dto.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MetaDataWithTotalRecord extends MetaResource {
    private Long totalRecord;
    private Page pages;

    public MetaDataWithTotalRecord(Long totalRecord, Long pageSize, Long totalPage, Long nextPage, Long previousPage) {
        super((long) HttpStatus.OK.value(), "Success");

        this.totalRecord = totalRecord;

        var page = new Page();
        page.setTotalPage(totalPage);
        page.setNext(new NextQuery(pageSize, buildRawQuery(nextPage, pageSize), nextPage));
        page.setPrev(new PreviousQuery(pageSize, buildRawQuery(previousPage, pageSize), previousPage));

        this.pages = page;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Page {
        private Long totalPage;
        private NextQuery next;
        private PreviousQuery prev;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Query {
        private Long pageSize;
        private String rawQuery;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class NextQuery extends Query {
        private Long nextPage;

        public NextQuery(Long pageSize, String rawQuery, Long nextPage) {
            super(pageSize, rawQuery);
            this.nextPage = nextPage;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class PreviousQuery extends Query {
        private Long prevPage;

        public PreviousQuery(Long pageSize, String rawQuery, Long prevPage) {
            super(pageSize, rawQuery);
            this.prevPage = prevPage;
        }
    }

    private String buildRawQuery(Long page, Long pageSize) {
        return String.format("page=%d&page_size=%d", page, pageSize);
    }
}
