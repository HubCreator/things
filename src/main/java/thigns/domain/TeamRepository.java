package thigns.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select t from Team t")
    List<Team> myQuery();

    @Modifying
    @Query("update Team t set t.name = 'hubcreatorTeam'")
    void bulkQuery();
}
