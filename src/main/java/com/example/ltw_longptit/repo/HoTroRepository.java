package com.example.ltw_longptit.repo;

import com.example.ltw_longptit.model.HoTro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HoTroRepository extends JpaRepository<HoTro, Integer> {
    @Query(value="SELECT s.* FROM ho_tro s INNER JOIN kham t on t.id_kham=s.id_kham WHERE t.datein LIKE %:keyword% AND s.id_yta = :id ;",nativeQuery = true)
    public List<HoTro> getHoTroTheoIdYTa(String keyword, String id);


    @Query(value="SELECT s.* FROM ho_tro s where s.id_kham = :id",nativeQuery = true)
    public List<HoTro> getYTaTheoIdKham(String id);


    @Query(value="SELECT count(s.id ) FROM ho_tro s INNER JOIN kham t on t.id_kham=s.id_kham WHERE t.datein LIKE %:keyword% AND s.id_yta = :id ;",nativeQuery = true)
    public Integer getSoLanHoTro(String keyword, String id);

    @Transactional
    @Modifying
    @Query(value = "delete from ho_tro where id_kham = :id ",nativeQuery = true)
    public void deleteHoTroTheoIdKham(String id);

    
}
