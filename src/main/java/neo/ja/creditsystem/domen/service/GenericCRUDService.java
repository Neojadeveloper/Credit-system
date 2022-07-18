package neo.ja.creditsystem.domen.service;

import java.util.List;

/**
 * @param <E>  Entity
 * @param <D>  DTO
 * @param <CD> CreateDTO
 * @param <UD> UpdateDTO
 * @param <K>  Key
 */
public interface GenericCRUDService<E, D, CD, UD, K> {

    D get(K id);

    E create(CD cd);

    void update(UD ud);

    void delete(K id);

    List<D> getAll();
}
