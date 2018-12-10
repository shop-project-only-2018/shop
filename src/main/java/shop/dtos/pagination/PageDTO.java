package shop.dtos.pagination;

import shop.dtos.DTO;

import java.util.ArrayList;
import java.util.List;

public class PageDTO<T> implements DTO {

    private List<T> items = new ArrayList<>();
    private Integer pageNumber;
    private Long numberOfPages;

    public PageDTO() {
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

    public Long getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Long numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void add(T item) {
        items.add(item);
    }

}
