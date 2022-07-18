package neo.ja.creditsystem.domen.service;

import neo.ja.creditsystem.domen.mapper.BaseMapper;
import neo.ja.creditsystem.domen.repository.BaseRepository;

public abstract class AbstractService<
        R extends BaseRepository,
        M extends BaseMapper> {

    protected R repository;
    protected M mapper;

    protected AbstractService(R repository, M mapper){
        this.repository=repository;
        this.mapper = mapper;
    }

}
