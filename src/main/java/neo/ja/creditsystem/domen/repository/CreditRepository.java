package neo.ja.creditsystem.domen.repository;


import neo.ja.creditsystem.domen.credit.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Integer>, BaseRepository {

}
