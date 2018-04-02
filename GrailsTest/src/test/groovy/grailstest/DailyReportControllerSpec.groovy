package grailstest

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import grails.validation.ValidationException
import spock.lang.*

class DailyReportControllerSpec extends Specification implements ControllerUnitTest<DailyReportController>, DomainUnitTest<DailyReport> {

    def populateValidParams(params) {
        assert params != null

        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
        assert false, "TODO: Provide a populateValidParams() implementation for this generated test suite"
    }

    void "Test the index action returns the correct model"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * list(_) >> []
            1 * count() >> 0
        }

        when:"The index action is executed"
        controller.index()

        then:"The model is correct"
        !model.dailyReportList
        model.dailyReportCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
        controller.create()

        then:"The model is correctly created"
        model.dailyReport!= null
    }

    void "Test the save action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/dailyReport/index'
        flash.message != null
    }

    void "Test the save action correctly persists"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * save(_ as DailyReport)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        populateValidParams(params)
        def dailyReport = new DailyReport(params)
        dailyReport.id = 1

        controller.save(dailyReport)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/dailyReport/show/1'
        controller.flash.message != null
    }

    void "Test the save action with an invalid instance"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * save(_ as DailyReport) >> { DailyReport dailyReport ->
                throw new ValidationException("Invalid instance", dailyReport.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'POST'
        def dailyReport = new DailyReport()
        controller.save(dailyReport)

        then:"The create view is rendered again with the correct model"
        model.dailyReport != null
        view == 'create'
    }

    void "Test the show action with a null id"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.show(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the show action with a valid id"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * get(2) >> new DailyReport()
        }

        when:"A domain instance is passed to the show action"
        controller.show(2)

        then:"A model is populated containing the domain instance"
        model.dailyReport instanceof DailyReport
    }

    void "Test the edit action with a null id"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * get(null) >> null
        }

        when:"The show action is executed with a null domain"
        controller.edit(null)

        then:"A 404 error is returned"
        response.status == 404
    }

    void "Test the edit action with a valid id"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * get(2) >> new DailyReport()
        }

        when:"A domain instance is passed to the show action"
        controller.edit(2)

        then:"A model is populated containing the domain instance"
        model.dailyReport instanceof DailyReport
    }


    void "Test the update action with a null instance"() {
        when:"Save is called for a domain instance that doesn't exist"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(null)

        then:"A 404 error is returned"
        response.redirectedUrl == '/dailyReport/index'
        flash.message != null
    }

    void "Test the update action correctly persists"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * save(_ as DailyReport)
        }

        when:"The save action is executed with a valid instance"
        response.reset()
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        populateValidParams(params)
        def dailyReport = new DailyReport(params)
        dailyReport.id = 1

        controller.update(dailyReport)

        then:"A redirect is issued to the show action"
        response.redirectedUrl == '/dailyReport/show/1'
        controller.flash.message != null
    }

    void "Test the update action with an invalid instance"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * save(_ as DailyReport) >> { DailyReport dailyReport ->
                throw new ValidationException("Invalid instance", dailyReport.errors)
            }
        }

        when:"The save action is executed with an invalid instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'PUT'
        controller.update(new DailyReport())

        then:"The edit view is rendered again with the correct model"
        model.dailyReport != null
        view == 'edit'
    }

    void "Test the delete action with a null instance"() {
        when:"The delete action is called for a null instance"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(null)

        then:"A 404 is returned"
        response.redirectedUrl == '/dailyReport/index'
        flash.message != null
    }

    void "Test the delete action with an instance"() {
        given:
        controller.dailyReportService = Mock(DailyReportService) {
            1 * delete(2)
        }

        when:"The domain instance is passed to the delete action"
        request.contentType = FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete(2)

        then:"The user is redirected to index"
        response.redirectedUrl == '/dailyReport/index'
        flash.message != null
    }
}






