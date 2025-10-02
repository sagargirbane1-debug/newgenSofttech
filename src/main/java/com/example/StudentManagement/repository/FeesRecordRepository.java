package com.example.StudentManagement.repository;

import com.example.StudentManagement.entity.StudentFeesRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeesRecordRepository extends JpaRepository<StudentFeesRecord,Long> {

    // Sum of total fees
    @Query("SELECT SUM(f.totalfees) FROM StudentFeesRecord f")
    Double getTotalFees();

    // Sum of paid fees
    @Query("SELECT SUM(f.paidfees) FROM StudentFeesRecord f")
    Double getTotalPaidFees();

    // Sum of remaining/pending fees
    @Query("SELECT SUM(f.remainngfees) FROM StudentFeesRecord f")
    Double getTotalPendingFees();
}
