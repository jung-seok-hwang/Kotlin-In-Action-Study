package jung.demo.studykolininaction.ch5.repository

import jakarta.persistence.LockModeType
import jung.demo.studykolininaction.ch5.entity.Tickets
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Lock


interface TicketsRepository : JpaRepository<Tickets, Int> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    fun findWithWriterLockBySeatNumber(seatNumber: String): Tickets

}