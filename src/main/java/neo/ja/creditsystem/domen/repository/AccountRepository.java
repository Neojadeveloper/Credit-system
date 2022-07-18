package neo.ja.creditsystem.domen.repository;

import neo.ja.creditsystem.domen.credit.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface AccountRepository extends JpaRepository<Account, Integer>, BaseRepository {
//    @Query(value = "delete from credit.credit.account a where a.code =:code", nativeQuery = true)
//    void deleteByCode(Integer code);
    @Modifying
    @Transactional
    void deleteAllByCode(Integer code);
}
