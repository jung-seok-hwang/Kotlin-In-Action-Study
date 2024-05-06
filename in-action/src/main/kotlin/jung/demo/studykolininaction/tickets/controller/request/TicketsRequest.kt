package jung.demo.studykolininaction.tickets.controller.request

import jung.demo.studykolininaction.tickets.entity.Tickets


data class TicketsRequest(
    val seatNumber: String,
    val purchaseStatus: Boolean,
    val purchaseUser: String,
) {

    fun toTicket(): Tickets {
        return Tickets(
            seatNumber = this.seatNumber,
            purchaseStatus = this.purchaseStatus,
            purchaseUser = this.purchaseUser
        )
    }
}