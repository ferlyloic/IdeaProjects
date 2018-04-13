package grailstest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DailyReportController {

    DailyReportService dailyReportService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond dailyReportService.list(params), model:[dailyReportCount: dailyReportService.count()]
    }

    def show() {
        redirect(action: "edit", id: params.id)
//        respond dailyReportService.get(id)
    }

    def create() {
        println params
        respond new DailyReport(params)
    }

    def save(DailyReport dailyReport) {
        println params
        if (dailyReport == null) {
            notFound()
            return
        }

        try {
            dailyReportService.save(dailyReport)
        } catch (ValidationException e) {
            respond dailyReport.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dailyReport.label', default: 'DailyReport'), dailyReport.id])
                redirect dailyReport
            }
            '*' { respond dailyReport, [status: CREATED] }
        }
    }

    def edit(Long id) {
        params.clear()
        println "this ist $params"
        println(dailyReportService.get(id))
        respond dailyReportService.get(id)
    }

    def update(DailyReport dailyReport) {
        if (dailyReport == null) {
            notFound()
            return
        }

        try {
            dailyReportService.save(dailyReport)
        } catch (ValidationException e) {
            respond dailyReport.errors, view:'edit'
            return
        }

        println params
        redirect(action: 'edit', id: dailyReport.getId())
//        request.withFormat {
//            form multipartForm {
//                flash.message = message(code: 'default.updated.message', args: [message(code: 'dailyReport.label', default: 'DailyReport'), dailyReport.id])
//                redirect dailyReport
//            }
//            '*'{ respond dailyReport, [status: OK] }
//        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        dailyReportService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dailyReport.label', default: 'DailyReport'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dailyReport.label', default: 'DailyReport'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
