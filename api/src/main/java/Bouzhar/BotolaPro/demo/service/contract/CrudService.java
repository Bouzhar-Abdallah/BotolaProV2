package Bouzhar.BotolaPro.demo.service.contract;

import Bouzhar.BotolaPro.demo.dto.ArticleDto;

import java.util.List;

public interface CrudService<T, PT> {
    T create(T entity);
    T update(T entity);
    void deleteById(PT id);
    ArticleDto findById(PT id);
    List<T> getAll();
}
