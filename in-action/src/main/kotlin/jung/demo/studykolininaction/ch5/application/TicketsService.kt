package jung.demo.studykolininaction.ch5.application

import jakarta.transaction.Transactional
import jung.demo.studykolininaction.ch5.controller.request.TicketsRequest
import jung.demo.studykolininaction.ch5.entity.Tickets
import jung.demo.studykolininaction.ch5.repository.TicketsRepository
import org.springframework.stereotype.Service


@Service
class TicketsService(
    private val ticketsRepository: TicketsRepository,
) {



    @Transactional
    fun buy(tickets: TicketsRequest): Tickets {

        return try {
            val findWithWriterLockBySeatNumber = ticketsRepository.findWithWriterLockBySeatNumber(tickets.seatNumber)

            println(findWithWriterLockBySeatNumber)
            Thread.sleep(2000)

            if (!findWithWriterLockBySeatNumber.purchaseStatus) {
                findWithWriterLockBySeatNumber.buy(tickets.purchaseUser,tickets.purchaseStatus)
            }

            findWithWriterLockBySeatNumber
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