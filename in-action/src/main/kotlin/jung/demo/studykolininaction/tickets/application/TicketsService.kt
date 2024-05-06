package jung.demo.studykolininaction.tickets.application

import jakarta.transaction.Transactional
import jung.demo.studykolininaction.tickets.controller.request.TicketsRequest
import jung.demo.studykolininaction.tickets.entity.Tickets
import jung.demo.studykolininaction.tickets.repository.TicketsRepository
import org.springframework.stereotype.Service


@Service
class TicketsService(
    private val ticketsRepository: TicketsRepository,
) {

    @Transactional
    fun buy(tickets: TicketsRequest): Tickets {

        try {
            val findWithWriterLockBySeatNumber = ticketsRepository.findWithWriterLockBySeatNumber(tickets.seatNumber)

            if (!findWithWriterLockBySeatNumber.purchaseStatus) {
                synchronized(findWithWriterLockBySeatNumber) {
                    Thread.sleep(20000) // Simulate some processing time
                    findWithWriterLockBySeatNumber.buy(tickets.purchaseUser, tickets.purchaseStatus)
                    return findWithWriterLockBySeatNumber
                }
            }
            
            throw IllegalArgumentException("다른 사용자가 이미 예약 했습니다.")
        } catch (e: Exception) {
            throw IllegalStateException("Failed to save ticket", e)
        }
    }


    fun save(tickets: TicketsRequest): Tickets {
        val toTicket = tickets.toTicket()
        return ticketsRepository.save(toTicket)
    }

    fun all(): List<Tickets> {

        return ticketsRepository.findAll() ?: throw IllegalArgumentException("ticketsRepository Not Found")
    }

}