package jung.demo.studykolininaction.ch5.controller.request

import jung.demo.studykolininaction.ch5.entity.Tickets


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