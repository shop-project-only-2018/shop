package shop.dtos.pagination;

import shop.dtos.DTO;

import java.util.ArrayList;
import java.util.List;

public class PageDTO<T> implements DTO {
    private List<T> items;
    private Integer pageNumber;
    private Integer numberOfPages;

    public PageDTO() {
        items = new ArrayList<>();
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
