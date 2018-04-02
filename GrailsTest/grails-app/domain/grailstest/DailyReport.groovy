package grailstest

import java.awt.TextField
import java.time.LocalDate

class DailyReport {
    String titel
    Date date
    String description

    static constraints = {
        titel(default: 'new Titel', nulable: false, blank: false, maxSize: 100)
        date(nulable: false, blank: false)
        description(default: 'new description', nulable: false, blank: true, maxSize: 1000000)
    }
}
