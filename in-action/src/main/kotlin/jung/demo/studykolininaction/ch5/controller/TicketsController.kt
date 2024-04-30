package jung.demo.studykolininaction.ch5.controller

import jung.demo.studykolininaction.ch5.application.TicketsService
import jung.demo.studykolininaction.ch5.controller.request.TicketsRequest
import jung.demo.studykolininaction.ch5.entity.Tickets
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TicketsController (
    private val ticketsService: TicketsService
) {

    @GetMapping("/tickets")
    fun all() :ResponseEntity<List<Tickets>>{
        val all = ticketsService.all()
        return ResponseEntity.ok().body(all)
    }


    @PostMapping("/buy")
    fun buy(@RequestBody tickets: TicketsRequest): ResponseEntity<Tickets> {
        val buy = ticketsService.buy(tickets)
        return ResponseEntity.ok().body(buy)
    }

    @PostMapping
    fun save(@RequestBody tickets: TicketsRequest): ResponseEntity<Tickets> {
        val save = ticketsService.save(tickets)
        return ResponseEntity.ok().body(save)
    }



}