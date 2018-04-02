package grailstest

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CoupleController {

    CoupleService coupleService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        println(params)
        respond coupleService.list(params), model:[coupleCount: coupleService.count()]
    }

    def show(Long id) {
        respond coupleService.get(id)
    }

    def create() {
        respond new Couple(params)
    }

    def save(Couple couple) {
        if (couple == null) {
            notFound()
            return
        }

        try {
            coupleService.save(couple)
        } catch (ValidationException e) {
            respond couple.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'couple.label', default: 'Couple'), couple.id])
                redirect couple
            }
            '*' { respond couple, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond coupleService.get(id)
    }

    def update(Couple couple) {
        if (couple == null) {
            notFound()
            return
        }

        try {
            coupleService.save(couple)
        } catch (ValidationException e) {
            respond couple.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'couple.label', default: 'Couple'), couple.id])
                redirect couple
            }
            '*'{ respond couple, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        coupleService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'couple.label', default: 'Couple'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'couple.label', default: 'Couple'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
